package com.test.Contatos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {

    @Id
    private String id;

    private String name;
    private String surname;
    private String contact;
    private String Email;
    //Where are you live
    private String home; // <--

    public Person(String id, String name, String surname,
                  String contact, String email, String home) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.contact = contact;
        Email = email;
        this.home = home;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", contact='" + contact + '\'' +
                ", Email='" + Email + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
