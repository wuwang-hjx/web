$(document).ready(function(){
	//var sw = false;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	$("#rpass2").blur(function(){
		var rpass = $("#rpass").val();
		var rpass2 = $("#rpass2").val();
		if(!(rpass == rpass2)){			
			$("#tips").empty();
			$("#tips").append("密码不一致");
			$("#tips").css("color","red");
			//var sw = false;
		}else{
			$("#tips").empty();
			//var sw = true;
		}
	});
	//----------------------------------------------------------
	$("#remail").blur(function(){
		var rem = $("#remail").val();
		if(rem.indexOf("@") == -1){			
			$("#tips1").empty();
			$("#tips1").append("邮箱格式不正确");
			$("#tips1").css("color","red");
			//var sw = false;
		}else{
			$("#tips1").empty();
			//var sw = true;
		}
	});
	//----------------------------------------------------------
	$("#rname").blur(function(){
		var rem = $("#rname").val();
		if(rem == ""){			
			$("#tips2").empty();
			$("#tips2").append("真实名不能为空");
			$("#tips2").css("color","red");
			//var sw = false;
		}else{
			$("#tips2").empty();
			//var sw = true;
		}
	});
	//----------------------------------------------------------
	$("#ruser").blur(function(){
		var rem = $("#ruser").val();
		if(rem == ""){			
			$("#tips3").empty();
			$("#tips3").append("用户名不能为空");
			$("#tips3").css("color","red");
			//var sw = false;
		}else{
			$("#tips3").empty();
			//var sw = true;
		}
	});
	//----------------------------------------------------------
	$("#rpass").blur(function(){
		var rem = $("#rpass").val();
		if(rem == ""){			
			$("#tips4").empty();
			$("#tips4").append("密码不能为空");
			$("#tips4").css("color","red");
			//var sw = false;
		}else{
			$("#tips4").empty();
			//var sw = true;
		}
	});
	//----------------------------------------------------------
	$("#submit").click(function(){
		var user = $("#ruser").val();
		var name = $("#rname").val();
		var pass = $("#rpass").val();
		var email = $("#remail").val();
		var sf = $("#sf").val();
		var cs = $("#cs").val();
		
		if(user == ""||name == ""||pass == ""||email == ""){
			
			$("#tips5").empty();
			$("#tips5").append("请检查提交的参数");
			$("#tips5").css("color","red");
		}else{
			$("#tips5").empty();
			$.ajax({				
				url:"createuser",
				type:"post",
				data:{"user":user,"name":name,"pass":pass,"email":email,"sf":sf,"cs":cs},
				success:function(msg){
					if(msg.code=="0"){
						$("#tips5").empty();
						$("#tips5").append(msg.tips);
						$(location).attr("href",msg.path);
					}else if(msg.code=="1"){
						$("#tips5").empty();
						$("#tips5").append(msg.tips);
						$("#tips5").css("color","red");
					}else{
						$("#tips5").empty();
						$("#tips5").append(msg.tips);
						$("#tips5").css("color","red");
					}
				}
			});	
		}
		
		
		
	});
	
	
	
	
	
	//----------------------------------------------------------
});