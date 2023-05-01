package com.example.demo.controladores;

import com.example.demo.configuraciones.JwtUtils;
import com.example.demo.excepciones.UsuarioNotFoundException;
import com.example.demo.modelos.JwtRequest;
import com.example.demo.modelos.JwtResponse;
import com.example.demo.modelos.Usuario;
import com.example.demo.servicios.implementacion.UserDetailsServiceImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/*
* Este archivo contiene la implementación de un controlador llamado AuthenticationController que maneja
* las solicitudes de autenticación. El controlador tiene dos endpoints: /generate-token y /actual-usuario.
* */
@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImplementacion userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    /*
    * El método generarToken es un endpoint POST que recibe un objeto JwtRequest que contiene el nombre de usuario
    * y la contraseña. El método autentica al usuario con el nombre de usuario y la contraseña proporcionados
    * mediante el método autenticar. Si el usuario se autentica correctamente, se genera un token JWT y se
    * devuelve una respuesta HTTP que contiene el token.
    * */
    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsuarioNotFoundException exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    /*
    * El método autenticar utiliza un objeto AuthenticationManager para autenticar al usuario. Si se
    * producen errores durante la autenticación, se lanzan excepciones con mensajes de error personalizados.
    * */
    private void autenticar(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }

    /*
    * El método obtenerUsuarioActual es un endpoint GET que devuelve el usuario actualmente autenticado.
    * Esto se hace a través de la inyección de dependencia de Principal, que contiene la información de
    * autenticación del usuario. Se utiliza el método loadUserByUsername del servicio
    * UserDetailsServiceImplementacion para buscar al usuario por su nombre de usuario y devolver un objeto Usuario.
    * */
    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
