<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'RestaurantCustomShow.jsp' starting page</title>
    
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
    <div>
		<table border="1" id = "test">
			<caption>餐馆用户列表</caption>
			<tr>
				<td>ID</td>
				<td>用户名：</td>
				<td>密码：</td>
				<td>真实姓名：</td>
				<td>性别:</td>
				<td>年龄：</td>
				<td>身份证号码：</td>
				<td>送货地址：</td>
				<td>联系电话：</td>
				<td>电子邮件：</td>
				<td>QQ：</td>
				<td>操作1</td>
				<td>操作2</td>
				<td>操作3</td>
			</tr>
		</table>
	</div>
  </body>
</html>
