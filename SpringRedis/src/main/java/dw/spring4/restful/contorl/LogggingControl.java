package dw.spring4.restful.contorl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by root on 5/11/16.
 */
/*如果想获得HttpServletRequest与HttpServletResponse等对象直接在方法的参数当中直接申明就可以了*/
    /*如果想实现从定向跳转，需要在方法返回时：return "redirect:http://www.baidu.com"这样子就可以实现页面重定向跳转*/
@Controller
@Component("Loggging")
@SessionAttributes({"username", "password"})
public class LogggingControl {
    private static final String XML_VIEW_NAME_ALL = "logging";

    @RequestMapping(method = RequestMethod.GET, value = "/logging")
    public ModelAndView logging() {

        System.out.println("用户开始登录.......");
        ModelAndView mv = new ModelAndView(XML_VIEW_NAME_ALL);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/verification")

    public ModelAndView verification(@RequestParam("username") String name, @RequestParam("password") String password, ModelMap map) {

        System.out.println("输入用户名与密码........." + "用户名:" + name + "密码:" + password);
        map.put("username", name);
        map.put("password", password);
        ModelAndView mv = new ModelAndView("loggingverif", "info", map);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/verification")
    /*ModelAttribute用于将保存在ModelMap当中的值获取出来付给自己定义的变量*/
    public ModelAndView byvalues(@ModelAttribute("username") String name, @ModelAttribute("password") String password, ModelMap map) {

        System.out.println("输入用户名与密码........." + "用户名:" + name + "密码:" + password);
        ModelAndView mv = new ModelAndView("loggingverif", "info", map);
        return mv;
    }

}
