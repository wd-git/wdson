package wdson.me.board.service;

import java.util.List;

import javax.inject.Inject;

import wdson.me.board.dao.BoardDAO;
import wdson.me.board.domain.BoardVO;

import org.springframework.stereotype.Service;
 
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