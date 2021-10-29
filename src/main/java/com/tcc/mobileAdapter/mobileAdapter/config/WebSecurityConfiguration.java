package com.tcc.mobileAdapter.mobileAdapter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/createUser").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .antMatchers(HttpMethod.POST, "/internal/login").permitAll()
                .antMatchers(HttpMethod.POST, "/product/createProduct").permitAll()
                .antMatchers(HttpMethod.POST, "/category/createCategory").permitAll()
                .antMatchers(HttpMethod.PUT, "/product/updateProduct/*").permitAll()
                .antMatchers(HttpMethod.DELETE, "/product/deleteProduct/*").permitAll()
                .antMatchers(HttpMethod.GET, "/product/products").permitAll()
                .antMatchers(HttpMethod.GET, "/category").permitAll()
                .antMatchers(HttpMethod.POST, "/stock/createStock").permitAll()
                .antMatchers(HttpMethod.GET, "/stock").permitAll()
                .antMatchers(HttpMethod.PUT, "/stock/updateStock/*").permitAll()
                .antMatchers(HttpMethod.DELETE, "/stock/deleteStock/*").permitAll()
                .antMatchers(HttpMethod.GET, "/catalog/getProducts").permitAll()
                .antMatchers(HttpMethod.GET, "/catalog/getProduct/*").permitAll()
                .antMatchers(HttpMethod.POST, "/internal/create").permitAll()
                .antMatchers(HttpMethod.DELETE, "/internal/delete/*").permitAll()
                .anyRequest().authenticated();
        http.cors().configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.addAllowedOriginPattern("*");
            config.setAllowCredentials(true);
            return config;
        });
    }
}