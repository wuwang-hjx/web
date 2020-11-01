$(document).ready(function(){
	var myData={
		inputs:[],
		selects:""
	}
	new Vue({
		el:"#infos",
		data:myData,
		created(){
			this.getinfo();
		},
		methods:{
			getinfo(){
				var _self = this;
				$.ajax({
					url:"getinfo",
					type:"post",
					dataType:"json",
					success:function(msg){
						_self.inputs=msg;
					}
				});
			},
			delli(){
				//------------------------
			},
			addli(){
				//------------------------
			},
			updatali(){
				//------------------------
			}
		}
		
	})
	
	
});