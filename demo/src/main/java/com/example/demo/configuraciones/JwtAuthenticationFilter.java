package com.example.demo.configuraciones;

import com.example.demo.servicios.implementacion.UserDetailsServiceImplementacion;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* El propósito de esta clase es interceptar las solicitudes HTTP entrantes y validar el token JWT que se
* encuentra en el encabezado de autorización de la solicitud. Si el token es válido, la clase establece el
* contexto de autenticación en Spring Security, lo que permite a la aplicación permitir el acceso al recurso
* solicitado.
* */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImplementacion userDetailsServiceImplementacion;

    @Autowired
    private JwtUtils jwtUtils;

    /*
    * Dentro del método doFilterInternal, se obtiene el token JWT de la solicitud y se extrae el nombre de
    * usuario del token. A continuación, se valida el token y se carga los detalles del usuario correspondiente
    * utilizando el UserDetailsServiceImplementacion. Si el token es válido, se crea un objeto
    * UsernamePasswordAuthenticationToken y se establece en el contexto de seguridad de Spring mediante el
    * método SecurityContextHolder.getContext().setAuthentication().
    *
    * En caso de que el token no sea válido, la clase imprime un mensaje de error. Finalmente, la solicitud es
    * enviada al siguiente filtro en la cadena de filtros utilizando filterChain.doFilter(request,response).
    * */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);

            try{
                username = this.jwtUtils.extractUsername(jwtToken);
            }catch (ExpiredJwtException exception){
                System.out.println("El token ha expirado");
            }catch (Exception e){
                e.printStackTrace();
            }

        } else {
            System.out.println("Token invalido , no empieza con bearer string");
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsServiceImplementacion.loadUserByUsername(username);
            if(this.jwtUtils.validateToken(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else{
            System.out.println("El token no es valido");
        }
        filterChain.doFilter(request,response);
    }
}
