package test;

import mysql.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testJDBC {

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        Connection conn=JDBCUtils.getConnection();
        String sql="insert into user(username,password) value(?,?)";
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setString(1, "李四");
        pst.setString(2, "123456789");
        int row=pst.executeUpdate();
        System.out.println(row);
        JDBCUtils.close(pst, conn);
    }

}