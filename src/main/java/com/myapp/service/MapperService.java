package com.myapp.service;

import java.util.List;

import com.myapp.dto.MapDto;

public interface MapperService {
	
	public List<MapDto> selectGridList(MapDto mapDto);
	
	public List<MapDto> listMap(MapDto mapDto);

	public List<MapDto> listTeam();

	public int selectPlayerCount(MapDto mapDto);
	
}
