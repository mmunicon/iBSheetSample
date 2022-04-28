package com.myapp.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.common.util.CommonUtil;
import com.myapp.dto.MapDto;
import com.myapp.service.MapperService;

@Controller
public class MapController extends CommonUtil{

	@Resource
	private MapperService mapper;
	
	@RequestMapping("listmap")
	public String listmap(Model model, @ModelAttribute("mapDto") MapDto mapDto) {
				
		model.addAttribute("listTeam", mapper.listTeam());
		model.addAttribute("list", mapper.listMap(mapDto));
		
		return "listmap";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping("gridList.do")
	public String egovGridList(@ModelAttribute("mapDto") MapDto mapDto, ModelMap model) throws Exception {
		/** EgovPropertyService.sample */
		
		//List<?> testList = map.selectTestList(testVO);
		//model.addAttribute("resultList", testList);
		model.addAttribute("mapDto", mapDto);
		return "list/gridList";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping("ibsheetList.do")
	public String ibsheetList(@ModelAttribute("mapDto") MapDto mapDto, ModelMap model) throws Exception {
		/** EgovPropertyService.sample */
		
		//List<?> testList = map.selectTestList(testVO);
		//model.addAttribute("resultList", testList);
		return "list/gridList3";
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value="selectGridList.do", method = {RequestMethod.GET, RequestMethod.POST})	
	@ResponseBody
	public String selectGridList(@ModelAttribute("mapDto") MapDto mapDto, ModelMap model) throws Exception {
		String rtnJson = "";		
		System.out.println(mapDto.getPlayerId());
		/** pageing setting */
		int count = mapper.selectPlayerCount(mapDto);
		int totalPage = count%mapDto.getRows()==0?count/mapDto.getRows():count/mapDto.getRows()+1;
		
		List<?> testList = mapper.selectGridList(mapDto);
		
		HashMap<String, Object> hashMap = new HashMap();
		hashMap.put("rows", testList); // Grid data
		hashMap.put("page", mapDto.getPage()); // Current page
		hashMap.put("records", count);  // Total count
		hashMap.put("total", totalPage); // Total page
		
		ObjectMapper objectMapper = new ObjectMapper();
		rtnJson = objectMapper.writeValueAsString(hashMap); 
		return rtnJson;
	}
	
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value="selectGridList1.do", method = {RequestMethod.GET, RequestMethod.POST})	
	@ResponseBody
	public String selectGridList1(@ModelAttribute("mapDto") MapDto mapDto, ModelMap model) throws Exception {
		String rtnJson = "";		
		
		/** pageing setting */
		int count = mapper.selectPlayerCount(mapDto);
		//int totalPage = count%mapDto.getRows()==0?count/mapDto.getRows():count/mapDto.getRows()+1;
		
		List<?> testList = mapper.listMap(mapDto);
		
		HashMap<String, Object> hashMap = new HashMap();
		hashMap.put("rows", testList); // Grid data
		hashMap.put("page", mapDto.getPage()); // Current page
		hashMap.put("records", count);  // Total count
		//hashMap.put("total", totalPage); // Total page
		
		ObjectMapper objectMapper = new ObjectMapper();
		rtnJson = objectMapper.writeValueAsString(hashMap); 
		return rtnJson;
	}
	
	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "selectGridList3"
	 * @exception Exception
	 */
	@RequestMapping(value="selectGridList3.do", method = {RequestMethod.GET, RequestMethod.POST})	
	@ResponseBody
	public String selectGridList3(@ModelAttribute("mapDto") MapDto mapDto, ModelMap model) throws Exception {
		
		String rtnJson = "";		
		
		/** pageing setting */
		int count = mapper.selectPlayerCount(mapDto);
		//int totalPage = count%mapDto.getRows()==0?count/mapDto.getRows():count/mapDto.getRows()+1;
		
		List<?> testList = mapper.selectGridList(mapDto);
		return resultListToJson(testList);
	}
}