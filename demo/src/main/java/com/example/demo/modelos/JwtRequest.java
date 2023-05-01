package com.example.demo.modelos;


/*
* La clase JwtRequest es utilizada para mapear los datos de la solicitud de autenticación enviados por el cliente en
* el cuerpo de la petición POST hacia /generate-token en el AuthenticationController. Esta clase tiene dos atributos,
* username y password, que son los datos necesarios para la autenticación del usuario en el sistema.
* El constructor sin parámetros de JwtRequest no se usa en el código. Y el constructor con dos parámetros es el que se
* usa para crear instancias de esta clase con los datos de autenticación del usuario.
* */
public class JwtRequest {
    private String username;
    private String password;

    public JwtRequest(String username) {

    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
