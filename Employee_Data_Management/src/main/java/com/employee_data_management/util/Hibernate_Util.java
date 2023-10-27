package com.employee_data_management.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.employee_data_management.model.Employee;

public class Hibernate_Util {
	private static SessionFactory sessionfactory;

	public static SessionFactory getSessionFactory() {
		if (sessionfactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties setting = new Properties();
				setting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				setting.put(Environment.URL, "jdbc:mysql://localhost:3306/Employee?useSSL=false");
				setting.put(Environment.USER, "root");
				setting.put(Environment.PASS, "root");
				setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				setting.put(Environment.HBM2DDL_AUTO, "create-drop");
				setting.put(Environment.SHOW_SQL, "true");
				setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				configuration.setProperties(setting);
				configuration.addAnnotatedClass(Employee.class);

				ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionfactory = configuration.buildSessionFactory(serviceregistry);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		return sessionfactory;
	}

}
