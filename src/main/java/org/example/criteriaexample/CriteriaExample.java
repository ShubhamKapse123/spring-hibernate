package org.example.criteriaexample;

import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import jakarta.persistence.criteria.Root;

import org.example.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CriteriaExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();  // Use JPA CriteriaBuilder
            CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder.createQuery(EmployeeEntity.class);
            Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
            criteriaQuery.select(root);

            TypedQuery<EmployeeEntity> typedQuery = session.createQuery(criteriaQuery);
            List<EmployeeEntity> employees = typedQuery.getResultList();

            for (EmployeeEntity employee : employees) {
                System.out.println(employee.toString());
            }
        } finally {
            session.close();
        }
    }

}
