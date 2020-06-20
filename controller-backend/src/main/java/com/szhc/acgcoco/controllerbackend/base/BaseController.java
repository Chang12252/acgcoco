package com.szhc.acgcoco.controllerbackend.base;

import com.szhc.acgcoco.base.entity.bo.AdminBO;
import com.szhc.acgcoco.base.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Component
public class BaseController {
    private static final long EXPIRY=60 * 60 * 24 * 30;//缓存有效期
    private static final String CURRENT_LOGIN_USER="currentLoginAdmin";  //标识

    @Autowired
    public RedisUtil redis;


    /**获取登录管理员*/
    public AdminBO getLoginAdmin (HttpServletRequest request ) {
        AdminBO adminBO=(AdminBO)this.getSession(request, CURRENT_LOGIN_USER);
        //adminBO.setId(1);
        return adminBO;
        //return (AdminBO) this.getSession(request, CURRENT_LOGIN_USER) ;
    }

    /**把管理员信息存入redis*/
    public void putLoginAdmin (AdminBO admin, HttpServletResponse response) {
        String uuid = UUID.randomUUID().toString();
        this.putSession(createKey(admin.getId()+uuid, CURRENT_LOGIN_USER), admin);
        this.setCookie(response,CURRENT_LOGIN_USER, createKey(admin.getId()+uuid, CURRENT_LOGIN_USER));
    }


    /**
     * 删除用户this.getSession(request, CURRENT_LOGIN_USER)
     */
    public void delLoginAdmin (HttpServletRequest request, HttpServletResponse response) {
        String key = this.getClientLoginID(request);
        redis.del(key);
        this.removeCookie(request,response,CURRENT_LOGIN_USER);
    }


    /**
     * 生成在redis中存储的key
     * @param loginId 登录用户ID
     * @param key key
     * @return
     */
    public String createKey (String loginId, String key) {
        return loginId + "@" + key ;
    }

    /**
     * 获取session
     * session存储格式为
     * loginUuid + @ + key
     * */
    public Object getSession (HttpServletRequest request , String key) {
        //System.out.println("-------"+getClientLoginID(request));
        return redis.get(this.getClientLoginID(request));
    }
    public String getClientLoginID(HttpServletRequest request) {
        return getCookie(request , CURRENT_LOGIN_USER) ;
    }

    /**
     * session赋值
     */
    private void putSession (String key , Object value) {
        redis.set(key , value , EXPIRY);
    }

    /**
     * 设置Cookie
     * @param response
     * @param key
     * @param value
     */
    public void setCookie(HttpServletResponse response, String key , String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge((int)EXPIRY);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


    /**
     * 获取Cookie
     * @param request
     * @param key
     * @return
     */
    public String getCookie(HttpServletRequest request , String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return null ;
        }
        for(Cookie c :cookies ){
            if (c.getName().equals(key)) {
                return c.getValue() ;
            }
        }
        return null ;
    }

    /**
     * 删除Cookie
     * @param request
     * @param response
     * @param key
     */
    public void removeCookie (HttpServletRequest request , HttpServletResponse response , String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return  ;
        }
        for(Cookie c :cookies ){
            if (c.getName().equals(key)) {
                c.setMaxAge(0);
                c.setValue(null);
                c.setPath("/");
                response.addCookie(c);
            }
        }
    }

    /**
     * 异步返回结果
     *
     * @param response
     * @param str
     */
    public void responsePrint(HttpServletResponse response, String str) {

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = null;
        try {
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.write(str);
        } finally {
            if (out != null)
                out.close();
        }
    }


    /**
     * 常用参数验证
     */
    public boolean verifyParam(Object... obj) {
        if (obj == null || obj.length < 1) {
            return false;
        }
        for (Object o : obj) {
            if (o instanceof String) {
                if (StringUtils.isEmpty((String) o)) {
                    return false;
                }
            } else {
                if (o == null) {
                    return false;
                }
            }
        }
        return true;

    }
}
