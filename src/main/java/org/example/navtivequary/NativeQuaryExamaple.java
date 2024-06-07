package org.example.navtivequary;

import org.example.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class NativeQuaryExamaple {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
         String querySql="select * from employee_details";

            NativeQuery<EmployeeEntity> nq= session.createNativeQuery(querySql, EmployeeEntity.class);

            List<EmployeeEntity> list= nq.list();

            for(EmployeeEntity employeeEntity:list){
                System.out.println(employeeEntity.toString());
            }
        } finally {
        session.close();
    }
    }
}
