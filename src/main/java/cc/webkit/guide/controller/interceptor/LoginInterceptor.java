package cc.webkit.guide.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        HttpSession session = request.getSession(true);
//        if (session.getAttribute("user") != null &&  session.getAttribute("user").equals("admin")) {
//            request.setAttribute("user", "admin");
//        } else {
//            request.setAttribute("user", "nihao");
//        }
        return true;
    }
}
