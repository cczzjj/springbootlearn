package com.chen.springbootlearn.resolver;

import com.chen.springbootlearn.annotation.CurrentUser;
import com.chen.springbootlearn.constant.CurrentUserConstant;
import com.chen.springbootlearn.domain.SysUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override

    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println("----------supportsParameter-----------" + parameter.getParameterType());
        return parameter.getParameterType().isAssignableFrom(SysUser.class)// 判断是否能转成UserBase 类型
                && parameter.hasParameterAnnotation(CurrentUser.class);// 是否有CurrentUser注解
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        System.out.println("--------------resolveArgument-------------" + parameter);
        SysUser user = (SysUser) webRequest.getAttribute(CurrentUserConstant.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
        if (user != null) {
            return user;
        }
        throw new MissingServletRequestPartException(CurrentUserConstant.CURRENT_USER);
    }
}
