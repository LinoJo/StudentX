package com.fhdw.config;

/**
 * Created by timon on 29.04.2017.
 */

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //Erlaube Zugriff auf Ordner im Static
                .authorizeRequests()
                    .antMatchers( "/css/**", "/font-awesome/**", "/fonts/**", "/img/**", "/js/**", "/scss/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                //Login-Page
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/studenten", true)
                    .and()
                //Logout
                .logout()
                    .permitAll();
    }

    //Benutzerauthentifizierung
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                    .withUser("user")
                        .password("password")
                        .roles("USER")
                        .and()
                    .withUser("admin")
                        .password("password")
                        .roles("ADMIN","USER");
        auth
                .jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("select EMAIL,PASSWORT_HASH, ACTIVATED from MITARBEITER where EMAIL=?")
                    .authoritiesByUsernameQuery("select EMAIL, ROLLE from MITARBEITER_ROLLEN where EMAIL=?");
    }
}
