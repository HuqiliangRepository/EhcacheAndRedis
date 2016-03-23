package dw.spring3.rest.dao.impl;

import dw.spring3.rest.bean.t_user_info;
import dw.spring3.rest.dao.UserDAO;
import dw.spring3.rest.until.PageNoUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/8/5.
 */
@Component("UserDAOImpl")
public class UserDAOImpl implements UserDAO {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    @Cacheable(value = "sampleCache1")
    public List<t_user_info> getAll() {
        List<t_user_info> list;
        hibernateTemplate.setCacheQueries(true);
        //list = (List<t_user_info>) hibernateTemplate.load(t_user_info.class, 1L, LockMode.UPGRADE);

        list = hibernateTemplate.loadAll(t_user_info.class);
        //  throw new RuntimeException("出错了啊");
        return list;
    }


    @Cacheable(value = "sampleCache1", key = "#hql")
    public List<?> getListForPage(final String hql, final int offset, final int length) {

        return (List<?>) getHibernateTemplate().execute(
                new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        return PageNoUtil.getList(session, hql, offset, length);
                    }
                });
    }
}
