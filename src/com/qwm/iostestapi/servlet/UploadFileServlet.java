package com.qwm.iostestapi.servlet;

import com.qwm.iostestapi.response.BaseResponseBean;
import com.qwm.iostestapi.response.UploadRespBean;
import com.qwm.iostestapi.utils.Md5Utils;
import com.qwm.iostestapi.utils.TextUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import static com.qwm.iostestapi.common.Contanst.DATA_TYPE;
import static com.qwm.iostestapi.response.ResponseStatusCode.*;

/**
 * @author: wiming
 * @date: 2017-09-13 13:52:44  星期三
 * @decription:
 * 文件上传
 */
public class UploadFileServlet extends BaseServlet<UploadRespBean> {
    private static String uploadDir = "/WEB-INF/upload";
    @Override
    public BaseResponseBean<UploadRespBean> handlerRequest(HttpServletRequest req, HttpServletResponse resp) {
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = getServletContext().getRealPath(uploadDir);
        //判断文件夹是否存在，不存在创建
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        System.out.println(savePath);
        BaseResponseBean baseResponseBean = new BaseResponseBean();
        baseResponseBean.setStatusCode(OK);
        baseResponseBean.msg = "上传成功";

        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2.创建文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            //3.判断提交的数据是否是表单
            if(!ServletFileUpload.isMultipartContent(req)){
                baseResponseBean.setStatusCode(UPLOAD_FROM_UPLOAD);
                return baseResponseBean;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，
            // 每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(req);
            //5.迭代
            baseResponseBean.setStatusCode(UPLOAD_HAVE_NOT_FILE);
            UploadRespBean uploadRespBean = new UploadRespBean();
            for (FileItem item:list) {
                if(item.isFormField()){
                    if("userName".equals( item.getFieldName() ) ){
                        uploadRespBean.userName = item.getString("UTF-8");
                    }else if(DATA_TYPE.equals( item.getFieldName() )){
                        req.setAttribute(DATA_TYPE ,item.getString("UTF-8"));
                    }
                }else{//上传的文件
                    //文件名称
                    String filename = item.getName();
                    if(TextUtils.isEmpty(filename)){
                        continue;
                    }
                    filename = Md5Utils.md5Encode(filename) + "." +filename.substring( filename.lastIndexOf(".")+1 );
                    //获取输入流
                    InputStream in = item.getInputStream();
                    //创建文件输出流
                    FileOutputStream fout = new FileOutputStream(savePath+"\\"+filename);
                    //创建缓冲区
                    byte[] buf = new byte[1024];
                    int len = 0;
                    //循环读写数据
                    while( (len=in.read(buf)) >0){
                        fout.write(buf,0,len);
                    }
                    fout.flush();
                    fout.close();
                    in.close();
                    item.delete();
                    //设置提示
                    uploadRespBean.fileName = filename;
                    baseResponseBean.setStatusCode(OK);
                    baseResponseBean.msg = "上传成功";
                    baseResponseBean.t = uploadRespBean;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseResponseBean.setStatusCode(UPLOAD_FAIL);
        }
        return baseResponseBean;
    }
}
