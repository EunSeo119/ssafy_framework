package com.ssafy.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ssafy"})	// 경로를 여기로 보내는게 좋다!
public class Board6SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Board6SpringbootApplication.class, args);
	}

}
