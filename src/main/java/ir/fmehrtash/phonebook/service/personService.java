package ir.fmehrtash.phonebook.service;

import ir.fmehrtash.phonebook.dao.personDao;
import ir.fmehrtash.phonebook.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("personService")
public class personService {

    private final personDao dao;


    public personService(personDao dao) {
        this.dao = dao;
    }

    public ArrayList<Person> getAllPerson() {
        return dao.getAllPerson();
    }

    public Person getPersonById(int pid) {
        return dao.getPersonById(pid);
    }

    public void deletePerson(int pid) {
        Person pObj = dao.getPersonById(pid);
        dao.deletePerson(pObj);
    }

    public void newPerson(String name, String family) {
        Person obj = new Person(name,family);
        dao.newPerson(obj);
    }

}
