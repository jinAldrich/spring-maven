package com.yujin.spring.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCDemo {

	public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://23.105.199.23:3306/test";
        String user="yujin";
        String password="123456";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn = (Connection) DriverManager.getConnection(url, user, password);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println("[" + rs.getInt("id")+ "|"
                          + "|" + rs.getString("username") + "|" + rs.getString("pwd") + "]");
        }
        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}
