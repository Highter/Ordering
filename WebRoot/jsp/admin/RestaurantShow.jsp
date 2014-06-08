<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div id="restaurant_Show">
		<table border="1" id = "rest">
			<caption>查看所有餐馆信息</caption>
			<tr>
				<td>餐馆id：</td>
				<td>主营菜系：</td>
				<td>餐馆名字 ：</td>
				<td>餐馆老板：</td>
				<td>订餐电话：</td>
				<td>餐馆地址：</td>
				<td>餐馆图片：</td>
				<td>餐馆的介绍：</td>
				<td>注册时间：</td>
				<td>更新时间：</td>
				<td>版本号：</td>
				<td>状态：</td>
			</tr>	
		</table>
	</div>
<!-- 	<form action="/Ordering/AdminGetAllRestaurantMessage" method="post">
	<input type = "text" value="test" name ="test"/>
		<input type="submit" value="submit" id="submit" name="submit" />
		<input type="reset" value="reset" id="reset" name="reset" />
	</form> -->
	
	
	
</body>
</html>
