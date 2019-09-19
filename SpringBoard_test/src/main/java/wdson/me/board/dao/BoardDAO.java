package wdson.me.board.dao;

import java.util.List;

import wdson.me.board.domain.BoardVO;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	public BoardVO read(Integer b_no) throws Exception;

	public void delete(Integer b_no) throws Exception;

	public void update(BoardVO vo) throws Exception;

}
