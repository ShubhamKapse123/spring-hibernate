package org.example;


import org.example.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class OperationPerform {
    public EmployeeEntity getEmp(int id, Session session) {
        //get  method
       // EmployeeEntity employeeEntityGet = session.get(EmployeeEntity.class, id);
        //load method
        EmployeeEntity employeeEntityLode = session.load(EmployeeEntity.class, id);

        return employeeEntityLode;
    }

    public void saveEmp(EmployeeEntity emp,Session session) {
        Transaction transaction = session.beginTransaction();
         session.persist(emp);
        transaction.commit();
    }
}
