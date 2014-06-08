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
	href="<%=path%>/css/AdminWelcome.css">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/AdminWelcome.js"></script>

<script type="text/javascript">
function test()
{
		
    	$.ajax({
        url:"/Ordering/AdminGetAllRestaurantMessage",
        type:"get",
        dataType:"json",
        success:function(jsons){
         $("#rest").empty();
            $("#rest").append("<caption>查看所有餐馆信息</caption>");
            $("#rest").append("<tr id = 'frist'></tr>")	;
			$("#frist").append("<td>菜馆id:</td>");				
			$("#frist").append("<td>主营菜系：</td>");	
			$("#frist").append("<td>餐馆名字 ：</td>");	
			$("#frist").append("<td>餐馆老板：</td>");	
			$("#frist").append("<td>订餐电话：</td>");	
			$("#frist").append("<td>餐馆地址：</td>");	
			$("#frist").append("<td>餐馆图片：</td>");	
			$("#frist").append("<td>餐馆的介绍：</td>");	
			$("#frist").append("<td>注册时间：</td>");	
			$("#frist").append("<td>更新时间：</td>");	
			$("#frist").append("<td>版本号：</td>");	
			$("#frist").append("<td>状态：</td>");						
         for(var i=0;i<jsons.length;i++)
         {
         	$("#rest").append("<tr id ='"+jsons[i].rest_ID+"'></tr>");    
	        $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].rest_ID+"</td>");
	        $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].dish_Style_ID+"</td>");
	         $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].rest_Name+"</td>");
	           $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].rest_CEO_ID+"</td>");
	            $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].rest_phone+"</td>");
	             $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].rest_Address+"</td>");
	              $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].rest_Photo+"</td>");
	               $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].remark+"</td>");
	                $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].regtime+"</td>");
	                 $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].modifedtime+"</td>");
	                  $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].vnum+"</td>");
	               	   $("#"+jsons[i].rest_ID).append("<td>"+jsons[i].status+"</td>");
         }
	   
        }
     });
}

function order()
{
		
    	$.ajax({
        url:"/Ordering/AdminGetAllCustom",
        type:"get",
        dataType:"json",
        success:function(jsons){
         $("#order").empty();
            $("#order").append("<caption>订餐用户列表</caption>");
            $("#order").append("<tr id = 'frist1'></tr>")	;
			$("#frist1").append("<td>ID</td>");				
			$("#frist1").append("<td>用户名：</td>");	
			$("#frist1").append("<td>密码：</td>");	
			$("#frist1").append("<td>真实姓名：</td>");	
			$("#frist1").append("<td>性别:</td>");	
			$("#frist1").append("<td>年龄：</td>");	
			$("#frist1").append("<td>身份证号码：</td>");	
			$("#frist1").append("<td>送货地址：</td>");	
			$("#frist1").append("<td>联系电话：</td>");	
			$("#frist1").append("<td>电子邮件：</td>");	
			$("#frist1").append("<td>QQ：</td>");
			$("#frist1").append("<td>角色</td>");	
			$("#frist1").append("<td>注册时间</td>");	
			$("#frist1").append("<td>更新时间</td>");	
			$("#frist1").append("<td>版本号</td>");	
			$("#frist1").append("<td>状态</td>");		
			$("#frist1").append("<td>更改角色</td>");	
				
         for(var i=0;i<jsons.length;i++)
         {
      
         	$("#order").append("<tr id ='"+"c1"+jsons[i].custom_ID+"'></tr>"); 
	        $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_ID+"</td>");
	        $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].login_name+"</td>");
	         $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_password+"</td>");
	          $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_Name+"</td>");
	           $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_sex+"</td>");
	            $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_age+"</td>");
	             $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].person_ID+"</td>");
	              $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].phone+"</td>");
	               $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].address+"</td>");
	                $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].email+"</td>");
	                 $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].QQ+"</td>");
	                  $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].role+"</td>");
	                   $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].regtime+"</td>");
	                    $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].modifedtime+"</td>");
	                     $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].vnum+"</td>");
	                      $("#"+"c1"+jsons[i].custom_ID).append("<td>"+jsons[i].status+"</td>");
	                 
	                 
	               	  $("#"+"c1"+jsons[i].custom_ID).append("<td><button type = 'button' onclick='changeRole("+jsons[i].custom_ID+")'>更新角色</button></td>");
	                  
         }
	   
        }
     });
}


function rest()
{
	
    	$.ajax({
        url:"/Ordering/AdminGetAllRest",
        type:"get",
        dataType:"json",
        success:function(jsons){
         $("#test").empty();
            $("#test").append("<caption>餐馆用户列表</caption>");
            $("#test").append("<tr id = 'frist2'></tr>")	;
			$("#frist2").append("<td>ID</td>");				
			$("#frist2").append("<td>用户名：</td>");	
			$("#frist2").append("<td>密码：</td>");	
			$("#frist2").append("<td>真实姓名：</td>");	
			$("#frist2").append("<td>性别:</td>");	
			$("#frist2").append("<td>年龄：</td>");	
			$("#frist2").append("<td>身份证号码：</td>");	
			$("#frist2").append("<td>送货地址：</td>");	
			$("#frist2").append("<td>联系电话：</td>");	
			$("#frist2").append("<td>电子邮件：</td>");	
			$("#frist2").append("<td>QQ：</td>");	
			$("#frist2").append("<td>角色</td>");	
			$("#frist2").append("<td>注册时间：</td>");	
			$("#frist2").append("<td>更新时间：</td>");	
			$("#frist2").append("<td>版本号：</td>");	
			$("#frist2").append("<td>状态：</td>");	
         for(var i=0;i<jsons.length;i++)
         {
        
         	$("#test").append("<tr id ='"+"c2"+jsons[i].custom_ID+"'></tr>");    
	        $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_ID+"</td>");
	        $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].login_name+"</td>");
	         $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_password+"</td>");
	          $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_Name+"</td>");
	           $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_sex+"</td>");
	            $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].custom_age+"</td>");
	             $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].person_ID+"</td>");
	              $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].phone+"</td>");
	               $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].address+"</td>");
	                $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].email+"</td>");
	                 $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].QQ+"</td>");
	                  $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].role+"</td>");
	                   $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].regtime+"</td>");
	                    $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].modifedtime+"</td>");
	                     $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].vnum+"</td>");
	                      $("#"+"c2"+jsons[i].custom_ID).append("<td>"+jsons[i].status+"</td>");
         }
	   
        }
     });
}

function changeRole(value)
{
   
        $.ajax({
        url:"/Ordering/AdminChangeRole?id="+value,
        type:"get",
        dataType:"json",
        success:function(jsons){
        }
     });
	
	order();
}

</script>
</head>
<body>
	<div id="bg" >
		<img alt="" src="<%=path%>/pic/bg.jpg" width="100%" height="100%">
	</div>
	<div id="Head">
		<div class="Head_Welcome">
			<a>axxxAdmin,Welcome to login</a>
		</div> 
	</div>
	<div id="Layout_Right">
		<ul class="Layout_Right_Menu">
			<li id="register"><a>为用户注册餐馆</a>
			</li>
			<li id="restaurant" onclick="test()"><a>查询餐馆列表</a></li>
			<li id="custom">
				<a id="custom_itemTwo">查询用户列表</a>
				<ul id="custom_menu">
					<li id="custom_menu_Order" onclick="order()"><a>订餐用户列表</a>
					</li>
					<li id="custom_menu_Rest"  onclick="rest()"><a>餐馆用户列表</a>
					</li>
				</ul>
			</li>
			<li><a href="/Ordering/html/custom/CustomLogin.html">退出登录</a>
			</li>
		</ul>
	</div>
	<div id="Layout_Left">
		<div class="Layout_Left_Msg">
			<div id="Layout_Left_Msg_CustomRegister">
				<jsp:include page="/html/restCustom/RestaurantRegister.html" />
			</div>
			<div id="Layout_Left_Msg_RestaurantShow">
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
			<div id="Layout_Left_Msg_CustomShow">
				<div id="Layout_Left_Msg_OrderingCustomShow">
							<table border="1" id ="order">
			<caption>订餐用户列表</caption>
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
				<td>角色更改</td>
			</tr>
			
		</table>
				</div>
				<div id="Layout_Left_Msg_RestaurantCustomShow">
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
			</tr>
		</table>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
