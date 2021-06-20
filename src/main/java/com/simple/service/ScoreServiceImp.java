package com.simple.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;
import com.simple.mapper.ScoreMapper;

@Service("scoreService")
public class ScoreServiceImp implements ScoreService{
	
//	@Autowired
//	@Qualifier("scoreDAO")
//	private ScoreDAO scoreDAO;	
	
	//앞으론 DAO대신 Mybatis를 사용
	@Autowired
	private ScoreMapper scoreMapper;
		
	@Override
	public void regist(ScoreVO vo) {
		
//		scoreDAO.regist(vo);
		
		//1st
		scoreMapper.regist(vo);
		
		//2nd - map형식으로
//		HashMap<String,String> map = new HashMap<>();
//		map.put("name", vo.getName());
//		map.put("kor",vo.getKor());
//		map.put("eng",vo.getEng());
//		
//		scoreMapper.regist(map); 이렇게 사용하려면 scoreMapper 인터페이스에서 매개변수 타입을 Hashmap으로 전달받게 수정해준다.
//		xml파일에서는 #{키값} 으로 값을 전달받습니다. 
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
//		ArrayList<ScoreVO> list = scoreDAO.getList();
//		
//		return list; 
		
		//값을 빼와서 처리할게 없다면 아래처럼 바로 선언가능
//		return scoreDAO.getList();
		return scoreMapper.getList();
	}

	@Override
	public void delete(int num) {
		
//		scoreDAO.delete(num);
		scoreMapper.delete(num);
	}
	
	
}
