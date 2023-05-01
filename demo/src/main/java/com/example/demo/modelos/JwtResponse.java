package com.example.demo.modelos;

/*
* La clase JwtResponse es una clase modelo que representa la respuesta que se envía al cliente cuando se
* autentica correctamente utilizando JSON Web Tokens (JWT). Tiene un atributo token que almacena el token JWT generado.
*
* */
public class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public JwtResponse(){

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
