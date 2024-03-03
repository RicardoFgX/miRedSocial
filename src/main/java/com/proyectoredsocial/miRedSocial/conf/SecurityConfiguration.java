package com.proyectoredsocial.miRedSocial.conf;

import com.proyectoredsocial.miRedSocial.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

import com.proyectoredsocial.miRedSocial.services.UsuarioService;

/**
 * Configuración de seguridad para la aplicación.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    /**
     * Inyección del filtro de JWT.
     */
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * Inyección del servicio de usuario.
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Configuración del filtro de seguridad para las solicitudes HTTP.
     *
     * @param http El objeto HttpSecurity que se configura.
     * @return Un objeto SecurityFilterChain configurado.
     * @throws Exception Si hay un error durante la configuración.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/estudiantes/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/estudiantes/**")
                        .hasAnyAuthority(Roles.ROLE_USER.toString(), Roles.ROLE_ADMIN.toString())
                        .requestMatchers(HttpMethod.PUT, "/estudiantes/**")
                        .hasAnyAuthority(Roles.ROLE_USER.toString(), Roles.ROLE_ADMIN.toString())
                        .requestMatchers(HttpMethod.DELETE, "/estudiantes/**")
                        .hasAnyAuthority(Roles.ROLE_USER.toString(), Roles.ROLE_ADMIN.toString())
                        .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /**
     * Crea un codificador de contraseñas.
     *
     * @return Un objeto PasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Crea un proveedor de autenticación.
     *
     * @return Un objeto AuthenticationProvider.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Obtiene el AuthenticationManager.
     *
     * @param config La configuración de autenticación.
     * @return Un objeto AuthenticationManager.
     * @throws Exception Si hay un error al obtener el AuthenticationManager.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
