package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerInterceptor getMyInterceptor(){
        return new CORSIntercepter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}