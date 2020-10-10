$(document).ready(function(){
	$.ajax({
		url:"GetDownloadListController",
		type:"post",
		data:{},
		success:function(msg){
			if(msg != null){
				if( msg.info.status != "0"){
					var data = eval(msg.info);
//				$("#view").append(data);
//				alert(data);
					for(var i = 0; i<data.length; i++){
						var s = data[i];
						$("#view").append("<div class=\"item\"><div class=\"divleft\"><div class=\"name\">"+s.name+"</div><div class=\"image\"><img src=\""+s.image+"\" id=\"fileimg\"/></div><div class=\"text\">"+s.description+"</div><div class=\"tips\">大小:     "+s.size+" 星级:   "+s.star+" </div></div><div class=\"reightdiv\"><div class=\"url\"><a href=\""+s.path+"\"><img src=\"cssimage/下载按钮.png\" id=\"img\"></a></div></div></div>");
						
					}	
				}else{
					$(location).attr("href",msg.info.path);
				}
			}
		}
	});
});