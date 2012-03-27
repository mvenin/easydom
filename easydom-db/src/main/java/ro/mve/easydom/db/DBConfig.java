package ro.mve.easydom.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan(basePackageClasses = { ro.mve.easydom.db.DBConfig.class })
public class DBConfig {

	DBConfig() {
	}

	@Value("${jdbc.driverClassName}")
	String driverClassName;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	@Value("${hibernate.dialect}")
	String hibernateDialect;
	@Value("${hibernate.show_sql}")
	boolean hibernateShowSql;
	@Value("${hibernate.hbm2ddl.auto}")
	String hibernateHbm2ddlAuto;

	@Bean
	public static PropertyPlaceholderConfigurer properties() {
		final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		final Resource[] resources = new ClassPathResource[] { new ClassPathResource("persistence.properties"), };
		ppc.setLocations(resources);
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}

	@Bean
	public DataSource nexdomDataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.driverClassName);
		dataSource.setUrl(this.url);
		dataSource.setUsername(this.username);
		dataSource.setPassword(this.password);
		return dataSource;
	}

	@SuppressWarnings("serial")
	@Bean
	public LocalContainerEntityManagerFactoryBean orderEntityManagerFactoryBean() {
		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(this.nexdomDataSource());
		factoryBean.setPackagesToScan(new String[] { "ro.mve.easydom.db" });

		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
			{
				this.setDatabase(Database.MYSQL);
				this.setDatabasePlatform(DBConfig.this.hibernateDialect);
				this.setShowSql(DBConfig.this.hibernateShowSql);
				this.setGenerateDdl(true);
			}
		};
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setJpaProperties(new Properties() {
			{
				this.put("hibernate.hbm2ddl.auto", DBConfig.this.hibernateHbm2ddlAuto);
			}
		});
		return factoryBean;
	}

	@Bean
	public JpaTransactionManager orderTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(this.orderEntityManagerFactoryBean().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public Mapper dozerMapper() throws Exception {

		org.dozer.spring.DozerBeanMapperFactoryBean factoryBean = new DozerBeanMapperFactoryBean();
		// (Mapper) factoryBean.getObject();

		return new DozerBeanMapper();
	}

}
