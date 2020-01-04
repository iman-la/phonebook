package ir.fmehrtash.phonebook.dao;

import ir.fmehrtash.phonebook.Util.HibernateUtil;
import ir.fmehrtash.phonebook.entity.Phone;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("phoneDao")
public class phoneDao {

    private Session currentSession;

    public phoneDao() {
        this.currentSession = HibernateUtil.getSessionFactory().openSession();
    }


    public Phone getPhoneById(int pid) {
        Phone p = currentSession.get(Phone.class, pid);
      //  currentSession.refresh(p);
        return p;

    }

    public void deletePhone(Phone obj) {
        Transaction t = currentSession.beginTransaction();
        currentSession.remove(obj);
        t.commit();
        currentSession.close();
    }

    public void newPhone(Phone obj) {
        Transaction t = currentSession.beginTransaction();
        currentSession.save(obj);
        t.commit();
    }


}
