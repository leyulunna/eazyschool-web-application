package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http.csrf((csrf) -> csrf
                        .ignoringRequestMatchers(new AntPathRequestMatcher("/public/**"))
                        .ignoringRequestMatchers(mvcMatcherBuilder.pattern("/saveMsg")))
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(mvcMatcherBuilder.pattern("/dashboard")).authenticated()
                        .requestMatchers(mvcMatcherBuilder.pattern("/displayProfile")).authenticated()
                        .requestMatchers(mvcMatcherBuilder.pattern("/updateProfile")).authenticated()
                        .requestMatchers(mvcMatcherBuilder.pattern("/displayMessages")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/closeMsg/**")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/admin/**")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/home")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/holidays/**")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/contact")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/saveMsg")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/courses")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/about")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/assets/**")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/login")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/logout")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/public/**")).permitAll())
                .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
                .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());

        return http.build();

    }

}
