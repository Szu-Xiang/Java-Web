package Web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 操作请求行：
 *   getMethod()：获取请求方式
 *   getContextPath();获得项目发布虚拟路径
 *   getRequestURI();获得请求地址，不带协议、ip地址和端口号  应用场景：权限控制、网关
 */

@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //- getMethod();获取请求方式
        String method = req.getMethod();
        System.out.println("method = " + method);

        //- getRemoteAddr() ；获取客户机的IP地址(知道是谁请求的)
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);

        //- getContextPath();获得项目发布虚拟路径 在pom文件中定义的tomcat插件中的<path> 【重点】
        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);

        //- getRequestURI();获得请求地址，不带协议、ip地址和端口号
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        //- getRequestURL()；获得请求地址，带协议、ip地址和端口号
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL);

        //- getServerPort()；获得服务端的端口
        int serverPort = req.getServerPort();
        System.out.println("serverPort = " + serverPort);

        //- getQueryString()；获的get方式请求参数(URL的?后面拼接的请求参数  eg:username=zs&password=123456)
        String queryString = req.getQueryString();
        System.out.println("queryString = " + queryString);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
