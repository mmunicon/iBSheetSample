package com.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.dto.MapDto;

@Repository
public class MapperDao {
	
	@Autowired
	SqlSession sqlSession;

	public List<MapDto> selectGridList(MapDto mapDto) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("map.selectGridList", mapDto);
	}
	
	public List<MapDto> listMap(MapDto mapDto){
		return sqlSession.selectList("map.listMap", mapDto);
	}

	public List<MapDto> listTeam(){
		return sqlSession.selectList("map.listTeam");
	}

	public int selectPlayerCount(MapDto mapDto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("map.selectPlayerCount", mapDto);
	}
}
