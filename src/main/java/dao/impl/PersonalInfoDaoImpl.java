package dao.impl;

import dao.PersonalInfoDao;
import entity.PersonalInfo;
import entity.Routes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PersonalInfoDaoImpl implements PersonalInfoDao {
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
    public PersonalInfo add(PersonalInfo personalInfo) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(personalInfo);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по додаванню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return personalInfo;
    };

    @Override
    public PersonalInfo update(PersonalInfo personalInfo) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(personalInfo);
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
    public boolean delete(PersonalInfo personalInfo) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PersonalInfo  delete = session.load(PersonalInfo .class,  personalInfo.getId());
        if (delete != null) {
            session.delete(delete);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    @Override
    public PersonalInfo get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PersonalInfo personalInfo = session.get(PersonalInfo.class, id);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка.Транзакція по отриманню елемента не відбулась");
            e.printStackTrace();
        }
        session.close();
        return personalInfo;
    }

    @Override
    public List<PersonalInfo> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<PersonalInfo> list = session.createQuery("FROM PersonalInfo",PersonalInfo.class).
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
