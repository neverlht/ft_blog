package com.fairyt.base.constants;

public class Constants {

    public static class Current{

        public final static String USER="user";

    }

    public static class RequestCode{
        //请求成功
        public final static String SUCCESS = "1";
        //业务异常
        public final static String ERROR = "0";
        //token失效
        public final static String TOKENERROR = "302";
        //token丢失
        public final static String TOKENLOST = "301";
    }

}
