package Web.request;

import bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 获取请求参数【通用方式】:
 *      不管是get请求方式提交参数，还是post请求方式提交参数 都可以使用下面这三个方法获取到请求参数值
 *      String getParameter(String name)：获取返回单个值 指定名称的参数
 *      String[] getParameterValues(String name)：获取返回多个值 指定名称的参数  【针对复选框】 会将多个值封装到String数组中
 *      Map<String,String[]> getParameterMap()：获取提交的所有参数 参数名称作为key 参数值作为value封装到Map集合中
 *
 * 请求参数中文乱码：
 *  原因：页面提交数据所使用的编码集 和服务器接收数据解析时使用的编码集不一致
 *  get方式：
 *      tomcat7插件：在插件中配置<uriEncoding>utf-8</uriEncoding>
 *      tomcat8+：不会出现乱码 tomcat已经帮我们处理好了
 *  post方式：
 *      tomcat7|tomcat8+:
 *          //设置请求体字符编码 解决post方式提交参数中文乱码
 *         request.setCharacterEncoding("UTF-8");
 */

@WebServlet("/RequestDemo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置请求体字符编码 解决post方式提交参数中文乱码
        request.setCharacterEncoding("UTF-8");

        //1.获取返回单个值的参数  参数名称=表单name属性值
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.获取返回多个值的参数
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("hobbies = " + Arrays.toString(hobbies));

        //3.获取所有参数封装到map集合中
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String string : strings) {
            System.out.println(string + " --> " + Arrays.toString(parameterMap.get(string)));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}


