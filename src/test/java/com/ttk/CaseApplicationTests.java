package com.ttk;

import com.ttk.cese.bean.Cat;
import com.ttk.cese.bean.Dog;
import com.ttk.cese.bean.Pig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @SpringBootTest
// 因为springbootTest启动时不会启动服务器，所以websocket就会报错，这个时候需要在注解中添加webEnvironment，给wevsocket提供测试环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CaseApplicationTests {

    @Test
    void test1() {
        System.out.println("哈哈");
    }

    @Test
    void test2() {

        /**
         * 基础5个步骤版本
         *
         * 1.实例化
         * 2.属性赋值
         * 3.初始化
         * 4.使用bean
         * 5.实例销毁
         */

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Dog bean = context.getBean(Dog.class);
        System.out.println("4.使用bean：" + bean.getName());

        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    void test3() {

        /**
         * 7个步骤版本
         *
         * 1.实例化
         * 2.属性赋值
         * 3.初始化前步骤 BeanPostProcessor before方法
         * 4.初始化
         * 5.初始化后步骤 BeanPostProcessor after方法
         * 6.使用bean
         * 7.实例销毁
         *
         * BeanPostProcessor 后置处理器需要重新写一个bean进行配置
         */

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Cat bean = context.getBean(Cat.class);
        System.out.println("6.使用bean：" + bean.getName());

        ((ClassPathXmlApplicationContext)context).close();

    }

    @Test
    void test4() {

        /**
         * 10个步骤版本
         *
         * 首先，基于xml或者注解扫描的方式，找到bean，然后将bean存放到bean定义容器中，就是BeanDefinitionMap，然后可以通过调用createBeanInstance方法实例化对象，在实例化对象之前，可以通过BeanFactoryPostProcessor扩展接口对占位符进行解析替换，比如数据源配置使用的是占位符变量
         * 1.实例化：createBeanInstance，通过反射获取bean对象
         *      反射步骤：
         *          1. 获取Class对象
         *          2. 获取构造器
         *          3. 创建对象
         * 2.属性赋值
         * 3.Aware方法（BeanNameAware、BeanFactoryAware）
         * 4.初始化前步骤 BeanPostProcessor before方法
         * 5.InitialingBean接口的方法
         * 6.初始化
         * 7.初始化后步骤 BeanPostProcessor after方法
         * 8.使用bean
         * 9.DisposableBean接口的方法
         * 10.实例销毁
         *
         * BeanPostProcessor 后置处理器需要重新写一个bean进行配置
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Pig bean = context.getBean(Pig.class);
        System.out.println("8.使用bean：" + bean.getName());

        ((ClassPathXmlApplicationContext)context).close();

    }

}
