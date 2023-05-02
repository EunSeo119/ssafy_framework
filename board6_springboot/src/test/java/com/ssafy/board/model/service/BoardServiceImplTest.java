package com.ssafy.board.model.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.BoardDto;

@SpringBootTest(
	properties = {
		"articleno=1",
		"subject=spring test ing.....",
		"content=스프링 테스트중!!!!",
		"userid=ssafy"
	}
)
@Transactional	// 테스트 성공하게 되어도 알아서 rollback!!(테스트 이니까 실제 db에 적용되지 않도록!)
class BoardServiceImplTest {

	private Logger log = LoggerFactory.getLogger(BoardServiceImplTest.class);
	
	@Value("${articleno}")
	private String articleNo;

	@Value("${subject}")
	private String subject;
	
	@Value("${content}")
	private String content;
	
	@Value("${userid}")
	private String userId;
	
	@Autowired
	private BoardService boardService;
	
//	@Test
	@DisplayName("게시판 글작성 테스트")
	void testWriteArticle() {
		BoardDto boardDto = new BoardDto();
		boardDto.setSubject(subject);
		boardDto.setContent(content);
		boardDto.setUserId(userId);
		try {
			boardService.writeArticle(boardDto);
		} catch (Exception e) {
			fail("게시글 작성 실패!!!!");			
		}
	}

//	@Test
//	void testListArticle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetArticle() {
//		fail("Not yet implemented");
//	}
//
	@Test
	@DisplayName("게시판 글수정 테스트")
	void testModifyArticle() {
		BoardDto boardDto = new BoardDto();
		boardDto.setArticleNo(2);
		boardDto.setSubject(subject);
		boardDto.setContent(content);
		try {
			boardService.modifyArticle(boardDto);
		} catch (Exception e) {
			fail("게시글 수정 실패!!!!");			
		}
	}
//
//	@Test
//	void testDeleteArticle() {
//		fail("Not yet implemented");
//	}

}
