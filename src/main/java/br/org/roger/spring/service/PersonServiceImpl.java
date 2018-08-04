package br.org.roger.spring.service;

import br.org.roger.spring.domain.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person loadPerson(final Long id) {
        System.out.println("Loading person...");

        return new Person(id, "John Doe #" + id);
    }
}
