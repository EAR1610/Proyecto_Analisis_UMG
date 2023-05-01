package com.example.demo.configuraciones;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* El propósito de esta clase es manejar las excepciones de autenticación en la aplicación y proporcionar una
* respuesta adecuada al cliente. Cuando un usuario intenta acceder a un recurso sin estar autenticado,
* Spring Security lanza una excepción de autenticación. En ese momento, el método commence de esta clase
* es invocado por el framework para manejar la excepción.
*
* Dentro del método commence, se establece el código de estado de la respuesta HTTP en 401 (no autorizado) y se
* envía un mensaje de error al cliente indicando que el usuario no está autorizado para acceder al recurso
* solicitado. Esto se realiza a través del método response.sendError().
* */

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Usuario no autorizado");
    }
}
