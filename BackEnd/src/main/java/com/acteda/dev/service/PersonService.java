package com.acteda.dev.service;

import com.acteda.dev.Repository.PersonRepository;
import com.acteda.dev.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // create operation
    public Person create(String firstName, String lastName, int age) {
        return personRepository.save(new Person(firstName, lastName, age));
    }
    public List<Person> getAll() {
        return personRepository.findAll();
    }
    public List<Person> getByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }
    public String update(String firstName, String lastName, int age) {
        List<Person> persons = personRepository.findByFirstName(firstName);

        // this function makes no sense (refactor later)
        for (Person person: persons) {
            person.setLastName(lastName);
            person.setAge(age);
            personRepository.save(person);
        }
        return "all people updated";
    }
    public void deleteAll() {
        personRepository.deleteAll();
    }
    public void delete(String firstName) {
        List<Person> p = personRepository.findByFirstName(firstName);
        for (Person p2: p) {
            personRepository.delete(p2);
        }
    }
}
