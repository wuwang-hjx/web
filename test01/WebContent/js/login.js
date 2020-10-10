$(document).ready(function(){
	//单击图片验证码刷新----------------------------------
	$("#img").click(function(){
		var timestamp = new Date().getTime();
		$("#img").attr("src","CreateVerifyImageController?"+timestamp);
	});
	//---------------------------------------------------
	//点击登录事件---------------------------------------
	$("#submit").click(function(){
		var name = $("#username").val();
		var pass = $("#password").val();
		var auth = $("#yzm").val();
		$.ajax({
			url:"LoginController",
			type:"post",
			data:{"name":name,"pass":pass,"auth":auth,"sw":"login"},
			success:function(msg){
				if(msg!=null){
					var input = msg.input;
					if(input.authstatus=="0"){
						$(location).attr("href",input.pagepath+"?tips="+input.tips);
					}else{
						$(location).attr("href",input.pagepath);
					}
					
				}else{
					$("body").append("<h1>服务器未响应！</h1>");
					var timestamp = new Date().getTime();
					$("#img").attr("src","CreateVerifyImageController?"+timestamp);
				}
			}
		});
	});
	
	//---------------------------------------------------
});