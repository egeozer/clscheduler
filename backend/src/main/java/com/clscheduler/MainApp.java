package com.clscheduler;


import com.clscheduler.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class MainApp {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        //Adding the secure URL pattern after initiating the JWT filter
        registrationBean.addUrlPatterns("/client/secure/*");

        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}