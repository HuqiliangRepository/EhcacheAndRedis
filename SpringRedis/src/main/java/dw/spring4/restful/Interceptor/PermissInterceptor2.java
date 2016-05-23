package dw.spring4.restful.Interceptor;

import dw.spring4.restful.exception.AuthorizationException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by root on 5/12/16.
 */
public class PermissInterceptor2 implements HandlerInterceptor {

    private List<String> excludedUrls;

    public List<String> getExcludedUrls() {
        return excludedUrls;
    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("在控制器方法执行之前启用拦截器........");

        String requestUri = httpServletRequest.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }


        HttpSession httpSession = httpServletRequest.getSession();
        if (httpSession.getAttribute("username") == null || httpSession.getAttribute("password") == null) {

            throw new AuthorizationException();
        } else {
            System.out.println("Session username=" + httpSession.getAttribute("username"));
            System.out.println("Session password=" + httpSession.getAttribute("password"));
            return true;

        }


    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("在控制器方法执行之后启用拦截器........");

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("在所有控制器方法调用完成之后准备释放资源........");

    }
}
