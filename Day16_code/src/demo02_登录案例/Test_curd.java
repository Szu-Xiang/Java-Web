package demo02_登录案例;

import bean.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JUnit
 * 1.导入jar包
 * 2.定义一个方法，该方法要被public修饰，且返回值类型为void没有参数
 * 3.在方法上打上@Test注解
 * 4.在方法中编写测试代码
 */
public class Test_curd {
    //1.增加用户
    @Test
    public void add() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1601?useSSL=false&serverTimezone=UTC", "root", "99a/aa/a");

        //3.获取预编译执行者对象
        String sql = "insert into user values (null, ?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);

        //设置SQL语句参数
        //添加一个名为Harry，密码为123，昵称为Ha的新用户
        pst.setString(1, "Harry");
        pst.setString(2, "123");
        pst.setString(3, "Ha");

        //4.执行操作
        int rows = pst.executeUpdate();

        //5.处理返回结果
        if (rows > 0) {
            System.out.println("增加成功");
        } else {
            System.out.println("增加失败");
        }

        //6.关闭对象，释放资源
        if (pst != null) {
            pst.close();
        }
        if (connection != null) {
            connection.close();
        }

    }

    //2.修改用户
    @Test
    public void update() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1601?useSSL=false&serverTimezone=UTC", "root", "99a/aa/a");

        //3.获取预编译执行者对象
        String sql = "update user set username = ?, password = ?, nickname = ? where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);

        //设置sql参数
        //把ID为3（ID为3并不一定是第三行，后续会有删除操作）的用户修改成一个Wong，密码为1234，昵称为隔离老王的新用户
        pst.setString(1, "Wong");
        pst.setString(2, "1234");
        pst.setString(3, "隔壁老王");
        pst.setInt(4,3);

        //4.执行操作
        int rows = pst.executeUpdate();

        //5.处理返回结果
        if (rows > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        pst.close();
        connection.close();

    }

    //3.删除用户
    @Test
    public void delete() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1601?useSSL=false&serverTimezone=UTC", "root", "99a/aa/a");

        //3.获取预编译执行者对象
        String sql = "delete from user where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);

        //4.执行操作
        pst.setInt(1, 2);//删除ID为2的老李
        int rows = pst.executeUpdate();

        //5.返回结果
        if (rows > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        //释放资源
        pst.close();
        connection.close();
    }

    //4.查询所有用户
    @Test
    public void selectAll() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1601?useSSL=false&serverTimezone=UTC", "root", "99a/aa/a");

        //3.获取预编译执行对象
        String sql = "select * from user";
        PreparedStatement pst = connection.prepareStatement(sql);

        //4.执行操作
        ResultSet rs = pst.executeQuery();

        //5.返回结果
        List<User> list = new ArrayList<>();
        User user = null;
        while (rs.next()) {
            user = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("nickname"));
            list.add(user);
        }
        for (User user1 : list) {
            System.out.println("user1 = " + user1);
        }

        //6.释放资源
        rs.close();
        pst.close();
        connection.close();
    }

    //查询指定用户
    @Test
    public void selectById() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1601?useSSL=false&serverTimezone=UTC", "root", "99a/aa/a");

        //3.获取预编译执行者对象
        String sql = "select * from user where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);

        //4.执行操作
        pst.setInt(1, 5);
        ResultSet rs = pst.executeQuery();

        //5.处理返回结果
        User user = null;
        while (rs.next()) {
            user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nickname"));
        }

        System.out.println("user = " + user);

        //6.释放资源
        rs.close();
        pst.close();
        connection.close();
    }
}
