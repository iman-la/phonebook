package ir.fmehrtash.phonebook.dao;

import ir.fmehrtash.phonebook.Util.HibernateUtil;
import ir.fmehrtash.phonebook.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("personDao")
public class personDao {

    private Session currentSession;

    public personDao() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
    }

    public ArrayList<Person> getAllPerson() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        Query q = currentSession.createQuery("from Person ");
        personArrayList = (ArrayList<Person>) q.list();
        return personArrayList;
    }

    public void newPerson(Person pObj) {
        Transaction t = currentSession.beginTransaction();
        currentSession.save(pObj);
        t.commit();
    }


    public Person getPersonById(int pid) {
        Person pObj = currentSession.get(Person.class, pid);
        //currentSession.refresh(pObj);
        return pObj;
    }

    public void deletePerson(Person pObj) {
        Transaction t = currentSession.beginTransaction();
        currentSession.remove(pObj);
        t.commit();
        currentSession.close();
    }

}
