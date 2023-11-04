package com.anudipfound;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anudipfound.model.Address;
import com.anudipfound.model.Customer;


public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Connection Started");
		Configuration cfg=new Configuration();
		cfg.configure("hibernateLab1.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		System.out.println(factory);
		try
		{
			Customer cust=new Customer();
			cust.setName("Jagadeeswari");
			
			Address a1=new Address();
			a1.setAddress("Rajahmundry");
			a1.setCustomer(cust);
			
			Address a2=new Address();
			a2.setAddress("Hyderbad");
			a2.setCustomer(cust);
			
			session.beginTransaction();
        	session.save(cust);
        	session.save(a1);
        	session.save(a2);
        	session.getTransaction().commit();
        	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}
	
       
    }
}
