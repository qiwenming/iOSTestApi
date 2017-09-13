package com.qwm.iostestapi.utils;

import com.qwm.iostestapi.response.BaseResponseBean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @author: wiming
 * @date: 2017-09-13 11:34:11  星期三
 * @decription:
 */
public class JaxbUtils {

    /**
     * JavaBean转换成xml
     * 默认编码UTF-8
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        return convertToXml(obj, "UTF-8");
    }

    /**
     * JavaBean转换成xml
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXml(Object obj, String encoding) {
        return convertToXml(obj,obj.getClass());
    }

    public static String convertToXml(Object obj,Class... clz){
        return convertToXml(obj,"UTF-8",clz);
    }

    /**
     * JavaBean转换成xml
     * @param clz
     * @param encoding
     * @return
     */
    public static String convertToXml(Object obj, String encoding, Class... clz) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clz);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
