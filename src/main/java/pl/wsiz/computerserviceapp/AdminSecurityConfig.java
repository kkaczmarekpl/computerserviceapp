package pl.wsiz.computerserviceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.wsiz.computerserviceapp.user.MyUserDetailsService;

@Configuration
@Order(1)
@EnableWebSecurity
public class AdminSecurityConfig{

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception{

        http.csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login", "/error/**", "/js/login.js", "/css/**", "/clients/addNew", "/register", "/register/getId").permitAll()
                        .requestMatchers("/login", "/error/**", "/js/**", "/css/**", "/clients/addNew", "/register").permitAll()
                        .requestMatchers("/index/**").hasAuthority(Role.USER.toString())
                        .requestMatchers("/index/**").hasAuthority(Role.ADMIN.toString())
                        //.requestMatchers("/index/service-request/**", "/index/service-request").hasAuthority(Role.USER.toString())
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/index/service-request", true)
                        .failureUrl("/login-error")
                        .permitAll()
                )
                .sessionManagement(session -> session
                        .maximumSessions(3)
                        .maxSessionsPreventsLogin(true)
                        .expiredUrl("/login?invalid-session=true")
                )
                .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/logout-success")
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                );
        return http.build();
    }
}
