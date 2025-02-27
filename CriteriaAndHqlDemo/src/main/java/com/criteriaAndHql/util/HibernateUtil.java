package com.criteriaAndHql.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.criteriaAndHql.entity.Employee;
import com.criteriaAndHql.entity.Company;



public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getseSessionFactory() {

			if (sessionFactory == null) {
				try {
					Configuration configuration = new Configuration();
					Properties setting = new Properties();
					setting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
					setting.put(Environment.URL, "jdbc:mysql://localhost:3306/quiz");
					setting.put(Environment.USER, "root");
					setting.put(Environment.PASS, "Admin@123");

					setting.put(Environment.SHOW_SQL, true);
					setting.put(Environment.FORMAT_SQL, false);

					setting.put(Environment.USE_SECOND_LEVEL_CACHE, true);
					setting.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");

					setting.put(Environment.HBM2DDL_AUTO, "update");
					configuration.setProperties(setting);

					configuration.addAnnotatedClass(Company.class);
					configuration.addAnnotatedClass(Employee.class);
					
					

//					ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//							.applySettings(configuration.getProperties()).build();
					sessionFactory = configuration.buildSessionFactory();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return sessionFactory;
		}
}
