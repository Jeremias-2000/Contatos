package com.test.Contatos.controller;

import com.test.Contatos.model.Person;
import com.test.Contatos.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
public class PersonController implements PersonInterface{
    @Autowired
    private PersonService service;

    @Override
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findId(String id) throws ClassNotFoundException {
        return new ResponseEntity<>(service.findPersonById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> save(Person person) {
        return new ResponseEntity<>(service.save(person),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(String id, Person person) throws ClassNotFoundException {
        return new ResponseEntity<>(service.update(id, person),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(String id) throws ClassNotFoundException {
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
