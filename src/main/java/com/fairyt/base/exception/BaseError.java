package com.fairyt.base.exception;


import com.fairyt.base.constants.Constants;

public class BaseError extends RuntimeException {

    private String msg;
    private String messageCode=Constants.RequestCode.ERROR;
    private Object[] arguments;

    /**
     * @param message 详细错误信息
     */
    public BaseError(String message) {
        super(message);
        arguments = null;
    }

    /**
     * @param message 详细错误信息
     * @param t       内嵌异常
     */
    public BaseError(String message, Throwable t) {
        super(message, t);
        arguments = null;
    }

    /**
     * @param message     详细错误信息
     * @param messageCode 错误信息编码(对应i18n编码)
     * @param arguments   根据错误信息编码解析错误信息时使用的参数
     */
    public BaseError(String message, String messageCode, Object... arguments) {
        super(message);
        this.messageCode = messageCode;
        this.arguments = arguments;
    }

    /**
     * @param message     详细错误信息
     * @param t           内嵌异常
     * @param messageCode 错误信息编码(对应i18n编码)
     * @param arguments   根据错误信息编码解析错误信息时使用的参数
     */
    public BaseError(String message, Throwable t, String messageCode, Object... arguments) {
        super(message);
        this.messageCode = messageCode;
        this.arguments = arguments;
    }

    public String getDefaultMessage() {
        return getMessage();
    }

    public String getMessageCode() {
        return messageCode;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
