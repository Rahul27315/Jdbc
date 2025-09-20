package com.jtcindia.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Lab19B {
	public static void main(String[] args) {
		Transaction tx=null;
		try {
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			tx=session.beginTransaction();
			Customer cust=session.load(Customer.class,1);
			System.out.println(cust);
			cust.setEmail("rahul@gmail");
			tx.commit();
			session.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
