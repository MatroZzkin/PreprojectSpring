package common.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("common")
@PropertySource("classpath:database.properties")

public class DBConfig {
    @Resource
    private Environment env;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("database.driver"));
        dataSource.setUrl(env.getRequiredProperty("database.url"));
        dataSource.setUsername(env.getRequiredProperty("database.root"));
        dataSource.setPassword(env.getRequiredProperty("database.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPackagesToScan("common.model");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager getManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());
        return manager;
    }

     private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return properties;
    }
}
