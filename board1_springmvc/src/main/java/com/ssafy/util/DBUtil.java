package com.ssafy.util;

import org.springframework.stereotype.Component;

//service, repository, controller 아니면 Component!
@Component
public class DBUtil {
	
	// db연결 스프링이 하니까 원래꺼 필요 없음
	
	public void close(AutoCloseable... autoCloseables) {
		for(AutoCloseable ac : autoCloseables) {
			if(ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
