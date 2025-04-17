package com.cine.ejerciciopractico2_santiagobrenes;

import com.cine.ejerciciopractico2_santiagobrenes.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class ProjectConfig implements WebMvcConfigurer {
    /* Los siguiente métodos son para implementar el tema de seguridad dentro del proyecto */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/css/**", "/img/**").permitAll() // Permitir acceso a recursos estáticos
                        .requestMatchers("/login", "/login/**").permitAll() // Permitir acceso a la página de login
                        .requestMatchers("/", "peliculas/pelicula/**" ,"/reserva/**", "/reserva/guardar/**").hasRole("USUARIO")
                        .requestMatchers("/peliculas/**", "/funcion/**", "/usuarios/**", "/").hasRole("ADMIN")
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Página de login personalizada
                        .defaultSuccessUrl("/", true) // Redirige a home después del login exitoso
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
