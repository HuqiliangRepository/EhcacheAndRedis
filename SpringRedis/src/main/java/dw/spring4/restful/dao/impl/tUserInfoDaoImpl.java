package dw.spring4.restful.dao.impl;

import dw.spring4.restful.dao.tUserInfoDao;
import dw.spring4.restful.model.t_user_info;
import dw.spring4.restful.until.SerializeUtil;
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
@Component("tUserInfoDaoImpl")
public class tUserInfoDaoImpl implements tUserInfoDao {
    private RedisTemplate redisTemplate;
    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    @Resource(name = "redisTemplate")
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public List<t_user_info> getAll() {
        List<t_user_info> ll= (List<t_user_info>)redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] value = redisConnection.get("tuilist".getBytes());
                List<t_user_info> tuilist = (List<t_user_info>) SerializeUtil.unserialize(value);
                return tuilist;
            }

        });
        return ll;

    }



}