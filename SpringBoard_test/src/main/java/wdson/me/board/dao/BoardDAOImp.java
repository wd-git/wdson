package wdson.me.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import wdson.me.board.commons.paging.Paging;
import wdson.me.board.domain.BoardVO;

@Repository
public class BoardDAOImp implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "wdson.me.board.mapper.BoardMapper";
	
	// 게시판 추가
	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertBoard", vo);
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(namespace+".listBoard");
	}

	//페이징 처리
	@Override
	public List<BoardVO> listPaging(Paging paging) throws Exception {
		
		return sqlSession.selectList(namespace+".listPaging", paging);
	}
	
	@Override
	public int countBoards(Paging paging) throws Exception {
		
		return sqlSession.selectOne(namespace+".countBoards", paging);
	}
	
	@Override
	public BoardVO read(Integer b_no) throws Exception {
		// TODO Auto-generated method stub
		
		// 조회수 처리
		sqlSession.update(namespace+".countUp", b_no);
		
		return sqlSession.selectOne(namespace+".detailBoard", b_no);
		
		
	}

	@Override
	public void delete(Integer b_no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".deleteBoard", b_no);
		
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".updateBoard", vo); 
	}

}
