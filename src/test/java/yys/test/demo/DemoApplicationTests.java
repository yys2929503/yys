package yys.test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import yys.test.demo.model.UserDO;

@SpringBootTest
class DemoApplicationTests {

	//redis操作对象
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	void setRedisKey() {
		redisTemplate.opsForValue().set("name","ibekjg");
		stringRedisTemplate.opsForValue().set("name","123456");
	}
	@Test
	void getRedisKey(){
		System.out.println(redisTemplate.opsForValue().get("name"));
		System.out.println(stringRedisTemplate.opsForValue().get("name"));
	}
	@Test
	void setUserDO(){
		UserDO userDO = new UserDO();
		userDO.setId(123456);
		userDO.setAge("M");
		userDO.setUsername("zhangsan");
		redisTemplate.opsForValue().set("userDO",userDO);


	}
}
