package com.example.demo.configuraciones;

import com.example.demo.servicios.implementacion.UserDetailsServiceImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
* La clase MySecurityConfig está anotada con @EnableWebSecurity y @Configuration para habilitar la configuración de
* seguridad de Spring y para indicar que esta clase es una configuración de Spring.
La clase WebSecurityConfigurerAdapter se extiende para proporcionar la configuración básica de seguridad.
* El método configure(HttpSecurity http) se anula para definir la configuración de seguridad. En este caso, se
* deshabilita CSRF, CORS, se permite el acceso a la URL /generate-token y /usuarios/ para todos los usuarios, se
* permite el acceso a los métodos HTTP OPTIONS y se requiere autenticación para todas las demás URL.
*
*También se definen otros beans de Spring como JwtAuthenticationEntryPoint, JwtAuthenticationFilter y
* BCryptPasswordEncoder. El filtro JwtAuthenticationFilter es añadido al http para validar y procesar el token
* JWT en las solicitudes entrantes.
* */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private UserDetailsServiceImplementacion userDetailsServiceImplementacion;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    /*
    * El método authenticationManagerBean() se anula y se anota con @Bean para exponer el objeto
    * AuthenticationManager como un bean de Spring para poder ser inyectado en otras partes de la aplicación.
    * */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsServiceImplementacion).passwordEncoder(passwordEncoder());
    }

    /*
    * El método configure(AuthenticationManagerBuilder auth) se anula para definir la autenticación personalizada
    * utilizando el servicio UserDetailsServiceImplementacion y el cifrado de contraseña BCryptPasswordEncoder.
    * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/generate-token", "/usuarios/").permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
