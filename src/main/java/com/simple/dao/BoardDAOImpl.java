package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.BoardVO;

@Repository("BoardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	//DB역할
	ArrayList<BoardVO> list = new ArrayList<>();
	
	@Override
	public void boardRegist(BoardVO vo) {
		
		System.out.println("넘어온 값:"+vo.toString());
		
		list.add(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		
		return list;
	}

	@Override
	public void boardDelete(int num) {
		
		System.out.println(num+"번째 인덱스 삭제 완료");
		list.remove(num);
		
	}

}
