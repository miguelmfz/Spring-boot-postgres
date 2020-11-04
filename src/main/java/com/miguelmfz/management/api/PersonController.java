package com.miguelmfz.management.api;

import com.miguelmfz.management.model.Person;
import com.miguelmfz.management.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    public  final PersonServices personServices;

    @Autowired
    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person){
        personServices.addPersonas(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return this.personServices.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable UUID id){
        return this.personServices.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void  deletepersonById(@PathVariable("id") UUID id){
        personServices.deletePerson(id);
    }

    @PutMapping
    public void updatePerson(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Person personToUpdate){
        personServices.updatePerson(id,personToUpdate);
    }


}
