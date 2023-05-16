package in.ineuron.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Person;
import in.ineuron.repo.PersonRepository;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/persons")
    public void createPerson(@RequestBody Person person) {
        personRepository.save(person);
    }
}
