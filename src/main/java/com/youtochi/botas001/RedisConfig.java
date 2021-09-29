package com.youtochi.botas001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:config/redis.properties")
@ComponentScan
public class RedisConfig {

	@Autowired
	private Environment env;
	



	@Bean(name = "miofriojol")
	public RedisConnectionFactory redisConnectionFactory() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(10);
		jedisPoolConfig.setMaxIdle(5);
		jedisPoolConfig.setMinIdle(1);
		jedisPoolConfig.setTestOnBorrow(true);
		jedisPoolConfig.setTestOnReturn(true);
		jedisPoolConfig.setTestWhileIdle(true);
		
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(env.getProperty("redis.host").trim());
		jedisConnectionFactory.setPort(Integer.parseInt(env.getProperty("redis.port").trim()));
		jedisConnectionFactory.setPassword(env.getProperty("redis.password").trim());
		jedisConnectionFactory.setDatabase(Integer.parseInt(env.getProperty("redis.database").trim()));
		jedisConnectionFactory.setUsePool(true);	
		
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		return jedisConnectionFactory;
	}

	
/*	
	 @Bean

	    public JedisConnectionFactory jedisConnectionFactory() throws URISyntaxException {

		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(10);

		jedisPoolConfig.setMaxIdle(5);

		jedisPoolConfig.setMinIdle(1);

		jedisPoolConfig.setTestOnBorrow(true);

		jedisPoolConfig.setTestOnReturn(true);

		jedisPoolConfig.setTestWhileIdle(true);

		    
		String envRedisUrl = System.getenv("REDIS_URL");

		URI redisUri = new URI(envRedisUrl);



		RedisStandaloneConfiguration hostConfig = new RedisStandaloneConfiguration();

		//hostConfig.setPort(redisUri.getPort());

		//hostConfig.setHostName(redisUri.getHost());

		///hostConfig.setPassword(redisUri.getUserInfo().split(":", 2)[1]);
		hostConfig.setHostName(env.getProperty("redis.host").trim());
		hostConfig.setPort(Integer.parseInt(env.getProperty("redis.port").trim()));
		hostConfig.setPassword(env.getProperty("redis.password").trim());    
		hostConfig.setDatabase(Integer.parseInt(env.getProperty("redis.database").trim()));

		JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();

		JedisClientConfiguration clientConfig = builder

			.usePooling()

			.poolConfig(jedisPoolConfig)

			.build();

		JedisConnectionFactory factory = new JedisConnectionFactory(hostConfig, clientConfig);

		return factory;

	    }
*/

	
	
	@Bean
	public RedisTemplate<String, String> redisTemplate() {
		RedisTemplate<String, String> redisTemplate = new StringRedisTemplate();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}
