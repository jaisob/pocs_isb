package project.ebd;

import java.io.IOException;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class EventConsumer {

	private final static String REDIS_KEY = "clients";
	private static final int NUM_BATCH_MESSAGES = 100;
	private int numMessage = 0;
	private JedisPool jedisPool;
	//private Jedis jedis;
	
	public EventConsumer(String host, Integer port) throws IOException {
		//jedis = new Jedis(host, port, 4000);
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setTestOnBorrow(true);
		jedisPool = new JedisPool(config, host, port, 4000, null, 1);
	}

	public void write(Object[] args) throws IOException {

		EventRegister event = EventRegister.getInstance(args);
	
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.rpush(REDIS_KEY, event.JsonOutput().toString());
			System.out.println(event.JsonOutput().toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			jedis.close();
		}
		if(numMessage == NUM_BATCH_MESSAGES){
			numMessage = 0;
		} else {
			numMessage++;
		}
	}
}
