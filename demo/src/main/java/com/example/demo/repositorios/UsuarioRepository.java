package com.example.demo.repositorios;

import com.example.demo.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* Define una interfaz llamada UsuarioRepository, la cual extiende de JpaRepository con la entidad Usuario y el
* tipo de dato de su clave primaria Long. Además, tiene un método findByUsername que recibe como parámetro un
* String llamado username y retorna un objeto de tipo Usuario. Este método busca en la base de datos el usuario
* que tenga el nombre de usuario username.
* */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
