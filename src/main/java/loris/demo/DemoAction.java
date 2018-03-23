package loris.demo;

import loris.struts.Action;
import loris.vo.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by 35378 on 2018/3/22.
 */
public class DemoAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, ActionForm form, Map<String, String> actionForward) throws Exception {

        System.out.println("从前台拿到的数据为："+form.toString());

        request.setAttribute("data","1111");
        return actionForward.get("fail").toString();
    }
}
