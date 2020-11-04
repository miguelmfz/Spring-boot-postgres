package com.miguelmfz.management.services;

import com.miguelmfz.management.dao.PersonDao;
import com.miguelmfz.management.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServices {

    private final PersonDao personDao;

    @Autowired
    public PersonServices(@Qualifier("potsgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPersonas(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return  personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public  int deletePerson(UUID id){
        return  personDao.deletePersonById(id);
    }

    public  int updatePerson(UUID id,Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }

}
