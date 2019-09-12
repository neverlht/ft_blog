package com.fairyt.base.utils;

import com.fairyt.base.constants.Constants;

public class ResponseData {
    //返回码 1成功 0 失败
    private String returnCode;
    //返回消息
    private String returnMsg;
    //返回数据体
    private Object data;

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public Object getData(){
        return data;
    }

    public ResponseData(String returnCode, String returnMsg){
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public ResponseData(){
        this.returnCode = Constants.RequestCode.SUCCESS;
        this.returnMsg = "请求成功";
    }

    public ResponseData(Object data){
        this.data = data;
        this.returnCode = Constants.RequestCode.SUCCESS;
        this.returnMsg = "请求成功";
    }

    public ResponseData(Object data,String returnCode, String returnMsg){
        this.data = data;
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }
}
