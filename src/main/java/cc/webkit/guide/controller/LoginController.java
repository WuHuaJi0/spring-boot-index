package cc.webkit.guide.controller;

import cc.webkit.guide.model.Admin;
import cc.webkit.guide.model.Resp;
import cc.webkit.guide.repository.AdminRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    AdminRepository repository;


    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @ResponseBody
    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) throws JsonProcessingException {

        Admin admin = repository.findByUsernameAndPassword(username, password);
        ObjectMapper mapper = new ObjectMapper();

        if (admin == null ) {
            // todo: 这里要返回 conte-type: json，方便前端使用
            return mapper.writeValueAsString(new Resp(-1, "用户名密码错误"));
        } else {
            session.setAttribute("user", admin.getUsername());
            return mapper.writeValueAsString(new Resp(0, "登录成功"));
        }
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }


    @ResponseBody
    @PostMapping("/doRegister")
    public String doRegister(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpSession session) throws JsonProcessingException {

        // todo: 密码要加密
        Admin admin = repository.save(new Admin(username,password));

        ObjectMapper mapper = new ObjectMapper();

        // todo: 这里要返回 conte-type: json，方便前端使用
        Resp resp = admin != null ? new Resp(0,"注册成功") : new Resp(-1,"注册失败");
        if (admin != null){
            session.setAttribute("user",username);
        }
        return mapper.writeValueAsString(resp);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) throws JsonProcessingException {
        session.removeAttribute("user");
        return "redirect:/";
    }

}
