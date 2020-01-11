package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;


//@Configuration

@ComponentScan(basePackages = {"com.zl"})
@Import(JdbcConfiguration.class)
@PropertySource(value = "classpath:jdbc.properties")//从jdbc.properties读取连接数据库的信息
public class SpringConfiguration {
    //从com.config.JdbcConfiguration类中读取连接数据库的信息
}
