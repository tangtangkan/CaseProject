## Caching的使用
> @EnableCaching注解是spring framework中的注解驱动的缓存管理功能。自spring版本3.1起加入了该注解。如果你使用了这个注解，那么你就不需要在XML文件中配置cache manager了
> 先进行缓存查询，如果为空则进行方法查询，并将结果缓存，如果缓存中有数据，不进行方法查询，而是直接使用缓存数据

- 在springboot启动类中加入注解@EnableCaching开启缓存
```java
@EnableCaching
public class CaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseApplication.class, args);
    }

}
```

- @Cacheable注解
> 可用作于类或方法上（通常用在数据查询方法上）, 对结果进行缓存存储
```text
value/cacheNames：指定缓存空间的名称，比配属性。可二选一使用。
key：指定缓存中数据的key，默认使用方法参数值，也可使用SPEL表达式。
keyGenerator：指定缓存数据的key的生成器，与key属性二选一使用。
cacheManager：指定缓存的管理器
cacheResolver：指定缓存的解析器，与cacheManager属性二选一使用。
condition：指定在符合某种条件下，进行数据缓存。
unless：指定在符合某种条件下不进行数据缓存。
sync：指定是否使用异步缓存，默认为false。
```

- @CachePut注解
> 作用于类或方法（通常用在数据更新方法上)
> 先进行方法调用，然后将方法结果更新到缓存中

- @CacheEvict注解
> 作用于类或方法（通常用在数据删除方法上)
> 先进行方法调用，然后将缓存进行清除

- @Caching注解
> 作用于类或方法，在@Caching注解内部包含有Cacheable、put和evict三个属性，分别对应于@Cacheable、@CachePut和@CacheEvict三个注解

- @CacheConfig注解
> 使用在类上，主要用于统筹管理类中所有使用@Cacheable、@CachePut…和@CacheEvict 注解标注方法中的公共属性，这些公共属性包括有cacheNames、keyGenerator 、cacheManager和cacheResolver