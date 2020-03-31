package cc.webkit.guide.controller;

import cc.webkit.guide.model.Resp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpSession session) throws JsonProcessingException {
        // todo: 校验用户名密码是否正确
        session.setAttribute("user","admin");
        ObjectMapper mapper = new ObjectMapper();

        // todo: 这里要返回 conte-type: json，方便前端使用
        return mapper.writeValueAsString(new Resp(0,"登录成功"));
    }


    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
}
