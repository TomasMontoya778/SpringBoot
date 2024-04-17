package com.riwi.primeraWeb.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Entity le indica a SpringBoot que esta clase es una entidad
@Entity
// Table permite configurar la tabla que creará el ORM (HIBERNATE) en la base de datos
@Table(name = "coder")
public class Coder {
    // @Id indica que el atributo será será la llave primaria
    @Id
    // @GeneratedValue indica que el atributo será auto generado con la estrategia auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCoder;
    private String clan;
    private int age;
    public Coder(){

    }
    public Coder(Long id, String nameCoder, String clan, int age) {
        this.id = id;
        this.nameCoder = nameCoder;
        this.clan = clan;
        this.age = age;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameCoder() {
        return nameCoder;
    }
    public void setNameCoder(String nameCoder) {
        this.nameCoder = nameCoder;
    }
    public String getClan() {
        return clan;
    }
    public void setClan(String clan) {
        this.clan = clan;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "\n----Coder----\nid: " + id + "\nnameCoder: " + nameCoder + "'\nclan: " + clan + "\nage: " + age;
    }
    
}
