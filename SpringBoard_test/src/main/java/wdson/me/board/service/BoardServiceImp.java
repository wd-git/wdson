package wdson.me.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import wdson.me.board.commons.paging.Paging;
import wdson.me.board.dao.BoardDAO;
import wdson.me.board.domain.BoardVO;
 
@Service
public class BoardServiceImp implements BoardService {
 
    @Inject
    private BoardDAO dao;
    
    
    @Override
    public void create(BoardVO vo) throws Exception {
        dao.create(vo);
    }
 
    @Override
    public List<BoardVO> listAll() throws Exception {
        return dao.listAll();
    }
    
    @Override
    public List<BoardVO> listPaging(Paging paging) throws Exception {
    	return dao.listPaging(paging);
    }
    
    @Override
    public int countBoards(Paging paging) throws Exception {
    	return dao.countBoards(paging);
    }
 
    @Override
    public BoardVO read(Integer b_no) throws Exception {
        return dao.read(b_no);
    }
 
    @Override
    public void delete(Integer b_no) throws Exception {
        dao.delete(b_no);
 
    }
 
    @Override
    public void update(BoardVO vo) throws Exception {
        dao.update(vo);
    }
 
}