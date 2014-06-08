<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<script type="text/javascript" src="../../js/jquery.js" charset="utf-8"></script>
<script type="text/javascript" src="../../js/register.js"
	charset="utf-8"></script>
<head>
<base href="<%=basePath%>">

<title>My JSP 'CustomRegister.jsp' starting page</title>

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
	<div id="bg" >
		<img alt="" src="<%=path%>/pic/bg.jpg" width="100%" height="100%">
	</div>
	<div id="login_form">
		<form action="/Ordering/CustomRegisterServet" method="post">
			<table border="1">
				<caption>欢迎来到LYZ用户注册页面</caption>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="login_name" id="login_name" /></td>
					<td id="msg7"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="custom_password"
						id="custom_password" /></td>
					<td id="msg8"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="check_custom_password"
						id="check_custom_password" /></td>
					<td id="msg1"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>真实姓名：</td>
					<td><input type="text" name="custom_Name" id="custom_Name" />
					</td>
					<td id="msg6"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input type="radio" name="custom_sex" id="custom_sex"
						value="1" />男 <input type="radio" name="custom_sex"
						id="custom_sex" value="0" />女</td>
					<td id="msg9"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="custom_Age" id="custom_Age" /></td>
					<td id="msg10"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>身份证号码：</td>
					<td><input type="text" name="custom_ID" id="custom_ID" /></td>
					<td id="msg4"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>送货地址：</td>
					<td><input type="text" name="custom_Address"
						id="custom_Address" /></td>
					<td id="msg11"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input type="text" name="custom_Phone" id="custom_Phone" />
					</td>
					<td id="msg3"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>电子邮件：</td>
					<td><input type="text" name="custom_Email" id="custom_Email" />
					</td>
					<td id="msg2"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td>QQ：</td>
					<td><input type="text" name="custom_QQ" id="custom_QQ" /></td>
					<td id="msg5"><font color='red'>*</font>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="提交" id="submit" name="submit"
						disabled="disabled" /> <input type="reset" value="重置" id="reset"
						name="reset" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
