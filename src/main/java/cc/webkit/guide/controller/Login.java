package cc.webkit.guide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Login {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(){
        return "something";
    }


    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
}
