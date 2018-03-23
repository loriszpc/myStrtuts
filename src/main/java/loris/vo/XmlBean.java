package loris.vo;

import java.util.Map;

/**
 * Created by 35378 on 2018/3/22.
 */
public class XmlBean {

    public XmlBean() {

    }

    private String beanName; //模型名称
    private String path;    //请求路径
    private String actionClass; //请求对应的action类
    private String ref; //action类与bean类进行匹配的字符
    private Map<String, String> forwardMap; //请求路径和页面之间的对应

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getActionClass() {
        return actionClass;
    }

    public void setActionClass(String actionClass) {
        this.actionClass = actionClass;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Map<String, String> getForwardMap() {
        return forwardMap;
    }

    public void setForwardMap(Map<String, String> forwardMap) {
        this.forwardMap = forwardMap;
    }

    @Override
    public String toString() {
        return "XmlBean{" +
                "beanName='" + beanName + '\'' +
                ", path='" + path + '\'' +
                ", actionClass='" + actionClass + '\'' +
                ", ref='" + ref + '\'' +
                ", forwardMap=" + forwardMap +
                '}';
    }

}
