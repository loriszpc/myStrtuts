package loris.util;


import loris.vo.ActionForm;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * Created by 35378 on 2018/3/22.
 */
public class GenForm {

    public GenForm(){

    }

    public static ActionForm genForm(String formPath, HttpServletRequest request){

        ActionForm form = null;

        try {
            Class clazz = Class.forName(formPath);
            form = (ActionForm)clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for(Field f:fields){
                f.setAccessible(true);
                f.set(form,request.getParameter(f.getName()));
                f.setAccessible(false);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("form装载失败！！！");
        }

        return form;
    }


}
