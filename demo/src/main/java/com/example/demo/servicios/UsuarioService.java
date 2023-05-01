package com.example.demo.servicios;

import com.example.demo.modelos.Usuario;
import com.example.demo.modelos.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    /*
    * Este método toma un objeto Usuario y un conjunto de objetos UsuarioRol y guarda el usuario en la base de
    * datos junto con sus roles asociados. Si el usuario ya existe, lanza una excepción UsuarioFoundException.
    * Este método devuelve el usuario guardado en la base de datos.
    * */
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    /*
    * Este método toma un nombre de usuario como parámetro y devuelve el objeto Usuario correspondiente si
    * existe en la base de datos.
    * */
    public Usuario obtenerUsuario(String username);

    /*
    * Este método toma un ID de usuario como parámetro y elimina el usuario correspondiente de la base de datos.
    * */
    public void eliminarUsuario(Long usuarioId);
}
