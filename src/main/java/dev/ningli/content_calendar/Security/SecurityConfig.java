package dev.ningli.content_calendar.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // In memory database
    /*
    @Bean
    InMemoryUserDetailsManager inMemoryConfiguration() {

        UserDetails alice = User.builder()
                .username("alice")
                .password("{noop}123")
                .roles("EMPLOYEE")
                .build();

        UserDetails bob = User.builder()
                .username("bob")
                .password("{noop}123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails charlie = User.builder()
                .username("charlie")
                .password("{noop}123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(alice, bob, charlie);
    }
    */

    // In memory database
    /*
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    */

    // Note users' password ==> fun123
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Define the query to retrieve a user
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        // Define the query to retrieve the retrieved user's authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }


    @Bean
    SecurityFilterChain securityFilterForApis (HttpSecurity httpSecurity ) throws Exception {
        httpSecurity
                .securityMatcher("/api/**")
                // use HTTP Basic authentication
                .httpBasic(Customizer.withDefaults())
                .cors(cors -> {})
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // disable Cross Site Request Forgery (CSRF)
                // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(configurer ->configurer
                        .requestMatchers("/api/**").permitAll());

        return httpSecurity.build();
    }

    @Bean
    SecurityFilterChain securityFilter (HttpSecurity httpSecurity ) throws Exception {
        httpSecurity
                .securityMatcher("/security/**")
                // use HTTP Basic authentication
                .httpBasic(Customizer.withDefaults())
                .cors(cors -> {})
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // disable Cross Site Request Forgery (CSRF)
                // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(configurer ->configurer
                        .requestMatchers(HttpMethod.GET, "/security/posts").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/security/posts").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/security/posts").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/security/comments").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/security/comments").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/security/comments/**").hasRole("ADMIN")
                );

        return httpSecurity.build();
    }

}
