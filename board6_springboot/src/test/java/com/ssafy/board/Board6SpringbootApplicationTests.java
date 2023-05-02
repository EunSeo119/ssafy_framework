package com.ssafy.board;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(
//	properties = {
//		"userid=ssafy",
//		"userpwd=1234"
//	}
//)
@SpringBootTest(
	properties = { 
		"spring.config.location=classpath:application.properties" 
	}
)
//@slf4j
class Board6SpringbootApplicationTests {

	private Logger log = LoggerFactory.getLogger(Board6SpringbootApplicationTests.class);

	@Value("${userid}")
	private String userId;

	@Value("${userpwd}")
	private String userPwd;

	@Test
	void contextLoads() {
		log.debug("####### property test #######");
		log.debug("userid : {}", userId);
		log.debug("userpwd : {}", userPwd);
	}

}
