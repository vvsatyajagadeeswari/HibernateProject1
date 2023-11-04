package com.anudipfound;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anudipfound.model.User;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
        cfg.configure("Hibernatecrud.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();

           
           try 
           {
        	   //insert values
        	   for(int i=1;i<=5;i++)
        	   {
        		   User u1=new User();
        		   u1.setName("User Name"+i);
        		   session.save(u1);
        	   }
        	   
        	   //update details
        	   User u1=session.get(User.class,5);
        	   u1.setName("Jagadeeswari");
        	   session.update(u1);
        	   
        	   //retrieve details
        	   User u2=session.get(User.class, 5);
        	   System.out.println("User name :"+u2.getName());
        	   
        	   //Delete deails
        	   User u3=session.get(User.class, 4);
        	   session.delete(u3);
        			   
        	   
           session.beginTransaction();           
           session.getTransaction().commit();
           }
           finally 
           {
           	session.close();
           	factory.close();
           }   

    }
}
