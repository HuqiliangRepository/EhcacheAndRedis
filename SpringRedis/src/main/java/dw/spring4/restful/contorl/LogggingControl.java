package dw.spring4.restful.contorl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by root on 5/11/16.
 */
@Controller
@Component("Loggging")
public class LogggingControl {
    private static final String XML_VIEW_NAME_ALL = "logging";

    @RequestMapping(method = RequestMethod.GET, value = "/logging")
    public ModelAndView logging() {

        System.out.println("用户开始登录.......");
        ModelAndView mv = new ModelAndView(XML_VIEW_NAME_ALL);
        return mv;
    }

}
