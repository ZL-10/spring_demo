package com.zl.utils;


import javax.sql.DataSource;
import java.sql.Connection;


public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocals=new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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
