package com.ssafy.first.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.first.javaconfig.controller.BoardController;

public class Test {
	public static void main(String[] args) {
		// BeanFactory(Interface) <= ApplicationContext(Interface)
		// 
		ApplicationContext container = new AnnotationConfigApplicationContext(
				Config.class
		);
		String[] names = container.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
		
		
		BoardController controller = (BoardController) container.getBean("boardController");
		
		// toString 확인하자...
		System.out.println(controller);
		
		/*
		BoardService boardService = container.getBean("boardService", BoardService.class);
		
		// toString 확인하자...
		System.out.println(boardService);
		
		BoardDao boardDao = container.getBean(BoardDao.class);	// BoardDao 가 하나밖에 안되서 이 형식도 가능!
		
		System.out.println("정상적으로 실행되었음..");
		*/
	}
}
