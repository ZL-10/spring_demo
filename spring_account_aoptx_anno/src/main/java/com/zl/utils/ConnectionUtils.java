package com.zl.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component("connectionUtil")
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocals=new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;


    public Connection getThreadConnection(){
        Connection conn=threadLocals.get();
        try{
            if(conn==null){
                conn=dataSource.getConnection();
                threadLocals.set(conn);
            }
        }catch (Exception e){
           throw new RuntimeException(e);
        }
        return conn;
    }

    public void removeConnection(){
        threadLocals.remove();
    }
}
