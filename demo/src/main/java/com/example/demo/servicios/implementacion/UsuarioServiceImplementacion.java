package com.example.demo.servicios.implementacion;

import com.example.demo.excepciones.UsuarioFoundException;
import com.example.demo.modelos.Usuario;
import com.example.demo.modelos.UsuarioRol;
import com.example.demo.repositorios.RolRepository;
import com.example.demo.repositorios.UsuarioRepository;
import com.example.demo.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/*
* Esta es una clase Java llamada UsuarioServiceImplementacion que implementa la interfaz UsuarioService.
* La clase proporciona métodos para guardar, recuperar y eliminar un usuario.
* La clase tiene dos variables de instancia usuarioRepository y rolRepository, ambas autoconectadas mediante la
* inyección de dependencias de Spring.
* */
@Service
public class UsuarioServiceImplementacion implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;


    /*
    * El método guardarUsuario acepta como argumentos un objeto Usuario y un Conjunto de objetos UsuarioRol.
    * Comprueba si el usuario ya existe en la base de datos llamando al método findByUsername de UsuarioRepository
    * y lanza una excepción personalizada UsuarioFoundException si el usuario ya está presente. Si el usuario no
    * existe, recorre los objetos UsuarioRol, guarda los objetos Rol asociados utilizando RolRepository, añade los
    * objetos UsuarioRol al objeto Usuario y guarda el objeto Usuario utilizando UsuarioRepository. A continuación
    * se devuelve el objeto Usuario guardado.
    * */
    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    /*
    * El método obtenerUsuario acepta un argumento String nombredeusuario y devuelve el objeto Usuario con el
    * nombre de usuario coincidente llamando al método findByUsername de UsuarioRepository.
    */
    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    /*
    * El método eliminarUsuario acepta un argumento Long usuarioId y elimina el usuario con el ID coincidente
    * llamando al método deleteById de UsuarioRepository.
    * */
    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
