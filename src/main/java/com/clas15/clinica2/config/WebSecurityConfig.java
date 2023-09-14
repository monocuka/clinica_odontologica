package com.clas15.clinica2.config;


import com.clas15.clinica2.DaoRepository.securityIDao.IUsuarioRepository;
import com.clas15.clinica2.model.security.Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
  private final IUsuarioRepository usuarioRepository;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests(authorize -> authorize
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // Permitimos recursos estáticos como CSS y JS
                    .requestMatchers(PathRequest.toH2Console()).permitAll() // Permitimos acceso a la consola de H2
                    .antMatchers("/", "/login").permitAll() // Rutas permitidas sin autenticación
                    .antMatchers("/odontologo/**", "/pacientes/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
            .formLogin(withDefaults())
            .httpBasic(withDefaults());
  }
  
  @Bean
  public UserDetailsService userDetailsService() {
    return username -> usuarioRepository.findByUsername(username)
        .map(u -> User.withUsername(u.getUsername())
            .password(u.getPassword())
            .roles(u.getRoles().stream().map(Rol::getName).toArray(String[]::new))
            .build())
        .orElseThrow(() -> new RuntimeException("No existe el usuario con username: " + username));

  }
  
  @Bean
  public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(userDetailsService())
        .passwordEncoder(passwordEncoder)
        .and()
        .build();
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}
