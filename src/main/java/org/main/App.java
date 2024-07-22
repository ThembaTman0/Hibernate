package org.main;

import org.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {


    public static void main(String[] args){
        SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        App app= new App();
        try{
            //Creat User
            Users newUser = new Users("username1","password1","first_name1","last_name1");
            app.createUser(session,newUser);


        }finally {
            session.close();
            factory.close();
        }
    }

    public void createUser(Session session,Users users){
        try{
            //Create object of entity class type

            //Start transaction
            session.beginTransaction();

            //Perform operation
            session.save(users);

            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("Operation Done");

        }finally {
            session.close();
        }
    }


}
