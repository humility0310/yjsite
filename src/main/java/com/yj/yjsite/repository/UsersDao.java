package com.yj.yjsite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yj.yjsite.vo.UsersVo;

@Repository
public class UsersDao {

	@Autowired
	private SqlSession sqlSession;

	public void join(UsersVo vo){
		sqlSession.insert("users.join", vo);
	}
	
	public UsersVo checkId(String id){
		return sqlSession.selectOne("users.checkId", id);
	}
	
	public UsersVo login(UsersVo vo){
		return sqlSession.selectOne("users.login", vo);
	}
	public void modify(UsersVo vo){
		sqlSession.update("users.modify", vo);
	}
	
	//--------------------JSON Test-------------------------
	
	public UsersVo getUsersInfo(String id){
		//System.out.println( sqlSession.selectOne("users.getUserInfo", id).toString());
		return sqlSession.selectOne("users.getUserInfo", id);
	}
	//--------------------JSON List Test---------------------
	public List<UsersVo> getList(){
		return sqlSession.selectList("users.getList");
	}
}
