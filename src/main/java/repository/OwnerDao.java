package repository;

import model.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtil;

import java.util.List;

public class OwnerDao {

    public Owner findByIdOwner(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Owner owner = session.find(Owner.class, id);
            return owner;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void createOwner(Owner owner) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(owner);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    public void deleteOwner(Owner owner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(owner);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateOwner(Owner owner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(owner);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<Owner> findByNameOwner(String firstName) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Owner where firstName=:firstName", Owner.class);
            query.setParameter("firstName", firstName);

            List<Owner> ownerList = query.list();

            return ownerList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

