package com.ssafy.sixboard.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

// step06.config에 있는 applicationContext.xml을 대체하려고 한다!
@Configuration
@ComponentScan(basePackages = {"com.ssafy.board", "com.ssafy.util", "com.ssafy.aop.step06.annotation"})
@EnableAspectJAutoProxy
public class Config {
	@Bean	// 별로도 안주면 메서드 이름이 id가 된다!
	public DataSource dataSourse() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8");
		dataSource.setUsername("ssafy");
		dataSource.setPassword("ssafy");
		return dataSource;
	}
}
