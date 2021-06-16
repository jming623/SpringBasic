package com.simple.service;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreService {

	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getList();
}
