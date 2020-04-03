package cc.webkit.guide.controller;

import cc.webkit.guide.model.Resp;
import cc.webkit.guide.model.Url;
import cc.webkit.guide.repository.CategoryRepository;
import cc.webkit.guide.repository.UrlRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("categories",categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/submit")
    public String submit(Model model){
        model.addAttribute("categories",categoryRepository.findAll());
        return "submit";
    }

    @ResponseBody
    @PostMapping("/submit")
    public String doSubmit(@RequestParam Map<String,Object> params) throws JsonProcessingException {
        String name = (String) params.get("name");
        String url = (String) params.get("url");
        String description = (String) params.get("description");
        long categoryID = Long.parseLong((String) params.get("categoryId"));
        Url u = urlRepository.save(new Url(name,url,categoryID,description));
        ObjectMapper mapper = new ObjectMapper();
        // todo: 这里要返回 conte-type: json，方便前端使用
        Resp resp = u != null ? new Resp(0,"添加成功") : new Resp(-1,"添加失败");
        return mapper.writeValueAsString(resp);
    }
}
