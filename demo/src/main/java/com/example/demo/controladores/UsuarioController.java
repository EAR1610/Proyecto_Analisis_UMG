package com.example.demo.controladores;

import com.example.demo.modelos.Rol;
import com.example.demo.modelos.Usuario;
import com.example.demo.modelos.UsuarioRol;
import com.example.demo.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/*
* Este es un controlador de Spring que maneja las solicitudes HTTP relacionadas con la entidad de usuario en la aplicación
* */

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
    * Este método maneja las solicitudes POST para crear nuevos usuarios en la aplicación. Recibe un objeto Usuario
    * en formato JSON como entrada y devuelve el usuario creado en caso de éxito. Primero establece una imagen de
    * perfil predeterminada para el usuario, luego codifica la contraseña proporcionada utilizando
    * BCryptPasswordEncoder y crea un nuevo objeto UsuarioRol que relaciona el usuario con el rol "OPERADOR".
    * Finalmente, llama al método guardarUsuario del servicio usuarioService para guardar el usuario en la base
    * de datos.
    * */
    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        usuario.setPerfil("default.png");

        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));

        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setRolNombre("OPERADOR");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }

    /*
    *  Este método maneja las solicitudes GET para obtener información sobre un usuario específico en la aplicación.
    * Recibe un nombre de usuario como parámetro de ruta y devuelve un objeto Usuario correspondiente en caso de
    * éxito. Llama al método obtenerUsuario del servicio usuarioService para buscar el usuario en la base de datos.
    * */
    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    /*
    * Este método maneja las solicitudes DELETE para eliminar un usuario específico de la aplicación.
    * Recibe un ID de usuario como parámetro de ruta y llama al método eliminarUsuario del servicio usuarioService
    * para eliminar el usuario correspondiente de la base de datos. No devuelve nada.
    * */
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }
}
