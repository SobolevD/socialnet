package usr.dmso.socialnet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import usr.dmso.socialnet.constants.HibernateProperties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static usr.dmso.socialnet.constants.Common.AUTO_DDL_UPDATE_VALUE;
import static usr.dmso.socialnet.constants.Common.MAIN_PACKAGE_AS_FOLDER;
import static usr.dmso.socialnet.constants.DatabaseConstants.*;

@Configuration
@ComponentScan(basePackages = "java")
@EnableTransactionManagement
public class DataSourceConfig {

    @Value(DATABASE_URL_PLACEHOLDER)
    private String databaseUrl;

    @Value(DATABASE_USERNAME_PLACEHOLDER)
    private String databaseUsername;

    @Value(DATABASE_PASSWORD_PLACEHOLDER)
    private String databasePassword;

    @Bean
    public DataSource getDataSource() {

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(databaseUrl);
        dataSourceBuilder.username(databaseUsername);
        dataSourceBuilder.password(databasePassword);
        return dataSourceBuilder.build();
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put(HibernateProperties.DIALECT, POSTGRES_DIALECT);
        hibernateProp.put(HibernateProperties.SHOW_SQL, Boolean.FALSE.toString());
        hibernateProp.put(HibernateProperties.AUTO_DDL, AUTO_DDL_UPDATE_VALUE);
        hibernateProp.put(HibernateProperties.SQL_FORMAT, Boolean.TRUE.toString());
        return hibernateProp;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan(MAIN_PACKAGE_AS_FOLDER);
        factoryBean.setDataSource(getDataSource());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }
}