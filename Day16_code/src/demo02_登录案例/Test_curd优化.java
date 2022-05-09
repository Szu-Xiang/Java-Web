package demo02_登录案例;

import bean.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Test_curd优化 {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Before
    public void before() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接对象
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1601?useSSL=false&serverTimezone=UTC", "root", "99a/aa/a");

    }

    @After
    public void after() throws Exception {
        rs.close();
        pst.close();
        connection.close();

    }

    //1.增加用户
    @Test
    public void add() throws Exception {
        //获取预编译执行对象
        String sql = "insert into user values (null, ?, ?, ?)";
        pst = connection.prepareStatement(sql);

        //设置sql语句
        pst.setString(1,"Dear");
        pst.setString(2,"234");
        pst.setString(3,"Lu");

        //执行操作
        int rows = pst.executeUpdate();

        //返回结果
        if (rows > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

    }

    //查询单个用户
    @Test
    public void selectById() throws Exception {
        //获取预编译执行对象
        String sql = "select * from user where id =?";
        pst = connection.prepareStatement(sql);

        //设置sql语句
        pst.setInt(1, 6);

        //执行操作
        rs = pst.executeQuery();

        //返回结果
        User user = null;
        while(rs.next()){
            user = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("nickname"));
        }

        System.out.println("user = " + user);

    }

    //查询用户
    @Test
    public void selectAll() throws Exception {
        //获取预编译对象
        String sql = "select * from user";
        pst = connection.prepareStatement(sql);

        //执行操作
        rs = pst.executeQuery();

        //返回结果
        List<User> list = new ArrayList<>();
        User user = null;
        while (rs.next()) {
            user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nickname"));
            list.add(user);
        }

        for (User user1 : list) {
            System.out.println("user1 = " + user1);
        }


    }
}
