package br.org.roger.spring.service;

import br.org.roger.spring.domain.Person;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MyService {

    private LoadingCache<Long, Person> personCache = CacheBuilder.newBuilder()
        .maximumSize(200)
        .expireAfterWrite(30, TimeUnit.MINUTES)
        .build(
            new CacheLoader<Long, Person>() {
                public Person load(Long id) {
                    return personService.loadPerson(id);
                }
            });

    @Inject
    private PersonService personService;

    public List<Person> loadPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(personCache.getUnchecked(1L));
        persons.add(personCache.getUnchecked(2L));
        return persons;
    }

}
