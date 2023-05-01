package com.example.demo;

import com.example.demo.excepciones.UsuarioNotFoundException;
import com.example.demo.modelos.Rol;
import com.example.demo.modelos.Usuario;
import com.example.demo.modelos.UsuarioRol;
import com.example.demo.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaTicketBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SistemaTicketBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*try {
			Usuario usuario = new Usuario();

			usuario.setNombre("Edixon");
			usuario.setApellido("Reynoso");
			usuario.setUsername("Phantom");
			usuario.setPassword(bCryptPasswordEncoder.encode("falcon"));
			usuario.setEmail("phantom@coder.com");
			usuario.setTelefono("33554285");
			usuario.setPerfil("foto.png");

			Rol rol = new Rol();
			rol.setRolId(1L);
			rol.setRolNombre("ADMIN");

			Set<UsuarioRol> usuarioRoles = new HashSet<>();
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuarioRoles.add(usuarioRol);

			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
			System.out.println(usuarioGuardado.getUsername());
		} catch (UsuarioNotFoundException exception){
			exception.printStackTrace();
		}*/
	}
}
