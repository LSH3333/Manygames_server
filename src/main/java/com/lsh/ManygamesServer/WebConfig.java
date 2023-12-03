package com.lsh.ManygamesServer;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * CORS 허용
     * Http response header 의 Access-Control-Allow-Origin 값에 허용하는 origin 추가함
     * 브라우저는 서버가 보내준 위의 origin 을 확인해 응답이 유효한지 아닌지 결정
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "https://www.sehyun-portal.com/");
    }
}
