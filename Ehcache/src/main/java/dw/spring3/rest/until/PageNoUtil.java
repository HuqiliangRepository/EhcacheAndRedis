package dw.spring3.rest.until;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Administrator on 2015/9/2.
 */
public class PageNoUtil {
    /**
     * @param session :һ���Ự
     * @param hql:����Ҫִ�е�hql��䣬
     * @param offset ���ÿ�ʼλ��
     * @param length:��ȡ��¼����
     * return             ���ؽ��List<?>��ʾһ�����͵�List
     */

    private static Logger log = Logger.getLogger(PageNoUtil.class);

    public static List<?> getList(Session session, String hql, int offset, int length) {
        Query query = session.createQuery(hql).setCacheable(true);
        query.setFirstResult(offset);
        query.setMaxResults(length);
        log.debug("========================================================" + hql);
        List<?> list = query.list();
        log.debug("#############################################size" + list.size());
        return list;
    }

}
