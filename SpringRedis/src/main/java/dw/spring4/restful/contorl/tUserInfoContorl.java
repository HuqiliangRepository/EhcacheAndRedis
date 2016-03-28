package dw.spring4.restful.contorl;

import dw.spring4.restful.model.t_user_info;
import dw.spring4.restful.service.tUserInfoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 3/24/16.
 */
@Controller
@Component("tUserInfoContorl")
public class tUserInfoContorl {

    private static final String XML_VIEW_NAME_ALL = "allusers";
    private tUserInfoService UIService;
    public tUserInfoService getUIService() {
        return UIService;
    }

    @Resource(name = "tUserInfoService")
    public void setUIService(tUserInfoService UIService) {
        this.UIService = UIService;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/allusers")
    public ModelAndView getAll() {
        List<t_user_info> list = UIService.getAll();
        System.out.println("查询所有注册用户帐号数量" + list.size());
        ModelAndView mv = new ModelAndView(XML_VIEW_NAME_ALL, "users", list);
        return mv;

    }
}
