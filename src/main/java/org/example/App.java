package org.example;

import org.example.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Start Project..");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        OperationPerform operationPerform = new OperationPerform();

        //saving object start
//        EmployeeEntity emp = new EmployeeEntity();
//        emp.seteName("Sachin");
//        emp.setJobDetails("join as Sr Java");
//        emp.setMangerId(11);
//        emp.setSalary(1500.00);
//        emp.setDepartmentId(101);
//        emp.setJoinDate(new Date());
//        operationPerform.saveEmp(emp, session);
        //saving object end

        //fetching objects start
//        EmployeeEntity employeeEntityGet= operationPerform.getEmp(1,session);
//        System.out.println(employeeEntityGet.toString());
        //fetching objects end

        session.close();
        System.out.println( "End Project.." );
    }
}
