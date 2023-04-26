package com.kh.qrPractice.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.qrPractice.model.vo.QR;

@Repository
public class QRDao {
	
	public QR loginMember(SqlSessionTemplate sqlSession, QR q) {
		return sqlSession.selectOne("memberMapper.loginUser", q);
	}

	
	public int resultAt(SqlSessionTemplate sqlSession, String id) {
		return sqlSession.update("memberMapper.resultAt", id);
	}
	 
}
