package com.example.demo.modelos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
* Esta es la clase Rol, que representa los roles de usuario en el sistema. La clase está anotada con
* @Entity para indicar que se trata de una entidad de base de datos, y @Table(name = "roles") para especificar el
* nombre de la tabla correspondiente en la base de datos.
La clase tiene las siguientes propiedades:
    rolId: identificador único del rol.
    rolNombre: nombre del rol.
    usuarioRoles: conjunto de relaciones muchos a muchos entre usuarios y roles. Esta relación se gestiona mediante
    la clase UsuarioRol.
* */
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    private Long rolId;
    private String rolNombre;

    /*
    * La propiedad usuarioRoles se mapea a la base de datos con la anotación @OneToMany que indica que la relación
    * es de uno a muchos. La propiedad mappedBy especifica la propiedad inversa de la relación en la clase UsuarioRol.
    * */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public Rol() {

    }
}
