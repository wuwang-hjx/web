 var dataid = -1;
 // 格式配置
        var settingss = {
            edit: {
                enable: true,
                drag: {
                    isMove: true,
                    prev: true,
                    autoOpenTime: 0
                },
                editNameSelectAll: true,
                showRemoveBtn: true,
                removeTitle: "删除节点",
                // renameTitle: "编辑节点名称",
                showRenameBtn: false,
            },
            view: {
                selectedMulti: true,
                showIcon: true,
                showLine: true
            },
            data: {
                simpleData: {
                    enable: true, //true 、 false 分别表示 使用 、 不使用 简单数据模式
                    idKey: "id", //节点数据中保存唯一标识的属性名称
                    pIdKey: "pId", //节点数据中保存其父节点唯一标识的属性名称  
                    rootPId: -1 //用于修正根节点父节点数据，即 pIdKey 指定的属性值
                },
                key: {
                    name: "name" //zTree 节点数据保存节点名称的属性名称  默认值："name"
                }
            },
            check: {
                enable: false, //true 、 false 分别表示 显示 、不显示 复选框或单选框
                nocheckInherit: true //当父节点设置 nocheck = true 时，设置子节点是否自动继承 nocheck = true 
            },
            callback: {
                onClick: onClick,
                onRemove : zTreeOnRemove
                
            }
        };
        // 数据
        //var xnode = [];
        // 初始化 
        // zTreeObj = $.fn.zTree.init($("#treeDemo"), settingss, zNodes); //初始化树
        // zTreeObj.expandAll(true); //true 节点全部展开、false所有节点收缩
        // 初始化节点
        $(document).ready(function() {
            $.ajax({
                type: "get",
                url:"controller",
                dataType: "json",
                success: function(response) {
           	 		if(response!=null){
           	 		$.fn.zTree.init($("#treeDemo"), settingss,response);
					}else{
						$("p").empty();
						$("p").append("NULL");
					}
                }
            });
            $("#save").click(function(){
            	var name = $("#nowname").val();
            	var id = dataid;
            	$.ajax({
            		url:"updataztree",
            		type:"post",
            		data:{
            			"name":name,
            			"id":id
            		},
            		dataType:"json",
            		success:function(response){
            			if(response!=null){
           	 				location.reload();
						}else{
							alert("修改失败");
						}
            		}
            	
            	});
            	
            });
        });

        function onClick(e, treeId, treeNode) {
            // if (treeNode.isParent) //判断是否是父节点
            // alert(treeNode.getParentNode().name);
            document.getElementById('topname').value = treeNode.getParentNode().name;
            // else {
             //alert(treeNode.name); //获取当前结点上的名称属性数据
             //alert(treeNode.id);
             dataid = treeNode.id;
            document.getElementById('nowname').value = treeNode.name;
            // }
       
            
        };
        
        function zTreeOnRemove(event, treeId, treeNode) {
		    $.ajax({
		        url:"deleteinfo",
		        type: "post",
		        data:{
		        	"id":treeNode.id
		        },
		        success : function(data) {
		        	if(data!=null){
		            	location.reload();
		            }else{
		            	alert("删除失败");
		         	}
		        }
		    });
		   }