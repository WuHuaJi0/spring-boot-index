package cc.webkit.guide.controller;

import cc.webkit.guide.model.Resp;
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

    @GetMapping("/submit")
    public String submit(Model model){
        List<Map<String, Object>> categories = jdbcTemplate.queryForList("select * from category");
        model.addAttribute("categories",categories);
        return "submit";
    }

    @ResponseBody
    @PostMapping("/submit")
    public String doSubmit(@RequestParam Map<String,Object> params) throws JsonProcessingException {
        String sql = "INSERT INTO `url` (`name`, `category_id`, `ursl`,`desc`) VALUES (?, ?, ?,?);";
        int result = jdbcTemplate.update(sql,params.get("name"),params.get("category_id"),params.get("url"),params.get("desc"));
        ObjectMapper mapper = new ObjectMapper();

        // todo: 这里要返回 conte-type: json，方便前端使用
        Resp resp = result > 0 ? new Resp(0,"添加成功") : new Resp(-1,"添加失败");
        return mapper.writeValueAsString(resp);
    }
}
