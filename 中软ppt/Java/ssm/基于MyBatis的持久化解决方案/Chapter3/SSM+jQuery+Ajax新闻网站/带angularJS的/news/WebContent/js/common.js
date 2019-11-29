function GetQueryString(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	//window.location.search 取得的是?name=123
	var r = window.location.search.substr(1).match(reg);
	if(r!=null){
		return  unescape(r[2]); 
	}
	return null;
}