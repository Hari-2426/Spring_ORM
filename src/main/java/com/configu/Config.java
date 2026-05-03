package com.configu;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class Config {
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactory()
	{
		LocalSessionFactoryBean ls=new LocalSessionFactoryBean();
		ls.setDataSource(getDataSource());
		ls.setPackagesToScan("com");
		ls.setHibernateProperties(getProperties());
		return ls;
	}
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/springorm");
		ds.setUsername("root");
		ds.setPassword("root123");
		return ds;
	}
	@Bean
	public Properties getProperties()
	{
		Properties p=new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;
	}
	@Bean
	public HibernateTransactionManager htm(SessionFactory sf)
	{
		HibernateTransactionManager hm=new HibernateTransactionManager();
		hm.setSessionFactory(sf);
		return hm;
	}
}
