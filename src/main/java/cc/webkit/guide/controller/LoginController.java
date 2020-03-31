package cc.webkit.guide.controller;

import cc.webkit.guide.model.Resp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    JdbcTemplate jdbcTemplate;

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


    @GetMapping("/register")
    public String register(){
        return "register";
    }


    @ResponseBody
    @PostMapping("/doRegister")
    public String doRegister(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpSession session) throws JsonProcessingException {

        // todo: 密码要加密
        String sql = "INSERT INTO `admin` (`username`, `password`) VALUES (?, ?);";
        int result = jdbcTemplate.update(sql,username,password);
        ObjectMapper mapper = new ObjectMapper();

        // todo: 这里要返回 conte-type: json，方便前端使用
        Resp resp = result > 0 ? new Resp(0,"注册成功") : new Resp(-1,"注册失败");
        if (result > 0){
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
