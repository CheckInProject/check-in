package ru.kpfu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
@PropertySource(value = "/properties/db.properties")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ru.kpfu.repositories")
public class PersistenceConfig {
    @Autowired
    private Environment environment;

    @Bean
    PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("ru/kpfu/models");
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        //adapter.setGenerateDdl(true);
        return adapter;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        driverManagerDataSource.setUrl(environment.getProperty("jdbc.url"));
        driverManagerDataSource.setUsername(environment.getProperty("jdbc.username"));
        driverManagerDataSource.setPassword(environment.getProperty("jdbc.password"));
        return driverManagerDataSource;
    }
}
