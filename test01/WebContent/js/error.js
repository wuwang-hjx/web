$(document).ready(function(){
	var getUrl =window.location.href;  
	 var getData =getUrl.split("=");         
//	 var  tips =decodeURI(getData[1]);	//获取提示信息
	 var  tips =getData[1];	//获取提示信息
	 var count = 9;
	 $("#tips").append(decodeURI(tips));
	 $("#count").append("10");
		setInterval(function(){
			//$("#tips").empty();
			$("#count").empty();
			//$("#tips").append(decodeURI(tips));
			$("#count").append(count);
			//$("p").append("页面将在"+count+"秒后返回");
			if(count==0){
				window.location.href="login.jsp";			
			}
			count--;
		},1000);
});