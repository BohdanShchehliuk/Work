package dao.impl;

import dao.PersonalDao;
import entity.Gate;
import entity.Personal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PersonalDaoImpl implements PersonalDao {
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    @Override
    public Personal add(Personal personal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(personal);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по додаванню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return personal;
    };

    @Override
    public Personal update(Personal personal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(personal);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по додаванню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    @Override
    public boolean delete(Personal personal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Personal delete = session.load(Personal.class, personal.getId());
        if (delete != null) {
            session.delete(delete);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }


    @Override
    public Personal get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Personal personal = session.get(Personal.class, id);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка.Транзакція по отриманню елемента не відбулась");
            e.printStackTrace();
        }
        session.close();
        return personal;
    }

    @Override
    public List<Personal> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Personal> list = session.createQuery("FROM Personal", Personal.class).
                getResultList();
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка.Транзакція по отриманню елементів не відбулась");
            e.printStackTrace();
        }
        session.close();
        return list;
    }
}
