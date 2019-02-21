package com.chen.springbootlearn.security;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;
import com.chen.springbootlearn.common.LocaleMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录认证失败处理
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    private LocaleMessage localeMessage;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(getResultJson(ErrorCode.USER_UNEXIST));
    }

    private String getResultJson(ErrorCode errorCode) {
        try {
            return new ObjectMapper().writeValueAsString(getApiResut(errorCode));
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private ApiResult getApiResut(ErrorCode errorCode) {
        int code = errorCode.getCode();
        String msgKey = errorCode.getMsgKey();
        String message = localeMessage.getMessage(msgKey);
        System.out.println(LocaleContextHolder.getLocale());
        System.out.println(message);
        return new ApiResult(code, message);
    }
}
