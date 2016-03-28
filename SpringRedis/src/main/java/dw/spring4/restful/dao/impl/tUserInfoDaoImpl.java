package dw.spring4.restful.dao.impl;

import dw.spring4.restful.dao.tUserInfoDao;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/24/16.
 */
@Component("UserDAOImpl")
public class tUserInfoDaoImpl implements tUserInfoDao {
    private RedisTemplate redisTemplate;
    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    @Resource(name = "redisTemplate")
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public List<String> getAll() {
        final RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
        final Long pwdLogSize=redisTemplate.opsForList().size("huqiliang");
        List<Object> pwdLogList=redisTemplate.executePipelined(new RedisCallback<String>() {

            public String doInRedis(RedisConnection conn)
                    throws DataAccessException {
                for (int i=0 ;i<pwdLogSize ;i++) {
                    byte[] listName  = serializer.serialize("getpwdList");
                    conn.rPop(listName);
                }
                return null;
            }
        }, serializer);
        //  去除结果中的null
        ArrayList<String> newList=new ArrayList<String>();
        for (Object o : pwdLogList) {
            if(o!=null)
                newList.add(String.valueOf(o));
        }
        return newList;



    }
}
