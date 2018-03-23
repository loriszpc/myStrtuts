package loris.util;



import loris.vo.XmlBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;
import java.util.Map;

/**
 * Created by Loris on 2018/3/22.
 */
public class XmlListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("信息：容器开始创建！");
        ServletContext context = servletContextEvent.getServletContext();
        URL url = XmlListener.class.getClassLoader().getResource("struts-config.xml");
        context.setAttribute("path", url.getPath());

        try {
            Map<String, XmlBean> map = XmlParser.parse(url.getPath());
            context.setAttribute("struts", map);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("信息：容器被销毁！");
    }
}
