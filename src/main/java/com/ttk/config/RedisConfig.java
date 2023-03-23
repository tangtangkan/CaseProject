// package com.ttk.config;
//
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
// import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
// import org.springframework.data.redis.core.RedisTemplate;
//
// @Configuration
// public class RedisConfig {
//
//     @Value("${spring.redis.host}")
//     private String redisHost;
//
//     @Value("${spring.redis.port}")
//     private int redisPort;
//
//     @Value("${spring.redis.password}")
//     private String redisPassword;
//
//     @Bean
//     public JedisConnectionFactory jedisConnectionFactory() {
//         RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
//         configuration.setPassword(redisPassword);
//         return new JedisConnectionFactory(configuration);
//     }
//
//     @Bean
//     public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//         RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//         redisTemplate.setConnectionFactory(connectionFactory);
//         return redisTemplate;
//     }
//
// }
