package org.example.hql;

import org.example.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLFetchExample {
    public static void main(String[] args) {
    Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
        try {
            //use entity name and there properties
            //String hqlQuery="from EmployeeEntity";
           //String hqlQuery="from EmployeeEntity where eName='Kohli'";
            String hqlQuery="from EmployeeEntity as s where s.eName=:n";

           Query query= session.createQuery(hqlQuery);
           query.setParameter("n","Kohli");

          List<EmployeeEntity> list= query.list();

          for(EmployeeEntity employeeEntity:list){
              System.out.println(employeeEntity.toString());
          }


        }finally {
            session.close();
        }
        }
}
