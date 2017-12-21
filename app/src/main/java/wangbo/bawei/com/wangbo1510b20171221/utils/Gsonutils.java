package wangbo.bawei.com.wangbo1510b20171221.utils;

import com.google.gson.Gson;

/**
 * author:Created by Wangbo on 2017/12/21.
 */

public class Gsonutils {
    private static Gson gson;

    public static Gson getInstance(){
        if(gson==null){
            gson=new Gson();
        }
        return gson;
    }
}
