package wdson.me.board.service;

import java.util.List;

import wdson.me.board.domain.UserVO;

public interface UserService {
	public UserVO getUserById(String u_id) throws Exception;
	public String getPw(String u_id) throws Exception;
	public int insertUser(UserVO vo) throws Exception;
}
