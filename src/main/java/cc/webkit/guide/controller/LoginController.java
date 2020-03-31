package cc.webkit.guide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String doLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        // todo: 校验用户名密码是否正确
        return "username" + username + "password" + password;
    }



//    @RequestMapping("/test/cookie")
//    public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session) {
//        //取出session中的browser
//        Object sessionBrowser = session.getAttribute("browser");
//        if (sessionBrowser == null) {
//            System.out.println("不存在session，设置browser=" + browser);
//            session.setAttribute("browser", browser);
//        } else {
//            System.out.println("存在session，browser=" + sessionBrowser.toString());
//        }
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null && cookies.length > 0) {
//            for (Cookie cookie : cookies) {
//                System.out.println(cookie.getName() + " : " + cookie.getValue());
//            }
//        }
//        return "index";
//    }


    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
}
