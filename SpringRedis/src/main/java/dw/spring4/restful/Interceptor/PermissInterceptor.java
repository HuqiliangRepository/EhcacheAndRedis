package dw.spring4.restful.Interceptor;

import dw.spring4.restful.exception.AuthorizationException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by root on 5/12/16.
 */
public class PermissInterceptor extends HandlerInterceptorAdapter {
    private List<String> excludedUrls;

    public List<String> getExcludedUrls() {
        return excludedUrls;
    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }


        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("username") == null || httpSession.getAttribute("password") == null) {
            System.out.println("拦截器在客户端访问URL在调用后端方法前执行..........");
            throw new AuthorizationException();
        } else {
            System.out.println("Session username=" + httpSession.getAttribute("username"));
            System.out.println("Session password=" + httpSession.getAttribute("password"));
            return true;

        }

    }
}
