package com.test.Contatos.service;

import com.test.Contatos.model.Person;
import com.test.Contatos.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository repository;
    @InjectMocks
    private PersonService service;

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(Stream.of(new Person("901a574f-045f-46ab-bd84-eb5bec7cdba4","Jeremias","Pinheiro",
                "998211295",
                "jeremias@outlook.com","Rua 13 de março")).collect(Collectors.toList()));
        assertEquals(1,service.findAll().size());
    }

    @Test
    void findPersonById() throws ClassNotFoundException {
        String id = "901a574f-045f-46ab-bd84-eb5bec7cdba4";
        Person person = new Person("901a574f-045f-46ab-bd84-eb5bec7cdba4","Jeremias","Pinheiro",
                "998211295", "jeremias@outlook.com","Rua 13 de março");
        when(repository.findById(id)).thenReturn(Stream.of(person).findFirst());
        assertEquals(person,service.findPersonById(id));
    }

    @Test
    void save() {
        Person person = new Person("901a574f-045f-46ab-bd84-eb5bec7cdba4","Jeremias","Pinheiro",
                "998211295", "jeremias@outlook.com","Rua 13 de março");
        when(repository.save(person)).thenReturn(person);
        assertEquals(person,service.save(person));
    }

    @Test
    void update() throws ClassNotFoundException {
        Person person = new Person("901a574f-045f-46ab-bd84-eb5bec7cdba4","Jeremias","Pinheiro",
                "998211295", "jeremias@outlook.com","Rua 13 de março");
        when(repository.findById(person.getId())).thenReturn(Stream.of(person).findFirst());
        Person atualizar = new Person("901a574f-045f-46ab-bd84-eb5bec7cdba4","Jeremias","Pinheiro",
                "995065662", "jeremias.pinheiro@outlook.com","Rua Jacinta Andrade");
        assertEquals(person,service.update("901a574f-045f-46ab-bd84-eb5bec7cdba4",atualizar));
    }

    @Test
    void delete() throws ClassNotFoundException {
        Person person = new Person("901a574f-045f-46ab-bd84-eb5bec7cdba4","Jeremias","Pinheiro",
                "998211295", "jeremias@outlook.com","Rua 13 de março");
        when(repository.findById(person.getId())).thenReturn(Stream.of(person).findFirst());
        Person deletado = null;
        assertEquals(deletado,service.delete(person.getId()));
    }


}