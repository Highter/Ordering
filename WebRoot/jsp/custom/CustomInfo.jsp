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

<title>My JSP 'AdminWelcome.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/CustomInfo.css">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/CustomInfo.js"></script>
<script type="text/javascript">




function updateMessage()
{
	alert("修改成功!");
}


function menu(){
	$.ajax({
        url:"/Ordering/MenuManageServlet",
        type:"get",
        dataType:"json",
        success:function(jsons){
         $("#menu").empty();
            $("#menu").append("<caption>订单管理</caption>");
            $("#menu").append("<tr id = 'list'></tr>")	;
			$("#list").append("<td>总价</td>");				
			$("#list").append("<td>餐馆ID</td>");	
			$("#list").append("<td>送货地址</td>");	
			$("#list").append("<td>联系电话</td>");	
			$("#list").append("<td>下单时间</td>");	
			$("#list").append("<td>订单状况</td>");	
			$("#list").append("<td>注册时间</td>");	
			$("#list").append("<td>更新时间</td>");	
			$("#list").append("<td>版本号</td>");	
			$("#list").append("<td>取消订单</td>");	
         for(var i=0;i<jsons.length;i++)
         {
         	$("#menu").append("<tr id ='"+jsons[i].order_ID+"'></tr>");    
	        $("#"+jsons[i].order_ID).append("<td>"+jsons[i].sum_Price+"</td>");
	        $("#"+jsons[i].order_ID).append("<td>"+jsons[i].restaurant_ID+"</td>");
	         $("#"+jsons[i].order_ID).append("<td>"+jsons[i].address+"</td>");
	           $("#"+jsons[i].order_ID).append("<td>"+jsons[i].phone+"</td>");
	            $("#"+jsons[i].order_ID).append("<td>"+jsons[i].order_Time+"</td>");
	             $("#"+jsons[i].order_ID).append("<td>"+jsons[i].order_Condition+"</td>");
	              $("#"+jsons[i].order_ID).append("<td>"+jsons[i].regtime+"</td>");
	               $("#"+jsons[i].order_ID).append("<td>"+jsons[i].modifedtime+"</td>");
	                $("#"+jsons[i].order_ID).append("<td>"+jsons[i].vnum+"</td>");
	                 $("#"+jsons[i].order_ID).append("<td onclick='deleteOrder(this.id)' id='"+jsons[i].order_ID+"'>取消订单</td>");
	                 
         }
        }
     });
}


function deleteOrder(id)
{
		$.ajax({
        url:"/Ordering/DeleteOrder",
        type:"post",
        dataType:"json",   
        data:"id="+id,
        success:function(jsons){
        }
     });
     alert("交易已经取消");
     menu();
}


function msgmanage(){
	$.ajax({
        url:"/Ordering/MsgManageServlet",
        type:"get",
        dataType:"json",
        success:function(jsons){
        
         	$("#msg").empty();
            $("#msg").append("<caption>留言管理</caption>");
            $("#msg").append("<tr id = 'restmsg'></tr>")	;
			$("#restmsg").append("<td>用户ID</td>");				
			$("#restmsg").append("<td>餐馆ID</td>");	
			$("#restmsg").append("<td>时间</td>");	
			$("#restmsg").append("<td>内容</td>");	
			$("#restmsg").append("<td>删除留言</td>");	
							
         for(var i=0;i<jsons.length;i++)
         {
         	$("#msg").append("<tr id ='"+jsons[i].message_ID+"'></tr>");    
	        $("#"+jsons[i].message_ID).append("<td>"+jsons[i].custom_ID+"</td>");
	        $("#"+jsons[i].message_ID).append("<td>"+jsons[i].rest_ID+"</td>");
	         $("#"+jsons[i].message_ID).append("<td>"+jsons[i].time+"</td>");
	           $("#"+jsons[i].message_ID).append("<td>"+jsons[i].message+"</td>");
	            $("#"+jsons[i].message_ID).append("<td onclick='deleteMessage(this.id)' id='"+jsons[i].message_ID+"' >删除留言</td>");
         }
	   
        }
     });
}

function deleteMessage(id)
{
		$.ajax({
        url:"/Ordering/DeleteMessage",
        type:"post",
        dataType:"json",   
        data:"id="+id,
        success:function(jsons){
        }
     });
     alert("留言已经删除");
    msgmanage();
}
</script>
</head>
<body>
	<div id="bg" >
		<img alt="" src="<%=path%>/pic/bg.jpg" width="100%" height="100%">
	</div>
	<div id="Head">
		<div class="Head_Welcome">
			<a>${sessionScope.custom.login_name},Welcome to Your Home</a>
		</div>
	</div>
	<div id="Layout_Right">
		<ul class="Layout_Right_Menu">
			<li id="customMsgMng"><a id="customMsgMng_itemTwo">个人信息管理</a>
				<ul id="customMsgMng_menu">
					<li id="customMsgMng_menu_look"  ><a>个人信息查看</a></li>
					<li id="customMsgMng_menu_update" ><a>个人信息修改</a></li>
				</ul>
			</li>
			<li id="menuMng" onclick="menu()"><a>订单管理</a>
			</li>
			<li id="restMsg" onclick="msgmanage()"><a>留言管理</a>
			</li>
			<li><a href="/Ordering/DestorySession">退出登录</a>
			</li>
		</ul>
	</div>
	<div id="Layout_Left">
		<div class="Layout_Left_Msg">
			<div id="Layout_Left_Msg_CustomMsgMng">
				<div id="CustomMsgMng_show">
				<table border="1">
					<caption>个人信息</caption>
					<tr><td>ID</td><td><input type="text" value="${sessionScope.custom.custom_ID}" disabled="disabled"></td></tr>
					<tr><td>用户名：</td><td><input type="text" value="${sessionScope.custom.login_name}" disabled="disabled"/></td></tr>
					<tr><td>密码：</td><td><input type="text" value="${sessionScope.custom.custom_password}"disabled="disabled"/></td></tr>
					<tr><td>真实姓名：</td><td><input type="text" value="${sessionScope.custom.custom_ID}" disabled="disabled"/></td></tr>
					<tr><td>性别:</td><td><input type="text" value="${sessionScope.custom.custom_sex}" disabled="disabled"/></td></tr>
					<tr><td>年龄：</td><td><input type="text" value="${sessionScope.custom.custom_age}" disabled="disabled"/></td></tr>
					<tr><td>身份证号码：</td><td><input type="text" value="${sessionScope.custom.person_ID}" disabled="disabled"/></td></tr>
				 <tr><td>送货地址：</td><td><input type="text" value="${sessionScope.custom.address}" disabled="disabled"/></td></tr>
				 
				
				 
				 
					<tr><td>联系电话：</td><td><input type="text" value="${sessionScope.custom.phone}" disabled="disabled"/></td></tr>
					<tr><td>电子邮件：</td><td><input type="text" value="${sessionScope.custom.email}" disabled="disabled"/></td></tr>
					<tr><td>QQ：</td><td><input type="text" value="${sessionScope.custom.QQ}" disabled="disabled"/></td></tr>
					<tr><td>注册时间：</td><td><input type="text" value="${sessionScope.custom.regtime}" disabled="disabled"/></td></tr>
					<tr><td>更新时间：</td><td><input type="text" value="${sessionScope.custom.modifedtime}" disabled="disabled"/></td></tr>
					<tr><td>版本号：</td><td><input type="text" value="${sessionScope.custom.vnum}" disabled="disabled"/></td></tr>
					<tr><td>状态：</td><td><input type="text" value="${sessionScope.custom.status}" disabled="disabled"/></td></tr> 
				</table>
				</div>
				<div id="CustomMsgMng_update">
					
					
					
					<form  action="/Ordering/CustomUpdate" method="get">
					
					<table border="1">
					<caption>用户信息修改</caption>
					<tr><td>ID</td><td><input type="text" value="${sessionScope.custom.custom_ID}" id = "id" name = "id" readonly="readonly"></td></tr>
					<tr><td>用户名：</td><td><input type="text" value="${sessionScope.custom.login_name}"  id = "name" name="name"/></td></tr>
					<tr><td>密码：</td><td><input type="text" value="${sessionScope.custom.custom_password}"  id = "pass" name="pass"/></td></tr>
					<tr><td>真实姓名：</td><td><input type="text" value="${sessionScope.custom.custom_ID}"  id = "trueName" name="trueName"/></td></tr>
					<tr><td>性别:</td><td><input type="text" value="${sessionScope.custom.custom_sex}"  id = "sex" name = "sex"/></td></tr>
					<tr><td>年龄：</td><td><input type="text" value="${sessionScope.custom.custom_age}"  id = "age" name = "age"/></td></tr>
					<tr><td>身份证号码：</td><td><input type="text" value="${sessionScope.custom.person_ID}"  id = "person" name = "person"/></td></tr>
				 <tr><td>送货地址：</td><td><input type="text" value="${sessionScope.custom.address}"  id = "address" name = "address"/></td></tr>
					<tr><td>联系电话：</td><td><input type="text" value="${sessionScope.custom.phone}"  id = "phone" name = "phone"/></td></tr>
					<tr><td>电子邮件：</td><td><input type="text" value="${sessionScope.custom.email}"   id = "mail" name = "mail"/></td></tr>
					<tr><td>QQ：</td><td><input type="text" value="${sessionScope.custom.QQ}"  id = "qq" name ="qq"/></td></tr>
					<tr><td>注册时间：</td><td><input type="text" value="${sessionScope.custom.regtime}" disabled="disabled"/></td></tr>
					<tr><td>更新时间：</td><td><input type="text" value="${sessionScope.custom.modifedtime}" disabled="disabled"/></td></tr>
					<tr><td>版本号：</td><td><input type="text" value="${sessionScope.custom.vnum}" disabled="disabled"/></td></tr>
					<tr><td>状态：</td><td><input type="text" value="${sessionScope.custom.status}" disabled="disabled"/></td></tr>
					<tr><td></td><td><input type = "submit" value ="提交修改"  onclick="updateMessage()"/></td></tr> 
				</table>
				
				</form>	
				</div>
			</div>
			<div id="Layout_Left_Msg_MenuMng">
				<table border="1" id="menu">
					<caption>订单管理</caption>
					<tr></tr>
					<tr id="Msg_MenuMng_show">
						<td>总价</td>
						<td>餐馆ID</td>
						<td>送货地址</td>
						<td>联系电话</td>
						<td>下单时间</td>
						<td>订单状况</td>
						<td>注册时间</td>
						<td>更新时间</td>
						<td>版本号</td>
						<td>取消订单</td>
					</tr>
				</table>
			</div>
			<div id="Layout_Left_Msg_RestMsg">
				<table border="1" id ="msg">
					<caption>留言管理</caption>
					<tr>
						<td>用户ID</td>
						<td>餐馆ID</td>
						<td>时间</td>
						<td>内容</td>
						<td>删除</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
