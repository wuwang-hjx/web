<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>账户管理</title>
		<script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery-3.5.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/Management.js"></script>
		<link rel="stylesheet" type="text/css" href="css/Management.css"/>
<link >
</head>
<body>
		<div id="div">
			<div id="sx"></div>
			<div id="bg">
				<table id="tables">
					<tr>
						<th class="sel">
							<input name="checkbox" type="checkbox" value="checkbox" class="chk" id="allsel"/>
						</th>
						<th>用户名</th>
						<th>中文名</th>
						<th>邮箱</th>
						<th>省份</th>
						<th>城市</th>
						<th >操作</th>
					</tr>
					<tr v-for="lis in inputs" id="infos">
						<td class="sel" v-model="selects">
							<input name="checkbox" type="checkbox" value="checkbox" class="chk" id="insel"/>
						</td>
						<td>{{lis.userName}}</td>
						<td>{{lis.charName}}</td>
						<td>{{lis.email}}</td>
						<td>{{lis.sf}}</td>
						<td>{{lis.cs}}</td>
						<td id="del"><a href="#" id="re">编辑</a> <a href="#" id="del">删除</a></td>
					</tr>
				</table>
			</div>
			<div id="zt"></div>
		</div>
	</body>
</html>