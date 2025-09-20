package com.jtcindia.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Lab19A {
	public static void main(String[] args) {
		Transaction tx=null;
		try {
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			tx=session.beginTransaction();
			Customer cust=new Customer("Payal","payal@gmail",11111);
			session.save(cust);
			tx.commit();
			session.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
