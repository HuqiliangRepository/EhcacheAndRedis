package dw.spring3.rest.controller;


import dw.spring3.rest.bean.t_user_info;
import dw.spring3.rest.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Component("UsersController")
public class UsersController {


    private static final String XML_VIEW_NAME = "users";
    private static final String XML_VIEW_NAME_ALL = "allusers";
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Resource(name = "UserService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/input_users")
    public String inputUser() {
        return "addUser";

    }


    @RequestMapping(method = RequestMethod.POST, value = "/add_users")
    public String addUser(@RequestParam("name") String name, @RequestParam("position") String position, ModelMap map) {
        map.put("name", "��Ӣ��");
        map.put("position", "���Կ���");
        System.out.println("addUser����������");
        System.out.println("����" + name);
        System.out.println("ְλ:" + position);
        return "addSucess";

    }


    @RequestMapping(method = RequestMethod.GET, value = "/allusers")
    public ModelAndView getAll() {
        List<t_user_info> list = userService.getAll();
        for (t_user_info tui : list) {
            System.out.println("测试方法**************************************************" + tui.getAccount_name());
        }
        System.out.println("查询所有注册用户帐号数量" + list.size());
        ModelAndView mv = new ModelAndView(XML_VIEW_NAME_ALL, "users", list);
        return mv;

    }


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView getListForPage() {
        List<?> list = userService.getListForPage("from t_user_info", 1, 100);
        System.out.println("查询所有注册用户帐号数量" + list.size());
        ModelAndView mv = new ModelAndView(XML_VIEW_NAME, "users", list);
        return mv;

    }


}
