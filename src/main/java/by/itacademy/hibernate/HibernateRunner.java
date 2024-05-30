package by.itacademy.hibernate;

import by.itacademy.hibernate.dao.ApartmentDao;
import by.itacademy.hibernate.entity.Apartment;
import by.itacademy.hibernate.entity.User;
import by.itacademy.hibernate.entity.UserChat;
import by.itacademy.hibernate.util.HibernateUtil;
import by.itacademy.hibernate.util.TestDataImporter;
import com.querydsl.jpa.HibernateHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.graph.GraphSemantic;
import org.hibernate.graph.RootGraph;
import org.hibernate.graph.SubGraph;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class HibernateRunner {

    public static void main(String[] args) {
        try{
            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();
            TestDataImporter.importData(sessionFactory);

            List<Apartment> apartmentGtThenSize = ApartmentDao.INSTANCE.getApartmentGtThenSize(session, 58);
            System.out.println(apartmentGtThenSize);

            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
