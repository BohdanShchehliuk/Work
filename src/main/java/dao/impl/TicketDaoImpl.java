package dao.impl;

import dao.TicketDao;
import entity.Terminal;
import entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TicketDaoImpl implements TicketDao {
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
    public Ticket add(Ticket ticket) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ticket);
        try {

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по додаванню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return ticket;
    };

    @Override
    public Ticket update(Ticket ticket) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(ticket);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по оновленню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    @Override
    public boolean delete(Ticket ticket) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket  delete = session.load(Ticket.class, ticket.getId());
        if (delete != null) {
            session.delete(delete);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    @Override
    public Ticket get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка.Транзакція по отриманню елемента не відбулась");
            e.printStackTrace();
        }
        session.close();
        return ticket;
    }

    @Override
    public List<Ticket> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Ticket> list = session.createQuery("FROM Ticket", Ticket.class).
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
