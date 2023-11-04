package com.anudipfound;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anudipfound.model.Passport;
import com.anudipfound.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

		System.out.println("Connection Started");
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		System.out.println(factory);
		try
		{
			Person lp=new Person();
			lp.setName("Jagadeeswari");
			
			Passport pass=new Passport();
			pass.setAddress("Rajahmundry");
			
			lp.setAddress(pass);
			pass.setPerson(lp);
			
			session.beginTransaction();
        	session.save(lp);
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
