package com.example.demo.modelos;

import org.springframework.security.core.GrantedAuthority;

/*
* Este es un modelo que implementa la interfaz GrantedAuthority de Spring Security. La interfaz GrantedAuthority
* define un método getAuthority() que devuelve una cadena que representa un permiso o rol.
* En este modelo, la clase Authority tiene un atributo authority que representa un permiso o rol y un constructor que
* recibe una cadena que representa el permiso o rol y lo asigna al atributo authority. Además, implementa el método
* getAuthority() que devuelve el valor del atributo authority.
* Esta clase se utiliza en conjunto con la clase Usuario para representar los roles o permisos que tienen los usuarios
* en la aplicación.
* */

public class Authority implements GrantedAuthority {

    private String authority;

    public Authority(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
