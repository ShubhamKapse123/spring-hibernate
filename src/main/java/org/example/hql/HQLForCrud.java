package org.example.hql;

import jakarta.persistence.Query;
import org.example.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.text.html.parser.Entity;

public class HQLForCrud {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
//            Query delete = session.createQuery("delete from EmployeeEntity e where e.empId=:id");
//            delete.setParameter("id", 5);
//            int row = delete.executeUpdate();
            //    System.out.println("deleted no. of rows" + row);
//            Query update = session.createQuery("update EmployeeEntity e set e.eName=:name  where e.empId=:id");
//            update.setParameter("id", 2);
            //      update.setParameter("name", "Dhoni");
//            int row = update.executeUpdate();
//            System.out.println("updated no. of rows" + row);

            Query insert = session.createQuery("insert into EmployeeEntity(eName,jobDetails)  select e1.eName,e1.jobDetails from EmployeeEntity e1 where e1.empId=2");
            int row = insert.executeUpdate();
            System.out.println("insert no. of rows" + row);
            transaction.commit();


        } finally {
            session.close();
        }
    }
}
