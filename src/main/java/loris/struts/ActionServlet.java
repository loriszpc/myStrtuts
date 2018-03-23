package loris.struts;


import loris.util.GenForm;
import loris.vo.ActionForm;
import loris.vo.XmlBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Loris on 2018/3/21.
 */
public class ActionServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得请求头
        String requestPath = request.getServletPath().split("\\.")[0];
        //获取注册信息
        Map<String, XmlBean> map = (Map<String, XmlBean>) this.getServletContext().getAttribute("struts");

        XmlBean xml = map.get(requestPath);
        String beanName = xml.getBeanName();
        ActionForm form = GenForm.genForm(beanName, request);
        String actionClass = xml.getActionClass();
        Action action = null;
        String path = null;
        String url = "";

        try {

            Class clazz = Class.forName(actionClass);
            action = (Action) clazz.newInstance();
            url=action.execute(request,response,form,xml.getForwardMap());
        } catch (Exception e) {
            System.out.println("严重错误：bean装载错误");
            e.printStackTrace();
        }


        RequestDispatcher dis = request.getRequestDispatcher(url);;
        dis.forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
