package loris.struts;


import loris.vo.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Loris on 2018/3/21.
 */
public interface Action {


    String execute(HttpServletRequest request,
                   HttpServletResponse response,
                   ActionForm form,
                   Map<String, String> actionForward) throws Exception;

}
