package com.simple.test.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper //생략가능 
public interface TESTMapper {

	public String getTEST(); //해당 메서드명은 xml파일에서 사용
}
