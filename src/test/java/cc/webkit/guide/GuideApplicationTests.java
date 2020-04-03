package cc.webkit.guide;

import cc.webkit.guide.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuideApplicationTests {

	@Test
	void contextLoads() {

	}


	@Autowired
	CategoryRepository categoryRepository;

	@Test
	void testHello(){
		System.out.println(categoryRepository.findAll());
	}

}
