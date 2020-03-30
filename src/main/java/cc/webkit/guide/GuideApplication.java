package cc.webkit.guide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "cc.webkit.guide.mapper")
public class GuideApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuideApplication.class, args);
	}

}
