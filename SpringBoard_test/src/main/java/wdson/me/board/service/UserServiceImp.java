package wdson.me.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import wdson.me.board.dao.UserDAO;
import wdson.me.board.domain.UserVO;

@Service
public class UserServiceImp implements UserService{

	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO getUserById(String u_id) throws Exception {
		
		return dao.getUserById(u_id);
	}

	@Override
	public String getPw(String u_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.getPw(u_id);
	}

	@Override
	public int insertUser(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertUser(vo);
	}

	

	
}
