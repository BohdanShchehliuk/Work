package dao.impl;

import dao.GateDao;
import entity.Flight;
import entity.Gate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GateDaoImpl implements GateDao {
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
    public Gate add(Gate gate) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(gate);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по додаванню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return  gate;
    };

    @Override
    public Gate update(Gate gate) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(gate);
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
    public boolean delete(Gate gate) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Gate delete = session.load(Gate.class, gate.getId());
        if (delete != null) {
            session.delete(delete);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    @Override
    public Gate get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Gate gate = session.get(Gate.class, id);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка.Транзакція по отриманню елемента не відбулась");
            e.printStackTrace();
        }
        session.close();
        return gate;
    }

    @Override
    public List<Gate> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Gate> list = session.createQuery("FROM Gate",Gate.class).
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
