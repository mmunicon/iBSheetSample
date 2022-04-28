/**
*	공통 js 설정 파일
*/
var common = new Object();

/**
	공통 ibsheet 검색함수
*/
common.DoSearch = function(searchObj){	
	
	var sheetObj = searchObj.sheetName;
	var action = searchObj.action;
	var formId = $("#"+searchObj.formId);
	
	sheetObj.DoSearch(action, formId.serialize() );
};