package feb.training.springboot.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import feb.training.springboot.dto.UserSessionDTO;
import feb.training.springboot.entities.User;

import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfig {

	/*
	 * @Bean public RedisTemplate<String, Object>
	 * redisTemplate(RedisConnectionFactory factory) {
	 * 
	 * RedisTemplate<String, Object> template = new RedisTemplate<>();
	 * template.setConnectionFactory(factory);
	 * 
	 * // ✅ KEY serializer template.setKeySerializer(new StringRedisSerializer());
	 * 
	 * // ✅ VALUE serializer (CRITICAL) template.setValueSerializer(new
	 * GenericJackson2JsonRedisSerializer());
	 * 
	 * // ✅ HASH serializers (important for stability)
	 * template.setHashKeySerializer(new StringRedisSerializer());
	 * template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
	 * 
	 * template.afterPropertiesSet(); // 🔥 IMPORTANT
	 * 
	 * return template; }
	 */
	
	
	/*
	 * @Bean public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory
	 * factory) {
	 * 
	 * RedisTemplate<String, User> template = new RedisTemplate<>();
	 * template.setConnectionFactory(factory);
	 * 
	 * template.setKeySerializer(new StringRedisSerializer());
	 * 
	 * Jackson2JsonRedisSerializer<User> serializer = new
	 * Jackson2JsonRedisSerializer<>(User.class);
	 * 
	 * template.setValueSerializer(serializer);
	 * 
	 * template.afterPropertiesSet();
	 * 
	 * return template; }
	 */
	
	
	
	@Bean
	public RedisTemplate<String, UserSessionDTO> redisTemplate(RedisConnectionFactory factory) {

	    RedisTemplate<String, UserSessionDTO> template = new RedisTemplate<>();
	    template.setConnectionFactory(factory);

	    template.setKeySerializer(new StringRedisSerializer());

	    Jackson2JsonRedisSerializer<UserSessionDTO> serializer =
	            new Jackson2JsonRedisSerializer<>(UserSessionDTO.class);

	    template.setValueSerializer(serializer);

	    template.afterPropertiesSet();

	    return template;
	}
}