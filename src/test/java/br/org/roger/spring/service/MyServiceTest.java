package br.org.roger.spring.service;

import br.org.roger.spring.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {

    @Mock
    private PersonService personService;

    @Spy
    @InjectMocks
    private MyService myService;

    @Test
    public void mustLoadPersons_fromService() {
        preparePersonFixture();

        final List<Person> persons = myService.loadPersons();

        assertEquals(2, persons.size());
        verify(personService).loadPerson(1L);
        verify(personService).loadPerson(2L);
    }

    @Test
    public void mustLoadPersons_fromServiceOnlyOnce() {
        preparePersonFixture();

        callMyServiceDoStuff(5);

        verify(personService).loadPerson(1L);
        verify(personService).loadPerson(2L);
    }

    private void callMyServiceDoStuff(final int times) {
        for (int i = 0 ; i < times ; i++) {
            myService.loadPersons();
        }
    }

    private void preparePersonFixture() {
        when(personService.loadPerson(1L)).thenReturn(new Person(1L, "Person 1"));
        when(personService.loadPerson(2L)).thenReturn(new Person(2L, "Person 2"));
    }
}