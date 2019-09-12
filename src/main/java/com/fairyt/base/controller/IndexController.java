package com.fairyt.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.constants.Constants;
import com.fairyt.base.exception.BaseError;
import com.fairyt.base.model.DemoModel;
import com.fairyt.base.model.UserModel;
import com.fairyt.base.service.DemoService;
import com.fairyt.base.service.UserService;
import com.fairyt.base.utils.JWTUtil;
import com.fairyt.base.utils.ResponseData;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IndexController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseData login(@RequestBody JSONObject data, HttpServletResponse response){
        String userName = data.getString ("userName");
        String password = data.getString ("password");
        UserModel queryUser = new UserModel();
        queryUser.setUserName(userName);
        UserModel dbUser = service.findOne(queryUser);
        if (dbUser == null) {
            throw new BaseError("用户名/密码错误");
        }
        if(!password.equals(dbUser.getPassword())){
            throw new BaseError("用户名/密码错误");
        }

        JSONObject obj = new JSONObject();
        obj.put("id",dbUser.getId());
        obj.put("userName",dbUser.getUserName());
        obj.put("realName",dbUser.getRealName());
        String jwtToken =JWTUtil.createJWT(obj);
        Cookie cookie = new Cookie ("_login_token", jwtToken);
        response.addCookie (cookie);
        cookie.setMaxAge (30 * 24 * 60 * 60);
        return new ResponseData(jwtToken,Constants.RequestCode.SUCCESS,"登陆成功");
    }
}
