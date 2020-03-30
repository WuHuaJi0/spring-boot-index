package cc.webkit.guide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public List<Map<String, Object>> hello(Model model){
        return jdbcTemplate.queryForList("select * from category");
    }
}
