package demo02_登录案例;

import bean.User;

import java.sql.*;
import java.util.Scanner;

/**
 * 使用statement对象完成登录案例
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.接收用户键盘输入的用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();


        //2.根据用户名输入的用户名和密码查询数据库
        //2.1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.2 获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1601?useSSL=false&serverTimezone=UTC", "root", "99a/aa/a");

        //2.3 获取statement执行者对象 (会出现问题，会用PreparedStatement对象解决)
        Statement statement = connection.createStatement();

        //2.4 执行查询sql语句，添加where条件
        ResultSet resultSet = statement.executeQuery("select * form user where username = '" + username + "' and password = '" + password + " ' ");

        //2.5 处理结果 将查询到的结果集封装到对象中（有也就一条记录）


        //2.6 关闭对象 释放资源

        //3. 判断对象是否登录成功 user == null，登录失败
        //                     user != null 登录成功
    }

}
