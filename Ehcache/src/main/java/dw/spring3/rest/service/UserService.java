package dw.spring3.rest.service;

import dw.spring3.rest.bean.t_user_info;
import dw.spring3.rest.dao.UserDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/8/7.
 */
@Component("UserService")
public class UserService {
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Resource(name = "UserDAOImpl")
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // @Transactional
    public List<t_user_info> getAll() {
        return userDAO.getAll();
    }

    public List<?> getListForPage(final String hql, final int offset, final int length) {
        List<?> list = userDAO.getListForPage(hql, offset, length);
        return list;
    }
}
