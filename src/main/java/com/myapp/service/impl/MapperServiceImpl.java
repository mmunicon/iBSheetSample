package com.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.dao.MapperDao;
import com.myapp.dto.MapDto;
import com.myapp.service.MapperService;

@Service
public class MapperServiceImpl implements MapperService {
	
	@Autowired
	MapperDao mapperDao;

	@Override
	public List<MapDto> selectGridList(MapDto mapDto) {
		// TODO Auto-generated method stub
		return mapperDao.selectGridList(mapDto);
	}	
	
	@Override
	public List<MapDto> listMap(MapDto mapDto) {
		// TODO Auto-generated method stub
		return mapperDao.listMap(mapDto);
	}

	@Override
	public List<MapDto> listTeam() {
		// TODO Auto-generated method stub
		return mapperDao.listTeam();
	}

	@Override
	public int selectPlayerCount(MapDto mapDto) {
		// TODO Auto-generated method stub
		return mapperDao.selectPlayerCount(mapDto);
	}
}
