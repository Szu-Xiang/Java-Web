package Web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RequestDemo7")
public class RequestDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestDemo7...");

        //转发之前 在request域对象中存储数据实现一次请求间共享
        request.setAttribute("name","zhangshuai");
        request.setAttribute("username", "Harry");

        //http://localhost:8080/day24/requestDemo07
        //http://localhost:8080/day24/requestDemo08
        //现在从requestDemo07跳转到requestDemo08就可以直接写相对路径  写的就是requestDemo08
        request.getRequestDispatcher("RequestDemo8").forward(request,response);

        //请求转发到百度  访问不到
        //request.getRequestDispatcher("http://www.baidu.com").forward(request,response);

        //请求转发到WEB-INF下的a.html  正常访问
        //request.getRequestDispatcher("WEB-INF/a.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
