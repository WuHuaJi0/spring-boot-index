package cc.webkit.guide.controller;

import cc.webkit.guide.model.Resp;
import cc.webkit.guide.model.Url;
import cc.webkit.guide.repository.UrlRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UrlRepository urlRepository;

    @RequestMapping("/")
    public String hello(Model model){
        List<Map<String, Object>> categories = jdbcTemplate.queryForList("select * from category");
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String,Object> category : categories){
            category.put("urls",jdbcTemplate.queryForList("select * from url where categoryId = " + category.get("id")));
            result.add(category);
        }
        model.addAttribute("categories",result);
        return "index";
    }

    @GetMapping("/submit")
    public String submit(Model model){
        List<Map<String, Object>> categories = jdbcTemplate.queryForList("select * from category");
        model.addAttribute("categories",categories);
        return "submit";
    }

    @ResponseBody
    @PostMapping("/submit")
    public String doSubmit(@RequestParam Map<String,Object> params) throws JsonProcessingException {
        String name = (String) params.get("name");
        String url = (String) params.get("url");
        String desc = (String) params.get("desc");
        long categoryID = (long) params.get("categoryId");
        Url u = urlRepository.save(new Url(name,url,categoryID,desc));
        ObjectMapper mapper = new ObjectMapper();

        // todo: 这里要返回 conte-type: json，方便前端使用
        Resp resp = u != null ? new Resp(0,"添加成功") : new Resp(-1,"添加失败");
        return mapper.writeValueAsString(resp);
    }
}
