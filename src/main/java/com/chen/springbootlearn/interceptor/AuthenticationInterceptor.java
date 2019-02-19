package com.chen.springbootlearn.interceptor;

import com.chen.springbootlearn.annotation.LoginRequired;
import com.chen.springbootlearn.common.CurrentUserConstants;
import com.chen.springbootlearn.domain.User;
import com.chen.springbootlearn.exception.CommonException;
import com.chen.springbootlearn.service.UserService;
import com.chen.springbootlearn.util.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    public final static String ACCESS_TOKEN = "accessToken";
    @Autowired
    UserService userService;

    // 在业务处理器处理请求之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);

        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            // 判断是否存在令牌信息，如果存在，则允许登录
            String accessToken = request.getHeader("Authorization");

            if (null == accessToken) {
                throw new CommonException(401, "无token，请重新登录");
            } else {
                // 从Redis 中查看 token 是否过期
                Claims claims;
                try {
                    claims = TokenUtils.parseJWT(accessToken);
                } catch (ExpiredJwtException e) {
                    response.setStatus(401);
                    throw new CommonException(401, "token失效，请重新登录");
                } catch (SignatureException se) {
                    response.setStatus(401);
                    throw new CommonException(401, "token令牌错误");
                }

                String username = claims.getId();
                User user = userService.findByUsername(username);
                if (user == null) {
                    response.setStatus(401);
                    throw new CommonException(401, "用户不存在，请重新登录");
                }
                // 当前登录用户@CurrentUser
                request.setAttribute(CurrentUserConstants.CURRENT_USER, user);
                return true;
            }
        } else { // 不需要登录可请求
            return true;
        }
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) throws Exception {
    }

}
