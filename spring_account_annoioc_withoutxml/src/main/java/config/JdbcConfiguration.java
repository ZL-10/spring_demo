package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

//@Configuration

public class JdbcConfiguration {
    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;


    @Bean(name = "dataSource1")
    public DataSource createDataSource1(){
        try{
            ComboPooledDataSource dataSource=new ComboPooledDataSource();
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            return dataSource;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "dataSource2")
    public DataSource createDataSource2(){
        try{
            ComboPooledDataSource dataSource=new ComboPooledDataSource();
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ssm_study1");
            return dataSource;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "runner")
    @Scope(value = "prototype")
    public QueryRunner createQueryRunner(@Qualifier(value = "dataSource2") DataSource dataSource){
        return new QueryRunner(dataSource);
    }
}
