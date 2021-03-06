<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
<jsp:include page="/include/incHeader.jsp" />
<title>테스트</title>
<script type="text/javaScript" language="javascript">	
	function LoadPage() {
		createIBSheet2( document.getElementById("sheetObj"), "ibSheet", "1250px", "400px");
		var initdata = {};
		//SetConfig
		initdata.Cfg = {SearchMode:smLazyLoad,Page:50,MergeSheet:msHeaderOnly};
		//InitHeaders의 두번째 인자
		initdata.HeaderMode = {Sort:1,ColMove:1,ColResize:1,HeaderCheck:0};
		//InitColumns + Header Title
		initdata.Cols = [
			{Header:"상태", Type:"Status",Width:50,SaveName:"sStatus",Align:"Center"},
		 	{Header:"삭제", Type:"DelCheck",Width:50,SaveName:"sDelete",Align:"Center"},
		 	{Header:"구단", Type:"Text",Width:200,SaveName:"regionName",Align:"Center"},
		 	{Header:"선수", Type:"Text",Width:200,SaveName:"playerName",Align:"Center"},
		 	{Header:"포지션", Type:"Text",Width:200,SaveName:"position",Align:"Center"},
			{Header:"등번호", Type:"Text",Width:100,SaveName:"backNo",Align:"Center"}
		];
		
		//초기화
		IBS_InitSheet(ibSheet, initdata);
		
		goSearch();		
		
	}
	
	function goSearch(){
		var searchObj = {
			sheetName : ibSheet,
			formId : "gridForm",
			action : "selectGridList3.do"
		}
		common.DoSearch(searchObj);
	}
	
	function goDownExcel(){
		ibSheet.Down2Excel({FileName:"선수정보.xls",SheetName:"선수정보",Merge:1,SheetDesign:1 });
	}
	
</script>
</head>
<body style="width: 100%;">
	<form:form modelAttribute="mapDto" id="gridForm" name="gridForm" method="post">
       <form:hidden path="page" id="page" value="2" />
       <form:hidden path="rows" id="rows" value="50" />
    </form:form>
	<input type="button" value="엑셀다운" onclick="goDownExcel();"/>
	<div id="sheetObj"></div>	
</body>
</html>
