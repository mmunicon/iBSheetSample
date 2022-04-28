<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>
 
<%
  /**
  * @Class Name : egovSamplegrid.jsp
  * @Description : Sample grid 화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2009.02.01            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.02.01
  *
  * Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>테스트</title>    
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>     	
   	<link rel="stylesheet" type="text/css" href="<c:url value='/jqGrid/css/jquery-ui.css'/>" /> 
   	<link rel="stylesheet" type="text/css" href="<c:url value='/jqGrid/css/trirand/ui.jqgrid.css'/>" />    	
   	<script type="text/javascript" src="<c:url value='/jqGrid/js/jquery-1.12.4.js'/>"></script>   	
   	<script type="text/javascript" src="<c:url value='/jqGrid/js/trirand/i18n/grid.locale-kr.js'/>"></script>
   	<script type="text/javascript" src="<c:url value='/jqGrid/js/trirand/src/jquery.jqGrid.js'/>"></script>    	
   	
    <script type="text/javaScript" language="javascript">		    
		$(document).ready(function () {
			initGrid();
			//test();
		});
		function test(){
			$( "#gridForm" ).submit();
		}	
		
		function initGrid(){
			
			$("#jqGrid").jqGrid({
			    url: 'selectGridList.do',
			    mtype: "POST",
			    datatype: "json",
			    contentType: "application/text",
			    width : 1000,
			    height: 500,
			    colNames : [ '구단', '성명', '포지션','등번호'],
			    colModel: [
		            {name:'regionName'},
		            {name:'playerName'},
		            {name:'position'},
		            {name:'backNo'}
		        ],
		        loadonce: false,
		        rownumbers: true,
		        gridview: true,
		        shrinkToFit: false,
		        forceFit: true,
		        viewrecords: true,
		        frozen: true,
		        multiselect: true,
		        cellEdit: true,
		        rowNum: 60,
		        rowList: [60, 100],
		        pager: '#pager',
		        caption: '선수',
		        emptyrecords : "데이터가 없습니다." ,// 레코드가 없을때 보여줄 문구
		        loadonce : false, // true를 하면은 페이징은 되지만 수정을했을때 리로드가 안됨 아니 그냥 리로드가 안됨 
		        ondblClickRow: function(rowid){
		        	// 그리드 더블클릭시 실행하는 함수
		        	//$("#jqGrid").getCell(rowid, 'playerName') GetCellValue 함수
		        	alert($("#jqGrid").getCell(rowid, 'playerName'));
		        },
		        loadComplete : function() {
		        	// 그리드로드 완료 후 실행될 함수 
	            }
	        });			
		}
    </script>
</head>

<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
    <form:form modelAttribute="mapDto" id="gridForm" name="gridForm" method="post" action="selectGridList1.do">
       <form:input path="playerId" id="playerId" value="111" />
    </form:form>
    <div class="row">
		<div>
			<table id="jqGrid"></table>
			<div id="pager"></div>
		</div>
	</div>
</body>
</html>
