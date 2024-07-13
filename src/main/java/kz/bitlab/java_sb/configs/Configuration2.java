package kz.bitlab.java_sb.configs;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef="entity2",
    basePackages="kz.bitlab.java_sb.repository2",
    transactionManagerRef="transaction2"
)
public class Configuration2 {
    @Primary
    @Bean(name="dataSource2")
    @ConfigurationProperties(prefix="spring.db2.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="builder2")
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder2() {
    return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }

    @Primary
    @Bean(name="entity2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
        @Qualifier("dataSource2") DataSource dataSource
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("hibernate.hbm2ddl.auto", "update");

        return entityManagerFactoryBuilder2().dataSource(dataSource)
            .properties(hashMap)
            .packages("kz.bitlab.java_sb.model2")
            .persistenceUnit("db2")
            .build();
    }

    @Bean(name="transaction2")
    public PlatformTransactionManager transaction2(
        @Qualifier("entity2") EntityManagerFactory entity2
    ) {
        return new JpaTransactionManager(entity2);
    }
}
