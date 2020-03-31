package cc.webkit.guide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String hello(Model model){
        List<Map<String, Object>> categories = jdbcTemplate.queryForList("select * from category");
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String,Object> category : categories){
            category.put("urls",jdbcTemplate.queryForList("select * from url where category_id = " + category.get("id")));
            result.add(category);
        }
        model.addAttribute("categories",result);
        return "index";
    }


    @ResponseBody
    @GetMapping("/test")
    public List<Map<String,Object>> test(){
        List<Map<String, Object>> categories = jdbcTemplate.queryForList("select * from category");
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String,Object> category : categories){
            category.put("urls",jdbcTemplate.queryForList("select * from url where category_id = " + category.get("id")));
            result.add(category);
        }
        return result;
    }
}
