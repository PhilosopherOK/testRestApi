package com.example.testrestapi.services;

import com.example.testrestapi.exceptions.UserIsNotCorrect;
import com.example.testrestapi.exceptions.UserNotFoundException;
import com.example.testrestapi.models.Person;
import com.example.testrestapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Transactional
    public Person save(Person person) {
        if(personRepository.findByEmail(person.getEmail()).isPresent())
            throw new UserIsNotCorrect("Email is already exist");

        person.setStatus("Offline");
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        if(!personRepository.findById(id).isPresent())
            throw new UserNotFoundException("User not found !");

        return personRepository.findById(id).orElseThrow();
    }
    @Transactional
    public Map<String, String> updateStatus(Long id, String status) {
        if(!personRepository.findById(id).isPresent())
            throw new UserNotFoundException("User not found !");

        Map<String, String> mapStatus = new HashMap<>(3);
        Person person = findById(id);
        mapStatus.put("id", "" + id);
        mapStatus.put("current status", "" + person.getStatus());

        if (!person.getStatus().equalsIgnoreCase(status)) {
            person.setStatus(status);
        }
        mapStatus.put("new status", "" + person.getStatus());
        return mapStatus;
    }
}








