package wdson.me.board.dao;

import wdson.me.board.domain.UserVO;

public interface UserDAO {
	public UserVO getUserById(String u_id) throws Exception;
	
	public String getPw(String u_id) throws Exception;
	
	public int insertUser(UserVO vo) throws Exception;
}
