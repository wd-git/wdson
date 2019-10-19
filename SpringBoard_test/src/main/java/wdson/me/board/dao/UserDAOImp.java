package wdson.me.board.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import wdson.me.board.domain.UserVO;

@Repository
public class UserDAOImp implements UserDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "wdson.me.board.mapper.LoginMapper";
	
	@Override
	public UserVO getUserById(String u_id) throws Exception {
		return sqlSession.selectOne(namespace+".getUserById", u_id);
	}

	@Override
	public String getPw(String u_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getPw", u_id);
	}
	
	@Override
	public int insertUser(UserVO vo) throws Exception {
		return sqlSession.insert(namespace+".insertUser", vo);
		
	}
	
}
