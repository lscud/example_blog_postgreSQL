package com.spring.codeblog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_LIST = {
            "/",
            "/posts",
            "/posts/{id}"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(AUTH_LIST).permitAll() //permite as paginas desta lista (veotr)
                .anyRequest().authenticated() //o restante necessitara de autenticação
                .and().formLogin().permitAll() //usa o formulario padrao de autenticação (aqui poderia usar um personalizado)
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("michelli").password("{noop}123").roles("ADMIN");
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/bootstrap/**");
//        web.ignoring().antMatchers("/bootstrap/**", "/style/**");
    }
}
