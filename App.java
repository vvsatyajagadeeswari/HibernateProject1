package com.anudipfound;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anudipfound.model.Cart;
import com.anudipfound.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	/*SessionFactory sessionFactory=HibernateeUtil.getSessionFactory();
        Session session=sessionFactory.openSession();*/
   	 Configuration cfg=new Configuration();
     cfg.configure("HibernateLab2.cfg.xml");
     SessionFactory factory=cfg.buildSessionFactory();
     Session session=factory.openSession();

        
        try 
        {
              
        Cart c1=new Cart(); 
        c1.setPrice(1000);
        Cart c2=new Cart(); 
        c2.setPrice(2500);
        
        Product p1=new Product();
        p1.setName("Blue Shirt");
        p1.setPrice(1000);
        Product p2=new Product();
        p2.setName("White Shirt");
        p2.setPrice(2500);
        
        c1.getProduct().add(p1);
        c1.getProduct().add(p2);
        c2.getProduct().add(p1);
        
        session.beginTransaction(); 
        
        session.save(c1);
        session.save(c2);
        session.save(p1);
        session.save(p2);
        
        session.getTransaction().commit();
        }
        finally 
        {
        	session.close();
        	factory.close();
        }   

    }
}
