package repository;

import model.Pet;
import model.Veterinarian;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class VeterinarianDao {
    public  Veterinarian findByIdVeterinarian(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Veterinarian veterinarian = session.find(Veterinarian.class, id);
            return  veterinarian;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    public  void createVeterinarian(Veterinarian veterinarian) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(veterinarian);
            transaction.commit();
            System.out.println("veterinarian creat");
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    public void deleteVeterinarian(Veterinarian veterinarian) {
            Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(veterinarian);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateVeterinarian(Veterinarian veterinarian) {
            Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(veterinarian);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public List<Veterinarian> findAllVeterinarian() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Veterinarian", Veterinarian.class);

            List<Veterinarian> veterinarianList = query.getResultList();

            return veterinarianList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}