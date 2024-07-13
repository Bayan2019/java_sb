/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kz.bitlab.java_sb.configs;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;


/**
 *
 * @author bayan
 */
@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories(
    entityManagerFactoryRef="entity1",
    basePackages="kz.bitlab.java_sb.repository",
    transactionManagerRef="transaction1"
)

public class Configuration1 {
    @Primary
    @Bean(name="dataSource1")
    @ConfigurationProperties(prefix="spring.db1.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="builder1")
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder1() {
    return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }

    @Primary
    @Bean(name="entity1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
        @Qualifier("dataSource1") DataSource dataSource
    ) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return entityManagerFactoryBuilder1().dataSource(dataSource)
            .properties(properties)
            .packages("kz.bitlab.java_sb.model")
            .persistenceUnit("db1")
            .build();
    }

    @Bean(name="transaction1")
    public PlatformTransactionManager transaction1(
        @Qualifier("entity1") EntityManagerFactory entity1
    ) {
        return new JpaTransactionManager(entity1);
    }
}
