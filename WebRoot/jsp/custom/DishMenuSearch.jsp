<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'RestaurantShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	overflow: hidden;
}
#menuShow{
	position:absolute;
	top:2%;
	left: 3%;
}
#menuTable tr td{
	padding: 20px;
}
</style>
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript">
	function makeSure(){
		var name = '${custom.login_name}';
		if(name!=""){
			$("#addCarBtn").css("display","block");
		}else{
			$("#addCarBtn").css("display","none");
		}
	}
</script>
</head>

<body>
	<div id="bg" style="position: absolute;width:100%; height:100%">
		<img alt="" src="<%=path%>/pic/bg.jpg" width="100%" height="100%">
	</div>
	<div id="menuShow">
		<table border="1" id="menuTable">
			<caption style="font-size: 24px;padding-bottom: 5px;">菜单详细信息</caption>
			<tr>
				<td>${menuMessage.dish_ID}</td>
				<td>${menuMessage.dish_Name }</td>
			</tr>
			<tr>
				<td colspan="2"><img width="100" height="100"
					src="/Ordering/${menuMessage.dish_Photo }" /></td>
			</tr>
			<tr>
				<td colspan="2"><textarea readonly="readonly" >${menuMessage.remark }</textarea></td>
			</tr>
			<tr>
				<td>价格:</td>
				<td>${menuMessage.dish_Price }</td>
			</tr>

			<tr id="addCarBtn">
				<td colspan="2">
					<form
						action="/Ordering/CustomAddToShoppingCar?id=${message.dishId }"
						method="post">
						<input type="submit" value="加入购物车" />
					</form>
				</td>
			</tr>

		</table>
	</div>
</body>
</html>
