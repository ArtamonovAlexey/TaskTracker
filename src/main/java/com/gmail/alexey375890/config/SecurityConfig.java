package com.gmail.alexey375890.config;

import com.gmail.alexey375890.enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/**").hasAuthority(Permission.DEVELOPERS_SAVE.getPermission())
                .antMatchers(HttpMethod.PUT, "/**").hasAuthority(Permission.DEVELOPERS_UPDATE.getPermission())
                .antMatchers(HttpMethod.GET, "/**").hasAuthority(Permission.DEVELOPERS_GET.getPermission())
                .antMatchers(HttpMethod.DELETE, "/**").hasAuthority(Permission.DEVELOPERS_DELETE.getPermission())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");
    }

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//
//        System.out.println(Permission.DEVELOPERS_SAVE.getPermission());
//        System.out.println(Permission.DEVELOPERS_UPDATE.getPermission());
//        System.out.println(Permission.DEVELOPERS_GET.getPermission());
//        System.out.println(Permission.DEVELOPERS_DELETE.getPermission());
//
//        System.out.println("\n" + Role.ADMIN.getAuthorities());
//        return new InMemoryUserDetailsManager(
//
//                User.builder()
//                        .username("admin")
//                        .password(passwordEncoder().encode("a"))
//                        .authorities(Role.ADMIN.getAuthorities())
//                        .build(),
//
//                User.builder()
//                        .username("user")
//                        .password(passwordEncoder().encode("u"))
//                        .authorities(Role.USER.getAuthorities())
//                        .build(),
//
//                User.builder()
//                        .username("guest")
//                        .password(passwordEncoder().encode("g"))
//                        .authorities(Role.GUEST.getAuthorities())
//                        .build()
//        );
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return daoAuthenticationProvider;
    }

}
