package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

@Service("scoreService")
public class ScoreServiceImp implements ScoreService{
	
	@Autowired
	@Qualifier("scoreDAO")
	private ScoreDAO scoreDAO;	
		
	@Override
	public void regist(ScoreVO vo) {
		
		scoreDAO.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
//		ArrayList<ScoreVO> list = scoreDAO.getList();
//		
//		return list; 
		
		//값을 빼와서 처리할게 없다면 아래처럼 바로 선언가능
		return scoreDAO.getList();
	}

	@Override
	public void delete(int num) {
		
		scoreDAO.delete(num);		
	}
	
	
}
