package test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTest{

        public static void authenticationGuild()throws ClassNotFoundException, SQLException,InterruptedException{
            //封装获取普通用户手机号码的方法
            String driver="com.mysql.jdbc.Driver";    //驱动程序名
            String url="jdbc:mysql://xxxxxx:3306/base";   //URL指向要访问的数据库名
            String user="achao";
            String password="1q2w3E4R.123abc";
            java.sql.Connection con;
            String sql;
            String u_mobile_number=null;
            String telphone;

            Class.forName(driver);  //动态加载驱动程序
            con= DriverManager.getConnection(url,user,password);    //getConnection()方法连接数据库
            if(!con.isClosed())
            System.out.println("数据库连接成功！");
            Statement statement=con.createStatement();    //创建statement类对象，用来执行SQL语句
            sql="SELECT u_mobile_number FROM base_user WHERE user_type = '0' ORDER BY user_id DESC LIMIT 1;";
            //普通用户
            ResultSet rs=statement.executeQuery(sql);     //ResultSet类，用来存放获取的结果集
            while(rs.next()){
            u_mobile_number=rs.getString("u_mobile_number");  //获取u_mobile_number这一列的数据
            System.out.println(u_mobile_number);
            }
            rs.close();     //关闭ResultSet对象
            con.close();    //关闭数据库连接
            telphone=u_mobile_number;
            }
    }