package br.org.roger.spring.service;

import br.org.roger.spring.domain.Person;

import java.util.List;

public interface PersonService {

    Person loadPerson(final Long id);

}
