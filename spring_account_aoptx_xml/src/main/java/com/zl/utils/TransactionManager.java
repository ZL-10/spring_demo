package com.zl.utils;



public class TransactionManager {
    private ConnectionUtils connectionUtil;

    public void setConnectionUtil(ConnectionUtils connectionUtil) {
        this.connectionUtil = connectionUtil;
    }


    public void beginTransaction() {
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            connectionUtil.getThreadConnection().close();
            connectionUtil.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
