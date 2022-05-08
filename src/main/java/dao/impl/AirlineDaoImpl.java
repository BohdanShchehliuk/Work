package dao.impl;

import dao.AirlineDao;
import entity.Aircraft;
import entity.Airline;
import entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AirlineDaoImpl implements AirlineDao {
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
    public Airline add(Airline airline) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(airline);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по додаванню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return airline;
    };

    @Override
    public Airline update(Airline airline) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(airline);
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
    public boolean delete(Airline airline) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Airline delete = session.load(Airline.class, airline.getId());
        if (delete != null) {
            session.delete(delete);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    @Override
    public Airline get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Airline  airline = session.get(Airline.class, id);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка.Транзакція по отриманню елемента не відбулась");
            e.printStackTrace();
        }
        session.close();
        return airline;
    }

    @Override
    public List<Airline> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Airline> list = session.createQuery("FROM Airline", Airline.class).
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
