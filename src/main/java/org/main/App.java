package org.main;

import org.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {


    public static void main(String[] args){
        SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();

        App app= new App();
        try{
            //Creat User
            Users newUser = new Users("user1","pass1","first1","last1");
            app.createUser(factory,newUser);

            //Read user
            Users readUser = app.readUser(factory,newUser.getUserId());
            System.out.println("Read user: " + readUser);

            //Update User
            app.updateUser(factory, readUser.getUserId(),"JohnWickUpdated", "newpass1234");


        }finally {
            factory.close();
        }
    }

    public void createUser(SessionFactory factory,Users users){
        Session session = factory.getCurrentSession();
        try{
            //Create object of entity class type

            //Start transaction
            session.beginTransaction();

            //Perform operation
            session.save(users);

            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("User created Successfully");


        }finally {
            session.close();
        }
    }

    public Users readUser(SessionFactory factory, int userId) {
        Session session = factory.getCurrentSession();
        Users user = null;
        try {
            session.beginTransaction();
            user = session.get(Users.class, userId);
            session.getTransaction().commit();
            System.out.println("User read: " + user);
        } finally {
            session.close();
        }
        return user;
    }

    public void updateUser(SessionFactory factory,int userId,String newUserName,String newPassowrd){
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            Users users =session.get(Users.class, userId);
            if (users!=null){
                users.setUsername(newUserName);
                users.setPassword(newPassowrd);
                session.update(users);
                session.getTransaction().commit();
                System.out.println("User read: " + users);
            }

        }finally {
            session.close();
        }
    }


}
