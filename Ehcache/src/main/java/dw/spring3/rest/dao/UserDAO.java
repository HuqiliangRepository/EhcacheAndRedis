package dw.spring3.rest.dao;

import dw.spring3.rest.bean.t_user_info;

import java.util.List;

/**
 * Created by Administrator on 2015/8/5.
 */
public interface UserDAO {
    List<t_user_info> getAll();

    List<?> getListForPage(final String hql, final int offset, final int length);
}
