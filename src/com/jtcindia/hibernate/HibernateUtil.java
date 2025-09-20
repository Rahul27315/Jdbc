package com.jtcindia.hibernate;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtil {
	static SessionFactory sf;
	static {
		try {
			Configuration cfg=new Configuration();
			Properties props=new Properties();
			props.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			props.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate19");
			props.put(Environment.USER,"root");
			props.put(Environment.PASS,"Rahul@27");
			props.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
			props.put(Environment.SHOW_SQL,"true");
			props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
			props.put(Environment.HBM2DDL_AUTO,"update");
			cfg.setProperties(props);
			cfg.addAnnotatedClass(Customer.class);
			StandardServiceRegistryBuilder ssrbuilder=new StandardServiceRegistryBuilder();
			ServiceRegistry serviceReg=ssrbuilder.applySettings(cfg.getProperties()).build();
			sf=cfg.buildSessionFactory(serviceReg);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
