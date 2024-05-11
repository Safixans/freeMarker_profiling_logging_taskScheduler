package lesson9_9_assignment.uz.pdp.dbConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DatabaseConfiguration {
    private String username;
    private String password;
    private String url;
    private String dataSource;

    @Profile("test")
    @Bean
    public DataSource h2DataSource() {
        DriverManagerDataSource dataSourceDriver = new DriverManagerDataSource();
        dataSourceDriver.setDriverClassName(dataSource);
        dataSourceDriver.setUsername(username);
        dataSourceDriver.setPassword(password);
        dataSourceDriver.setUrl(url);
        return dataSourceDriver;
    }

    @Profile("dev")
    @Bean
    public DataSource postgresDataSource() {
        DriverManagerDataSource dataSourceDriver = new DriverManagerDataSource();
        dataSourceDriver.setDriverClassName(dataSource);
        dataSourceDriver.setUsername(username);
        dataSourceDriver.setPassword(password);
        dataSourceDriver.setUrl(url);
        return dataSourceDriver;
    }
}
