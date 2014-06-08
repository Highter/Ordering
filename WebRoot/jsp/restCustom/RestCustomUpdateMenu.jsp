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

<title>My JSP 'RestCustomUpdateMenu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
	function success() {
		alert("修改成功！");

	}
	function toclose() {

	}
</script>
</head>

<body>

	<form action="/Ordering/UpdateMenu" method="get">
		update =<%=request.getSession().getAttribute("update")%>
		<h1>菜单修改</h1>
		<table id="updateTable">
			<tr>
				<td>菜单id：</td>
				<td><input type="text" value="${update.dish_ID }" id="id"
					name="id" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td>菜单名称：</td>
				<td><input type="text" value="${update.dish_Name }" id="name"
					name="name" />
				</td>
			</tr>
			<tr>
				<td>菜单价格：</td>
				<td><input type="text" value="${update.dish_Price }" id="price"
					name="price" />
				</td>
			</tr>
			<tr>
				<td>菜单备注：</td>
				<td><input type="text" value="${update.remark }" id="remark"
					name="remark" />
				</td>
			</tr>

			<tr>
				<td><button onclick="toclose()">关闭此页面</button>
				</td>
				<td><input type="submit" value="提交修改" onclick="success()" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
