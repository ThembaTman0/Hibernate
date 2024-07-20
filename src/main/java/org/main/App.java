package org.main;

import org.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args){
        SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            //Create object of entity class type
            Users user = new Users("username","password","first_name","last_name");

            //Start transaction
            session.beginTransaction();

            //Perform operation
            session.save(user);

            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("Operation Done");

        }finally {
            session.close();
            factory.close();
        }
    }
}
