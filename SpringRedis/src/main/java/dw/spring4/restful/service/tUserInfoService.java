package dw.spring4.restful.service;

import dw.spring4.restful.dao.tUserInfoDao;
import dw.spring4.restful.model.t_user_info;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 3/24/16.
 */
@Component("tUserInfoService")
public class tUserInfoService {

    private tUserInfoDao userInfoDao;

    public tUserInfoDao getUserInfoDao() {
        return userInfoDao;
    }
    @Resource(name = "tUserInfoDaoImpl")
    public void setUserInfoDao(tUserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

   public List<t_user_info> getAll(){

        return  userInfoDao.getAll();

    }


}
