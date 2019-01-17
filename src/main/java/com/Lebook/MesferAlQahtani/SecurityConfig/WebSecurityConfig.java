package com.Lebook.MesferAlQahtani.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, Password, Enable "
                        + " from Users where username=?")
                .authoritiesByUsernameQuery("select username, rolename "
                        + " from Users where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .cors().and().csrf().disable()
//                .authorizeRequests().antMatchers("/viewall").hasRole("ADMIN")
//                .antMatchers("/view/").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/welcome").hasRole("USER")
//                .and().httpBasic(); // Authenticate users with HTTP basic authentication


        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/api/users/AllUser/view").permitAll()
                .antMatchers("/api/users/addUser").permitAll()
//                .antMatchers("/api/users/addOrganizer").permitAll()
//                .antMatchers("/userData").permitAll()

                .anyRequest().authenticated().and().httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

}
