

package wdson.me.board.commons.paging;

import wdson.me.board.commons.exception.CommonExceptionAdvice;
import wdson.me.board.dao.BoardDAO;
import wdson.me.board.domain.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class test {
	@Inject
	private BoardDAO boardDAO;
    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	// junit을 통해 1000개의 더미 입력
	//@Test
	public void testCreate() throws Exception {
		for(int i = 0; i <= 1000; i++) {
			
			BoardVO boardVo = new BoardVO();
			boardVo.setB_detail(i+ "번째 글 내용 입니다.");
			boardVo.setB_title(i+ "번째 글 제목 입니다.");
			boardVo.setB_writer(i+ "user");
			
			boardDAO.create(boardVo);
			
		}
	}
	
	//@Test
	public void testPaging() throws Exception {
		Paging paging = new Paging();
		paging.setPage(3);
		paging.setPerPageNum(20);
		
		List<BoardVO> list = boardDAO.listPaging(paging);
		
		for(BoardVO board : list) {
			logger.info(board.getB_no() + " : "  + board.getB_title());
			
		}
	}
	
	//@Test
	public void testURI() throws Exception {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/Board/read")
				.queryParam("b_no", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info("/Board/read?b_no=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
	
	//@Test
	public void testURI2() throws Exception {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("b_no", 12)
				.queryParam("perPageNum", 20)
				.build()
				.expand("board", "read")
				.encode();
		
		logger.info("/Board/read?b_no=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
	
	//조회수 처리 테스트 
	@Test
	public void testCount() throws Exception {
		for(int i = 0; i < 10; i++)
			boardDAO.read(1004);
		
		BoardVO board = boardDAO.read(1004);
		
		System.out.println("@@@@@ count : " + board.getB_count());
		
	}
	
	
}
