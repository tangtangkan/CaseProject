package com.ttk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

// 开启异步配置
@EnableAsync
// 开启事务支持，开启之后在Service方法上添加注解@Transactional便可
@EnableTransactionManagement
@SpringBootApplication
// 这样就不用在每个dao加入@Mapper注释了
@MapperScan("com.ttk.dao")
// 使用此注解, swagger地址打不开
// @EnableWebMvc
public class CaseApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        /**
         * 可配置的Application容器
         * 查看类图：ctrl + alt + u
         */
        ConfigurableApplicationContext context = SpringApplication.run(CaseApplication.class, args);

        /**
         * 获取所有单例bean
         */
        // 获取私有成员变量singletonObjects
        // Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        // // true：屏蔽java语言的访问检查，使对象的私有属性也可以被查询和设置
        // singletonObjects.setAccessible(true);
        // ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // // key：bean的名字, value：对象的示例
        // Map<String, Object> map = (Map<String, Object>)singletonObjects.get(beanFactory);
        // map.forEach((k, v) -> {
        //     System.out.println(k + " = " + v);
        // });

        /**
         * 国际化（MessageSource）
         */
        // System.out.println(context.getMessage("hi", null, Locale.CHINA));
        // System.out.println(context.getMessage("hi", null, Locale.JAPANESE));
        // System.out.println(context.getMessage("hi", null, Locale.ENGLISH));

        /**
         * 获取资源（ResourcePatternResolver）
         * classpath：类路径（不可以在jar包中查找）
         * file：磁盘路径
         * classpath*：可以在jar包中查找
         */
        // 查找项目中application.properties配置文件
        // context.getResources("classpath:application.properties");
        // // 查找项目和引入的包中META-INF目录下spring.factories配置文件
        // Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
        // for (Resource resource : resources) {
        //     System.out.println(resource);
        // }

        /**
         * 获取环境信息（EnvironmentCapable）
         */
        // 获取环境变量
        // System.out.println(context.getEnvironment().getProperty("java_home"));
        // // 获取项目端口
        // System.out.println(context.getEnvironment().getProperty("server.port"));

        /**
         * 发布事件（ApplicationEventPublisher）
         * 发布UserRegisteredEvent事件，Component1监听事件
         */
        // String text = "短信内容";
        // context.publishEvent(new UserRegisteredEvent(text));

        /**
         * 调用Component2类send方法，在Component2中发布UserLogOutEvent事件，Component3监听事件
         */
        // context.getBean(Component2.class).send();

    }

}
