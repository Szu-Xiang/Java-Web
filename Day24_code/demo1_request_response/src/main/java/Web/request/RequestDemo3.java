package Web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 操作请求头：
 *  方法：getHeader(String name):获取指定名称请求头的值
 *  常用的请求头：
 *      user-agent：客户端浏览器的版本信息  方便针对不同的浏览器做兼容性处理
 *      referer：从哪里进入到当前资源的地址  如果是直接访问 则为null 防盗链
 */

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //user-agent：客户端浏览器的版本信息  方便针对不同的浏览器做兼容性处理
        String userAgent = req.getHeader("user-agent");
        System.out.println("userAgent = " + userAgent);

        if (userAgent.contains("Firefox")) {
            System.out.println("Hello Firefox!");
        } else if (userAgent.contains("Chrome")) {
            System.out.println("Hello Chrome!");
        } else {
            System.out.println("BaiBai~");
        }

        //referer：从哪里进入到当前资源的地址  如果是直接访问 则为null 防盗链
        String referer = req.getHeader("referer");
        System.out.println("referer = " + referer);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
