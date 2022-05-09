package dao.impl;

import dao.PassengerDao;
import entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class PassengerDaoImpl implements PassengerDao {
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
    public Passenger add(Passenger passenger) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(passenger);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по додаванню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return passenger;
    };


    @Override
    public Passenger update(Passenger passenger) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(passenger);
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
    public boolean delete(Passenger passenger) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Passenger delete = session.load(Passenger.class, passenger.getId());
        if (delete != null) {
            session.delete(delete);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    @Override
    public Passenger get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Passenger passenger = session.get(Passenger.class, id);
        try {
            System.out.println(passenger);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка.Транзакція по отриманню елемента не відбулась");
            e.printStackTrace();
        }
        session.close();
        return passenger;
    }

    @Override
    public List<Passenger> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Passenger> list = session.createQuery("FROM Passenger", Passenger.class).
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


    @Override
    public Optional<Passenger> getByIdWithTickets(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query <Passenger> passengerQuery = session.createQuery("From Passenger p " +
                "left join fetch p.tickets t "+
               "WHERE t.passenger = :id");
        passengerQuery.setParameter("id", id);
        Optional<Passenger> passenger = Optional.ofNullable(session.get(Passenger.class, id));
        transaction.commit();
        session.close();
        return passenger;
    }
}
