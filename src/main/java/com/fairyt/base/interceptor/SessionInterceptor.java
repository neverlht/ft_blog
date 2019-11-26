package com.fairyt.base.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.constants.Constants;
import com.fairyt.base.exception.BaseError;
import com.fairyt.base.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
//        String[] writeBill = {"/","/api/login"};
//        // 请求格式：/api/gpu/cam/alert/{camNo}/{time}
//        for(String bill:writeBill){
//            if(request.getRequestURI().equals(bill)){
//                return true;
//            }
//        }
//        final String authHeader = request.getHeader("authorization");
//
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            throw new BaseError("缺失授权信息",Constants.RequestCode.TOKENLOST);
//        }
//        // Then get the JWT token from authorization
//        final String token = authHeader.substring(7);
//        try{
////            final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
//            final Claims claims = JWTUtil.parseJWT(token);
//            // todo 校验主体内容中用户信息合法性
////            JSONObject loginUser = JSONObject.parseObject(claims.getSubject());
//            JSONObject loginUser = new JSONObject(claims);
//            request.setAttribute(Constants.Current.USER, loginUser);
//        }catch (Exception e){
//            throw new BaseError("用户会话已过期，请重新授权",Constants.RequestCode.TOKENERROR);
//        }
        return true;
    }
}
