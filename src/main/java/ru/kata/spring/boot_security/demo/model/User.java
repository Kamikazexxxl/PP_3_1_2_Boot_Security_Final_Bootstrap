package ru.kata.spring.boot_security.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    public User(String name, String surname, int age,String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
    }

    public User(String name, String surname, int age,String password, int enabled) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    private String name;

    private String surname;

    private int age;

    private String password;

    private int enabled;
}
