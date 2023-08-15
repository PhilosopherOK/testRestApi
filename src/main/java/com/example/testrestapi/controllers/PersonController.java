package com.example.testrestapi.controllers;

import com.example.testrestapi.exceptions.UserIsNotCorrect;
import com.example.testrestapi.models.Person;
import com.example.testrestapi.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping()
    public ResponseEntity<Long> savePerson(@RequestBody @Valid Person person,
                                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<FieldError> errorsList = bindingResult.getFieldErrors();
            StringBuilder strError = new StringBuilder();
            for(FieldError error: errorsList){
                strError.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new UserIsNotCorrect(strError.toString());
        }
        Person newPerson = personService.save(person);
        return new ResponseEntity<>(newPerson.getId(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<Map<String, String>> updateStatus(@PathVariable("id") Long id,
                                                            @PathVariable("status") String status) {
        return new ResponseEntity<>(personService.updateStatus(id, status), HttpStatus.OK);
    }

}
