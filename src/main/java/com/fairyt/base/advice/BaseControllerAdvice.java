package com.fairyt.base.advice;


import com.fairyt.base.constants.Constants;
import com.fairyt.base.exception.BaseError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BaseControllerAdvice {
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("returnCode", Constants.RequestCode.ERROR);
        map.put("returnMsg", ex.getMessage());
        return map;
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BaseError.class)
    public Map baseErrorHandler(BaseError ex) {
        Map map = new HashMap();
        map.put("returnCode",ex.getMessageCode());//返回具体错误编码
        map.put("returnMsg", ex.getMessage());
        return map;
    }
}
