package com.acteda.dev.controller;

import com.acteda.dev.model.Person;
import com.acteda.dev.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/create")
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
        Person p = personService.create(firstName, lastName, age);
        return p.toString();
    }

    @RequestMapping("/get")
    public Person getPerson(@RequestParam String firstName) {
        return personService.getByFirstName(firstName);
    }

    @RequestMapping("/getAll")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @RequestMapping("/update")
    public Person update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
        return personService.update(firstName, lastName, age);
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName) {
        personService.delete(firstName);
        return "All users with the first name " + firstName + " have been deleted.";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll() {
        personService.deleteAll();
        return "All users deleted, good job.";
    }
}
