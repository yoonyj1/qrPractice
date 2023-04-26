package com.kh.qrPractice.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.qrPractice.model.dao.QRDao;
import com.kh.qrPractice.model.vo.QR;

@Service
public class QRService {
	
	@Autowired
	private QRDao qDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public QR loginMember(QR q) {
		QR qr = qDao.loginMember(sqlSession, q);
		
		return qr;
	}

	
	 public int resultAt(String id) { 
		 return qDao.resultAt(sqlSession, id);
	 }
	 
}
