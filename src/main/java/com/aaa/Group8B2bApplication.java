package com.aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@EnableTransactionManagement//spring boot 开启注解式事务
@SpringBootApplication
@ServletComponentScan//该注解的作用:让Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册
@MapperScan("com.aaa.group8.dao")
public class Group8B2bApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group8B2bApplication.class, args);
	}

}
