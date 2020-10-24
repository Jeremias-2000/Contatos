package com.test.Contatos.service;

import com.test.Contatos.model.Person;
import com.test.Contatos.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findPersonById(String id) throws ClassNotFoundException {
        return searchId(id);
    }

    public Person save(Person person){
        validPerson(person);
        return repository.save(person);
    }

    public Person update(String id,Person person) throws ClassNotFoundException {
        Person search = searchId(id);
        validPerson(person);

        search.setId(person.getId());
        search.setName(person.getName());
        search.setSurname(person.getSurname());
        search.setContact(person.getContact());
        search.setEmail(person.getEmail());
        search.setHome(person.getHome());
        return search;
    }

    public Person delete(String id) throws ClassNotFoundException {
        Person search = searchId(id);
        repository.delete(search);
        return null;
    }

    private void validPerson(Person person){
        if (person.getName() == null || person.getSurname() == null ||
                person.getContact() == null || person.getEmail() == null || person.getHome() == null){
                throw new RuntimeException("Campos Obrigatórios ...");
        }
    }

    private Person searchId(String id) throws ClassNotFoundException {
        Person search;
        search = repository.findById(id).orElseThrow(()
                -> new ClassNotFoundException("Pessoa Nao encontrada" + id));
        return search;
    }



}
