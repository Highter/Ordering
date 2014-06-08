<%@page import="bean.Rest_message"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}
body{
	overflow: hidden;
}
#left{
	position: absolute;
	width: 500px;
	height: 620px;
	left: 3%;
}
#restTable tr td{
	padding: 25px;
}
#right{
	position: absolute;
	left: 500px;
}
#msg{
	padding-bottom: 10px;
}
#tableMsg tr td{
	padding: 10px;
	padding-right: 40px;
	padding-left: 20px;
}
#backMsg{
	padding-bottom: 20px;
	border: 1px;
	border-color: gray;
	border-style: solid;
}
#backTable tr td{
	padding: 10px;
	padding-right: 40px;
	padding-left: 40px;
}
</style>
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript">
	function makeSure(){
		var name = '${custom.login_name}';
		if(name!=""){
			$("#backMsg").css("display","block");
		}else{
			$("#backMsg").css("display","none");
		}
	}
</script>
</head>

<body onload="makeSure()">
	<div id="bg" style="position: absolute;width:100%; height:100%">
		<img alt="" src="<%=path%>/pic/bg.jpg" width="100%" height="100%">
	</div>
	<div id="left">
		<table border="1" id="restTable">
			<caption style="font-size: 24px;padding-bottom: 5px;">餐馆信息</caption>
			<tr>
				<td>餐馆名</td>
				<td>${restMessage.rest_Name}</td>
			</tr>
			<tr>
				<td>餐馆地址</td>
				<td>${restMessage.rest_Address}</td>
			</tr>
			<tr>
				<td>餐馆图片</td>
				<td><img width="100" height="100"
					src="/Ordering${restMessage.rest_Photo}" /></td>
			</tr>
			<tr>
				<td>餐馆详情</td>
				<td>${restMessage.remark}</td>
			</tr>
			<tr>
				<td>餐馆电话</td>
				<td>${restMessage.rest_phone}</td>
			</tr>
			<tr>
				<td>餐馆注册时间</td>
				<td>${restMessage.regtime}</td>
			</tr>

		</table>
	</div>


	<%
		List<Rest_message> message = (List<Rest_message>) request
				.getSession().getAttribute("mess");
		if (message != null) {
			request.getSession()
					.setAttribute("messageSize", message.size());
		} else {
			request.getSession().setAttribute("messageSize", 0);
		}
	%>
	<div id="right">
		<div id="msg">
			<table border="1" id="tableMsg">
			<caption style="font-size: 24px;padding-bottom: 5px;">历史评论信息</caption>
				<tr>
					<td>用户id</td>
					<td>评论信息</td>
				</tr>
				<c:forEach var="val" begin="0" end="${messageSize}"
					items="${sessionScope.mess}" step="1">
					<tr>
						<td>${val.custom_ID}</td>
						<td>${val.message}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div id="backMsg">
			<form action="/Ordering/CustomAddMessage" method="get">
				<table id="backTable">
					<caption style="font-size: 24px;padding-bottom: 5px;">我也说说</caption>
					<tr>
						<td colspan="2"><textarea id="area" name="area" style=" width: 230px"></textarea>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="提交" />&nbsp;&nbsp;&nbsp;<input
							type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
