package com.fengwuj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection
{
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/mydb";
    private final static String USER = "root";
    private final static String PASSWORD = "jb961125";
    private Connection conn=null;
    
   static{
	   try {
		    Class.forName(DRIVER);
			System.out.println("成功加载驱动");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
    
    public Connection getConnection() throws SQLException
    {
    	this.conn = DriverManager.getConnection(URL,USER,PASSWORD);
        return this.conn;
    }
    
    public void close()
    {
        if(this.conn!=null)
        {
            try
            {
                this.conn.close();
            } catch (SQLException e)
            {
                System.out.println("数据库连接关闭失败");
            }
        }
    }
}