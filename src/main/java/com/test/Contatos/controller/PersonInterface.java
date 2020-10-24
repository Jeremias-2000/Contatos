package com.test.Contatos.controller;

import com.test.Contatos.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface PersonInterface {
    @GetMapping("/list")
    ResponseEntity<?> list();

    @GetMapping( "/search/{id}")
    ResponseEntity<?> findId(@PathVariable("id") String id) throws ClassNotFoundException;

    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody @Validated Person person);

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable("id") String id,@RequestBody @Validated Person person) throws ClassNotFoundException;

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable("id") String id) throws ClassNotFoundException;
}
