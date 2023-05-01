package com.example.demo.servicios.implementacion;

import com.example.demo.modelos.Usuario;
import com.example.demo.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/*
* Este es un servicio de implementación de la interfaz UserDetailsService de Spring Security. La anotación
* @Service indica que esta clase es un componente de servicio de Spring y se encarga de cargar y autenticar los
* detalles del usuario en la aplicación.
* El método loadUserByUsername() busca un usuario por su nombre de usuario utilizando el repositorio UsuarioRepository.
* Si el usuario no se encuentra, se lanza una excepción UsernameNotFoundException.
* Si se encuentra el usuario, se devuelve un objeto de usuario que implementa la interfaz UserDetails, que contiene
* los detalles del usuario, como el nombre de usuario, la contraseña y los roles de usuario.
* */
@Service
public class UserDetailsServiceImplementacion implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByUsername(username);
        if (usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return usuario;
    }
}
