<%@page import="bean.Custom"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>My JSP 'CustomWelcome.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/CustomWelcome.css">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/CustomWelcome.js"></script>
<script type="text/javascript">
	function ShowHotRestaurants(){
		$.ajax({
        url:"/Ordering/ShowHotRestaurants",
        type:"get",
        dataType:"json",
        success:function(jsons){
		  $("#hotRest").empty();
         for(var i=0;i<3;i++)
         {
         	$("#hotRest").append("<div class='HotRestTable'  id = '"+"hot"+i+"'></div>");    
	        $("#"+"hot"+i).append("<table border='1' id='"+"m"+jsons[i].rest_ID+"'></table>");
	        $("#"+"m"+jsons[i].rest_ID).append("<tr><td colspan='2'><img id='menuPic' src='/Ordering"+jsons[i].rest_Photo+"'/></td></tr>");
	        $("#"+"m"+jsons[i].rest_ID).append("<tr><td colspan='2'><textarea>"+jsons[i].remark+"</textarea></td></tr>");
	        $("#"+"m"+jsons[i].rest_ID).append("<tr><td colspan='2'><button id='"+jsons[i].rest_ID+"' name='menuLook' onclick='restaurantShow(this.id)'>查看餐馆</button> </td></tr>");
         }
        }
     });
	}
	function ShowHotMenuDish(){
		$.ajax({
        url:"/Ordering/ShowHotMenuDish",
        type:"get",
        dataType:"json",
        success:function(jsons){
         $("#hotFood").empty();
 		
         for(var i=0;i<3;i++)
         {
         	$("#hotFood").append("<div class='HotMenuTable' id = '"+"hotMenu"+i+"'></div>");    
	        $("#"+"hotMenu"+i).append("<table border='1' id='"+"t"+jsons[i].dish_ID+"'></table>");
	        $("#"+"t"+jsons[i].dish_ID).append("<tr><td colspan='2'><img id='menuPic' src='/Ordering"+jsons[i].dish_Photo+"'/></td></tr>");
	        $("#"+"t"+jsons[i].dish_ID).append("<tr><td colspan='2'><textarea>"+jsons[i].remark+"</textarea></td></tr>");
	        $("#"+"t"+jsons[i].dish_ID).append("<tr><td>价格:</td><td>"+jsons[i].dish_Price +"</td></tr>");
	        $("#"+"t"+jsons[i].dish_ID).append("<tr><td colspan='2'><button id='"+jsons[i].dish_ID+"' name='menuLook' onclick='MenuShow(this.id)'>查看餐品</button> </td></tr>");
         }
        }
     });
	}
	function Search()
	{
		var msg = document.getElementById("search_Msg").value;
		var select = document.getElementById("iteamType").value;
		//alert(msg);
		//alert(select);
		if(msg!=null&&select!=null)
		{
			window.open("/Ordering/CustomSearch?msg="+msg+"&select="+select);
		}
	}
	function MakeSure(){
		var name = '${custom.login_name}';
		if(name!=""){
			//订餐用户
			$("#title1").css("display","none");
			$("#title2").css("display","block");
			$("#registerCustom").css("display","none");
			$("#loginCustom").css("display","none");
		}else{
			//游客
			$("#title1").css("display","block");
			$("#title2").css("display","none");
			$("#inforCustom").css("display","none");
			$("#carCustom").css("display","none");
			$("#offCustom").css("display","none");
		}
	}
</script>
</head>

<body onload="MenuLoad()">
	<div id="bg" >
		<img alt="" src="<%=path%>/pic/bg.jpg" width="100%" height="100%">
	</div>
	<div id="Head">
		<div class="Head_Welcome">
			<a id="title1">Welcome to CYL 订餐网</a>
			<a id="title2" style="display: none">${custom.login_name},Welcome to CYL 订餐网</a>
		</div>
		<div id="Search">
			<form action="/Ordering/CustomSearch" method="get">
				<select name="iteamType" id= "iteamType">
					<option value="1">餐馆</option>
					<option value="2">菜单</option>
				</select>
				 <input type="text" id="search_Msg" name="search_Msg" /> 
				 <input type="button" id="search_Btn" name="search_Btn" value="search" onclick="Search()" />
			</form>
		</div>
		<div id="Menu">
			<a href="/Ordering/html/custom/CustomRegister.html" id="registerCustom">注册</a> 
			<a href="/Ordering/html/custom/CustomLogin.html" id="loginCustom">登陆入口</a>
			<a href="/Ordering/jsp/custom/CustomInfo.jsp" id="inforCustom">个人信息</a> 
			<a href="/Ordering/jsp/custom/ShoppingCar.jsp" target="_blank" id="carCustom">我的购物车</a> 
			<a href="/Ordering/DestorySession" id="offCustom">退出</a>
		</div>
	</div>
	<div id="Layout_Right">
		<ul class="Layout_Right_Menu">
			<li><a id="one">鲁菜</a>
			</li>
			<li><a id="two">川菜</a>
			</li>
			<li><a id="three">粤菜</a>
			</li>
			<li><a id="four">苏菜</a>
			</li>
			<li><a id="five">闽菜</a>
			</li>
			<li><a id="six">浙菜</a>
			</li>
			<li><a id="seven">湘菜</a>
			</li>
			<li><a id="eight">徽菜</a>
			</li>
		</ul>
	</div>
	<!-- 显示菜系的div -->
	<div id="styleOne">
		<table id="menuOne" style="width: 500px;height: 250px;margin: 5px;">
			<tr><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td></tr>
			<tr><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td></tr>
			<tr><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td></tr>
			<tr><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td><td>鲁菜</td></tr>
		</table>
	</div>
	<div id="styleTwo">
		<table id="menuTwo" style="width: 500px;height: 250px;margin: 5px;">
		</table>
	</div>
	<div id="styleThree">
		<table id="menuThree" style="width: 500px;height: 250px;margin: 5px;">
		</table>
	</div>
	<div id="styleFour">
		<table id="menuFour" style="width: 500px;height: 250px;margin: 5px;">
		</table>
	</div>
	<div id="styleFive">
		<table id="menuFive" style="width: 500px;height: 250px;margin: 5px;">
		</table>
	</div>
	<div id="styleSix">
		<table id="menuSix" style="width: 500px;height: 250px;margin: 5px;">
		</table>
	</div>
	<div id="styleSeven">
		<table id="menuSeven" style="width: 500px;height: 250px;margin: 5px;">
		</table>
	</div>
	<div id="styleEight">
		<table id="menuEight" style="width: 500px;height: 250px;margin: 5px;">
		</table>
	</div>
	<div id="Layout_Left">
		<div class="Layout_Left_Msg" id="test">
			<div class="Layout_Left_Msg_HotRest">
				<div class="Title"><a>热门餐馆</a></div>
				<div class="HotMsg" id="hotRest">
					<!-- <div class="HotRestTable" >
						<table border="1">
						<tr><td><img src=""/></td></tr>
						<tr><td><textarea>很好的餐馆</textarea></td></tr>
						<tr style="display: none"><td>餐馆ID</td></tr>
						<tr><td><button type="button" id ="20" onclick="restaurantShow(this.id)">查看餐馆</button></td></tr>
						</table>
					</div>
					<div class="HotRestTable">
						<table border="1">
						<tr><td><img src=""/></td></tr>
						<tr><td><textarea>很好的餐馆...</textarea></td></tr>
						<tr style="display: none"><td>餐馆ID</td></tr>
						<tr><td><button type="button" id ="21" onclick="restaurantShow(this.id)">查看餐馆</button></td></tr>
						</table>
					</div> -->
				</div>
			</div>
			<div class="Layout_Left_Msg_HotMenu">
				<div class="Title"><a>热门商品</a></div>
				<div class="HotMsg" id ="hotFood">
					<!-- <div class="HotMenuTable">
						<table border="1">
							<tr><td colspan="2"><img id="menuPic" src=""/></td></tr>
							<tr><td colspan="2"><textarea>很好的商品</textarea></td></tr>
							<tr><td>价格:</td><td>123</td></tr>
							<tr>
							<td><button id="20" name="menuLook" onclick="MenuShow(this.id)">查看餐品</button> </td>
							</tr>
						</table>
					</div>
					<div class="HotMenuTable" id ="hotFood">
						<table border="1">
							<tr><td colspan="2"><img id="menuPic" src=""/></td></tr>
							<tr><td colspan="2"><textarea>很好的商品</textarea></td></tr>
							<tr><td>价格:</td><td>321</td></tr>
							<tr >
							<td colspan="2"><button id="21" name="menuLook" value=" " onclick="MenuShow(this.id)">查看餐品</button> </td>
							</tr>
						</table>
					</div> -->
				</div>
					
			</div>
		</div>
	</div>
</body>
</html>
