package ir.fmehrtash.phonebook.service;

import ir.fmehrtash.phonebook.dao.personDao;
import ir.fmehrtash.phonebook.dao.phoneDao;
import ir.fmehrtash.phonebook.entity.Person;
import ir.fmehrtash.phonebook.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("phoneService")
public class phoneService {
    private final phoneDao dao;

    private final personDao pdao;

    public phoneService(phoneDao dao, personDao pdao) {
        this.dao = dao;
        this.pdao = pdao;
    }


    public void deletePhone(int pid) {
        dao.deletePhone(dao.getPhoneById(pid));
    }

    public void newPhone(String title, String number, int pid) {
        Person person = pdao.getPersonById(pid);
        Phone t = new Phone(title, number,person);
        dao.newPhone(t);
    }

    public Phone getPhoneById(int pid) {
        return dao.getPhoneById(pid);
    }

}
