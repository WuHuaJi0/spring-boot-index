package cc.webkit.guide.config;

import cc.webkit.guide.controller.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        System.out.println("运行到拦截器这里了");
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/*");
//    }
}
