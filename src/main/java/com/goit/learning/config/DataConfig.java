package com.goit.learning.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.goit.learning")
@PropertySource("classpath:app.properties")
@EnableJpaRepositories("com.goit.learning.repositories")
@EnableWebMvc
public class DataConfig {
    private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USER_NAME = "db.username";
    private static final String PROP_DATABASE_PASSWORD = "db.password";
    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROP_HIBERNATE_FORMAT_SQL = "db.hibernate.format_sql";
    private static final String PROP_ENTITY_MANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    private static final String PROP_C3P0_MIN_SIZE = "db.hibernate.c3p0.min_size";
    private static final String PROP_C3P0_MAX_SIZE = "db.hibernate.c3p0.max_size";


    @Autowired
    private Environment environment;

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(environment.getRequiredProperty(PROP_DATABASE_DRIVER));
        dataSource.setJdbcUrl(environment.getRequiredProperty(PROP_DATABASE_URL));
        dataSource.setUser(environment.getRequiredProperty(PROP_DATABASE_USER_NAME));
        dataSource.setPassword(environment.getRequiredProperty(PROP_DATABASE_PASSWORD));
        dataSource.setMinPoolSize(environment.getRequiredProperty(PROP_C3P0_MIN_SIZE, Integer.class));
        dataSource.setMaxPoolSize(environment.getRequiredProperty(PROP_C3P0_MAX_SIZE, Integer.class));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(PROP_ENTITY_MANAGER_PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setJpaVendorAdapter(getJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }

    private JpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(environment.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL, Boolean.class));
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROP_HIBERNATE_DIALECT, environment.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        properties.put(PROP_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        properties.put(PROP_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROP_HIBERNATE_FORMAT_SQL));
        return properties;
    }
}
