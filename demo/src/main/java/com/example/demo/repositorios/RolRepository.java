package com.example.demo.repositorios;

import com.example.demo.modelos.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/*Esta interface hereda de JpaRepository que forma parte de Spring Data JPA y proporciona métodos
* básicos para realizar un CRUD a la clase Rol
*
* La interfaz proporciona métodos básicos, como: findAll, findById, save, delete, etc.
* Los cuales son implementados automáticamente por Spring Data JPA. Estos métodos pueden usarse para realizar
* operaciones CRUD en la entidad Rol.
* */
public interface RolRepository extends JpaRepository<Rol, Long> {

}