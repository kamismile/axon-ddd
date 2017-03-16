package com.dms.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration extends AppConfiguration{
	
	@Bean(name="redisTemplate")
    public RedisTemplate redisTemplate(){
		RedisTemplate redisTemplate = new RedisTemplate(); 
		redisTemplate.setConnectionFactory(jedisConnFactory());
    	return redisTemplate;
    }
	
	@Bean(name="jedisConnFactory")
    public JedisConnectionFactory jedisConnFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setUsePool(true);
		jedisConnectionFactory.setHostName("118.89.106.220");
		jedisConnectionFactory.setPort(6379);
        return jedisConnectionFactory;
    }
	
}
