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
import java.io.BufferedInputStream;
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
 * 文件上传  非表单方式 直接流的方式
 */
public class UploadFileServlet2 extends BaseServlet<UploadRespBean> {
    private static String uploadDir = "/WEB-INF/upload";
    @Override
    public BaseResponseBean<UploadRespBean> handlerRequest(HttpServletRequest request, HttpServletResponse resp) {
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
        //设置请求放回的数据类型
        String dataType = request.getHeader(DATA_TYPE);
        if(dataType!=null){
            request.setAttribute(DATA_TYPE,dataType);
        }
        //首先判断没有在请求头中添加文件的扩展名
        String fileExtension = request.getHeader("fileExtension");
       if(TextUtils.isEmpty(fileExtension)){
           baseResponseBean.setStatusCode(UPLOAD_HAVE_NOT_EX);
           return baseResponseBean;
       }
        try {
            baseResponseBean.setStatusCode(UPLOAD_HAVE_NOT_FILE);
            UploadRespBean uploadRespBean = new UploadRespBean();

            String filename = System.currentTimeMillis()+fileExtension;
            filename = Md5Utils.md5Encode(filename) + "." +filename.substring( filename.lastIndexOf(".")+1 );

            //获取输入流
            //创建文件输出流
            InputStream inputSteam=request.getInputStream();
            BufferedInputStream fis=new BufferedInputStream(inputSteam);
            FileOutputStream fos = new FileOutputStream(savePath+"\\"+filename);
            int f;
            while((f=fis.read())!=-1)
            {
                fos.write(f);
            }
            fos.flush();
            fos.close();
            fis.close();
            inputSteam.close();
            //设置提示
            uploadRespBean.fileName = filename;
            baseResponseBean.setStatusCode(OK);
            baseResponseBean.msg = "上传成功";
            baseResponseBean.t = uploadRespBean;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponseBean.setStatusCode(UPLOAD_FAIL);
        }
        return baseResponseBean;
    }
}
