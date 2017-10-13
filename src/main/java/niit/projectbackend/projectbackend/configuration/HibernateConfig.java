package niit.projectbackend.projectbackend.configuration;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("shubham");
		dataSource.setPassword("");
		return dataSource;		
	}
	
	@Bean
	public LocalSessionFactoryBuilder sessionFactory()
	{
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(dataSource());
		//sessionFactory.getDataSource();
		sessionFactory.scanPackages("niit.projectbackend.projectbackend");
		sessionFactory.setProperties(hibernateProperties());
		return sessionFactory;
	}
	
	public Properties hibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql","org.hibernate.SQL");
		return properties;
	}
}
