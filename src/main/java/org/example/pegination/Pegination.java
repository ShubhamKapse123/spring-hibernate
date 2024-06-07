package org.example.pegination;

import org.example.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class Pegination {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            //this is HQL query pass entity name not table name in createQuery
            Query q = session.createQuery("from EmployeeEntity");

            q.setFirstResult(5); //start index point pegination
            q.setMaxResults(3); //number of page size how many recodes want to fetch

            List<EmployeeEntity> list = q.list();

            for (EmployeeEntity employeeEntity : list) {
                System.out.println(employeeEntity.toString());
            }
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
