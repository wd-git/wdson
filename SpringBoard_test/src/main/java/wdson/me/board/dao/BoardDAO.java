package wdson.me.board.dao;

import java.util.List;

import wdson.me.board.commons.paging.Paging;
import wdson.me.board.domain.BoardVO;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;

	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listPaging(Paging paging) throws Exception;

	//count -> paging 사용
	public int countBoards(Paging paging) throws Exception;
	
	public BoardVO read(Integer b_no) throws Exception;

	public void delete(Integer b_no) throws Exception;

	public void update(BoardVO vo) throws Exception;
	
	
	
	

}
