package hh.hr.calendar.domain.repository;

import hh.hr.calendar.domain.entity.Manager;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Singleton;

@Singleton
@AllArgsConstructor
public class ManagerRepository {

    SessionFactory sessionFactory;

    public boolean saveManager(Manager manager) {
        Manager existedManager = getSession()
                .createQuery("from Manager manager where manager.email=:email", Manager.class)
                .setParameter("email", manager.getEmail())
                .uniqueResult();

        if (existedManager != null) return false;

        getSession().save(manager);
        return true;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
