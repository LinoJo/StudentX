package com.fhdw.config;

/**
 * Created by timon on 29.04.2017.
 */

import com.fhdw.services.security.MitarbeiterDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
    @Autowired
    private MitarbeiterDetailsService mitarbeiterDetailsService;

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
                    .defaultSuccessUrl("/index", true)
                    .and()
                //Logout
                .logout()
                    .permitAll();
    }

    //Benutzerauthentifizierung
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mitarbeiterDetailsService);
        auth.authenticationProvider(authenticationProvider());
        }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(mitarbeiterDetailsService);
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(6);
    }
}