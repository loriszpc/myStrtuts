package loris.util;


import loris.vo.XmlBean;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Loris on 2018/3/21.
 */
public class XmlParser {

    public XmlParser() {

    }


    public static Map<String, XmlBean> parse(String configPath) throws Exception {
        //根据配置文件路径获取配置文件内容
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new File(configPath));
        Element root = document.getRootElement();
        //用来存放请求路径对应的相关信息
        Map<String, XmlBean> xmlMap = new HashMap<String, XmlBean>();
        //获取actions标签下全部的action
        Element actions = root.getChild("actions");
        List<Element> actionList = actions.getChildren();


        for (Element actionElement : actionList) {
            XmlBean xmlBean = new XmlBean();
            //action对应bean的标记符
            String ref = actionElement.getAttributeValue("ref");
            xmlBean.setRef(ref);
            Element beans = root.getChild("beans");
            List<Element> beanList = beans.getChildren();

            for (Element beanElement : beanList) {
                if (ref.equals(beanElement.getAttributeValue("name"))) {
                    String beanClass = beanElement.getAttributeValue("class");
                    xmlBean.setBeanName(beanClass);
                    break;
                }
            }

            String path = actionElement.getAttributeValue("path");
            xmlBean.setPath(path);
            String actionClass = actionElement.getAttributeValue("actionClass");
            xmlBean.setActionClass(actionClass);

            //获取请求路径对应的分发页面
            List<Element> forwardList = actionElement.getChildren("forward");

            Map<String, String> map = new HashMap<String, String>();

            for (Element forward : forwardList) {
                String forwardName = forward.getAttributeValue("name");
                String forwardValue = forward.getAttributeValue("value");
                map.put(forwardName, forwardValue);
            }
            xmlBean.setForwardMap(map);

            xmlMap.put(path, xmlBean);
        }

        return xmlMap;

    }




    public static void main(String[] args) throws Exception {
        String path = "D:\\D\\Project\\struts\\out\\artifacts\\struts_war_exploded/WEB-INF/struts-config.xml";
        parse(path);
    }

}
