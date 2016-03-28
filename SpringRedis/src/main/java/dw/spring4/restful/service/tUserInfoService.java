package dw.spring4.restful.service;

import dw.spring4.restful.dao.tUserInfoDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 3/24/16.
 */

public class tUserInfoService {

    private tUserInfoDao userInfoDao;

    public tUserInfoDao getUserInfoDao() {
        return userInfoDao;
    }
    @Resource(name = "tUserInfoDaoImpl")
    public void setUserInfoDao(tUserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

   public List<String> getAll(){

        return  userInfoDao.getAll();

    }


}
