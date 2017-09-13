package com.qwm.iostestapi;

import com.qwm.iostestapi.utils.FileDownUtils;
import com.qwm.iostestapi.utils.Md5Utils;

public class Test {
    public static void main(String[] args){
        System.out.println( Md5Utils.md5Encode("123456") );
        System.out.println(Md5Utils.md5Encode(   Md5Utils.md5Encode("123456")  ));
//        downImageAndVideo();
    }

    public static void downImageAndVideo(){
        int indexAddOne;
        String numStr = "";
        for (int i = 0; i < 16; i++) {
            indexAddOne = i+1;
            numStr = indexAddOne+"";
            if( indexAddOne <10 ){
                numStr = "0"+indexAddOne;
            }
            String png = "http://120.25.226.186:32812/resources/images/minion_"+numStr+".png";
            String mp4 = "http://120.25.226.186:32812/resources/videos/minion_"+numStr+".mp4";
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(png+"-----"+Thread.currentThread());
                    FileDownUtils.saveUrlAs(png,"web/resources/images/"+png.substring(png.lastIndexOf("/")+1));
                    FileDownUtils.saveUrlAs(mp4,"web/resources/videos/"+mp4.substring(mp4.lastIndexOf("/")+1));
                }
            }).start();
        }
    }
}
