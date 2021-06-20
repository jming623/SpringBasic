package com.simple.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.command.BoardVO;

@Mapper
public interface BoardMapper {
	
	public void boardRegist(BoardVO vo); //board 등록 메서드
	public ArrayList<BoardVO> getList(); //모든 게시물 가져오기
	public void boardDelete(int num); //게시글 삭제 메서드
}
