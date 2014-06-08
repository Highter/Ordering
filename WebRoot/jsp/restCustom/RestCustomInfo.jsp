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
	href="<%=path%>/css/RestCustomInfo.css">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/RestCustomInfo.js"></script>
<script type="text/javascript">
	function showDishMenu()
	{
	
	$.ajax({
        url:"/Ordering/RestaurantShowMenu",
        type:"post",
        dataType:"json",
        success:function(jsons){
        
         $("#dishMenu").empty();
           									
								
            $("#dishMenu").append("<tr id = 'dishMenu1'></tr>");
			$("#dishMenu1").append("<td>菜品ID:</td>");				
			$("#dishMenu1").append("<td>所属菜系</td>");	
			$("#dishMenu1").append("<td>餐馆ID</td>");	
			$("#dishMenu1").append("<td>餐品名称</td>");	
			$("#dishMenu1").append("<td>餐品价格</td>");	
			$("#dishMenu1").append("<td>被购买次数</td>");	
			$("#dishMenu1").append("<td>图片</td>");	
			$("#dishMenu1").append("<td>备注</td>");	
			$("#dishMenu1").append("<td>注册时间：</td>");	
			$("#dishMenu1").append("<td>更新时间：</td>");	
			$("#dishMenu1").append("<td>版本号：</td>");	
			$("#dishMenu1").append("<td>状态：</td>");	
			$("#dishMenu1").append("<td>删除</td>");	
			$("#dishMenu1").append("<td>修改</td>");							
         for(var i=0;i<jsons.length;i++)
         {
         	$("#dishMenu").append("<tr id ='"+jsons[i].dish_ID+"'></tr>");  
         	 $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].dish_ID+"</td>");
         	 $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].dish_Style_ID+"</td>");
         	$("#"+jsons[i].dish_ID).append("<td>"+jsons[i].rest_ID+"</td>");
	         $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].dish_Name+"</td>");
	            $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].dish_Price+"</td>");
	             $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].count_buy+"</td>");
	              $("#"+jsons[i].dish_ID).append("<td><img width='50px' height='50px' src='/Ordering"+jsons[i].dish_Photo+"'/></td>");
	               $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].remark+"</td>");
	                $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].regtime+"</td>");
	                 $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].modifedtime+"</td>");
	                  $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].vnum+"</td>");
	               	   $("#"+jsons[i].dish_ID).append("<td>"+jsons[i].status+"</td>");
	               	      $("#"+jsons[i].dish_ID).append("<td onclick='deleteDishMenu(this.id)' id= '"+jsons[i].dish_ID+"'>删除</td>");
	               	  	 $("#"+jsons[i].dish_ID).append("<td  onclick = 'updateDishMenu(this.id)' id= '"+jsons[i].dish_ID+"'>修改</td>");
         }
	   
        }
     });
	}
	
	
function deleteDishMenu(id)
{
		alert("删除成功");
		$.ajax({
        url:"/Ordering/RestDeleteMenu",
        type:"post",
        dataType:"json",
        data:"id="+id,
        success:function(jsons){
        alert("删除成功");
 		 
        }
     });
     showDishMenu();
}

function updateDishMenu(id)
{	
	window.open("/Ordering/Test?id="+id);
	window.close();
	//alert("close");	
}
function  tijiao()
{
	alert("修改成功");
}
function showOrder()
{
		//alert("showOrder");
		$.ajax({
        url:"/Ordering/RestCustomGetAllOrder",
        type:"post",
        dataType:"json",   
          
        success:function(jsons){
        	//alert(jsons);
            $("#Order").empty();				
            $("#Order").append("<tr id = 'order1'></tr>");
            $("#order1").append("<td>订单id:</td>");	
            $("#order1").append("<td>客户id:</td>");	
            $("#order1").append("<td>餐馆ID</td>");
			$("#order1").append("<td>总价</td>");				
			$("#order1").append("<td>送货地址</td>");	
			$("#order1").append("<td>联系电话</td>");	
			$("#order1").append("<td>下单时间</td>");	
			$("#order1").append("<td>订单状况</td>");	
			$("#order1").append("<td>注册时间：</td>");	
			$("#order1").append("<td>更新时间：</td>");	
			$("#order1").append("<td>版本号：</td>");	
			$("#order1").append("<td>取消交易</td>");	
			
		for(var i=0;i<jsons.length;i++)
         {
         	$("#Order").append("<tr id ='"+jsons[i].order_ID+"'></tr>");  
         	 $("#"+jsons[i].order_ID).append("<td>"+jsons[i].order_ID+"</td>");
         	 $("#"+jsons[i].order_ID).append("<td>"+jsons[i].custom_ID+"</td>");
         	  $("#"+jsons[i].order_ID).append("<td>"+jsons[i].restaurant_ID+"</td>");
	           $("#"+jsons[i].order_ID).append("<td>"+jsons[i].sum_Price+"</td>");
	            $("#"+jsons[i].order_ID).append("<td>"+jsons[i].address+"</td>");
	             $("#"+jsons[i].order_ID).append("<td>"+jsons[i].phone+"</td>");
	               $("#"+jsons[i].order_ID).append("<td>"+jsons[i].order_Time+"</td>");
	                $("#"+jsons[i].order_ID).append("<td>"+jsons[i].order_Condition+"</td>");
	                 $("#"+jsons[i].order_ID).append("<td>"+jsons[i].modifedtime+"</td>");
	                  $("#"+jsons[i].order_ID).append("<td>"+jsons[i].regtime+"</td>");
	               	   $("#"+jsons[i].order_ID).append("<td>"+jsons[i].modifedtime+"</td>");
	               	    $("#"+jsons[i].order_ID).append("<td onclick='deleteOrder(this.id)' id= '"+jsons[i].order_ID+"'>取消交易</td>");
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
     showOrder();
}


function showMessage()
{

		$.ajax({
        url:"/Ordering/RestShowMessage",
        type:"post",
        dataType:"json",   
        success:function(jsons){
      //  alert(jsons);
        
        $("#rest_message").empty();
        $("#rest_message").append("<caption>留言列表</caption>");
        for(var i = 0;i<jsons.length;i++)
        {
          $("#rest_message").append("<tr><td>用户名：</td><td><input value='"+jsons[i].custom_name+"' disabled='disabled'/></td><td>留言时间</td><td><input value='"+jsons[i].time+"' disabled='disabled'/></td>	</tr>");
          $("#rest_message").append("<tr><td>留言</td><td colspan='6'><textarea disabled='disabled'>"+jsons[i].message+"</textarea> </td></tr>");
        }  			

     
        }
     });
}
</script>
</head>
<body>
	<div id="bg">
		<img alt="" src="<%=path%>/pic/bg.jpg" width="100%" height="100%">
	</div>
	<div id="Head">
		<div class="Head_Welcome">
			<a>Welcome to Your Home</a>
		</div>
	</div>
	<div id="Layout_Right">
		<ul class="Layout_Right_Menu">
			<li id="customMsgMng"><a id="customMsgMng_itemTwo">餐馆信息管理</a>
				<div id="item_menu_custom">
					<ul id="customMsgMng_menu">
						<li id="customMsgMng_menu_look"><a>餐馆信息查看</a></li>
						<li id="customMsgMng_menu_update"><a>餐馆信息修改</a></li>
					</ul>
				</div>
			</li>
			<li id="menuMsgMng"><a id="menuMsgMng_itemTwo">菜单管理</a>
				<div id="item_menu">
					<ul id="menuMsgMng_menu">
						<li id="menuMsgMng_menu_look"><a>添加菜单</a></li>
						<li id="menuMsgMng_menu_add" onclick="showDishMenu()"><a>查看菜单</a></li>
					</ul>
				</div>
			</li>
			<li id="menuMng" onclick="showOrder()"><a>订单管理</a>
			</li>
			<li id="restMsg"  onclick="showMessage()"><a>留言管理</a>
			</li>
			<li><a href="/Ordering/jsp/restCustom/RestCustomWelcome.jsp">后退</a>
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
					<caption>餐馆信息</caption>
					<tr><td>餐馆ID</td><td><input type="text" value="${sessionScope.rest.rest_ID}" disabled="disabled"/></td></tr>
					<tr><td>主营菜系</td><td><input type="text" value="${sessionScope.rest.dish_Style_ID}" disabled="disabled"/></td></tr>
					<tr><td>餐馆名字</td><td><input type="text" value="${sessionScope.rest.rest_Name}" disabled="disabled"/></td></tr>
					<tr><td>餐馆老板</td><td><input type="text" value="${sessionScope.rest.rest_CEO_ID}" disabled="disabled"/></td></tr>
					<tr><td>订餐电话</td><td><input type="text" value="${sessionScope.rest.rest_Address}" disabled="disabled"/></td></tr>
					<tr><td>餐馆地址</td><td><input type="text" value="${sessionScope.rest.rest_phone}" disabled="disabled"/></td></tr>
					<tr><td>餐馆图片</td><td><img width="100px" height="100px" src="/Ordering/${sessionScope.rest.rest_Photo}" /></td></tr>
					<tr><td>餐馆介绍</td><td><textarea>${sessionScope.message.remark}</textarea></td></tr>
					<tr><td>注册时间</td><td><input type="text" value="${sessionScope.rest.regtime}" disabled="disabled"/></td></tr>
					<tr><td>更新时间</td><td><input type="text" value="${sessionScope.rest.modifedtime}" disabled="disabled"/></td></tr>
					<tr><td>版本号：</td><td><input type="text" value="${sessionScope.rest.vnum}" disabled="disabled"/></td></tr>
					<tr><td>状态：</td><td><input type="text" value="${sessionScope.rest.status}" disabled="disabled"/></td></tr>
				</table>
				</div>
				<div id="CustomMsgMng_update">
					<form  action = "/Ordering/RestautantUpdate" method="get">
					<table border="1">
					<caption>餐馆信息修改</caption>
					<tr><td>餐馆ID</td><td><input type="text" value="${sessionScope.rest.rest_ID}" disabled="disabled" /></td></tr>
					<tr><td>主营菜系</td><td><input type="text" value="${sessionScope.rest.dish_Style_ID}" disabled="disabled"/></td></tr>
					<tr><td>餐馆名字</td><td><input type="text" value="${sessionScope.rest.rest_Name}" disabled="disabled"/></td></tr>
					<tr><td>餐馆老板</td><td><input type="text" value="${sessionScope.rest.rest_CEO_ID}" readonly="readonly" name="id"/></td></tr>
					<tr><td>订餐电话</td><td><input type="text" value="${sessionScope.rest.rest_phone}"  name = "phone"/></td></tr>
					<tr><td>餐馆地址</td><td><input type="text" value="${sessionScope.rest.rest_Address}"  name= "address"/></td></tr>
					<tr><td>餐馆图片</td><td><img width="100px" height="100px" src="/Ordering/${sessionScope.rest.rest_Photo}" /></td></tr>
					<tr><td>餐馆介绍</td><td><textarea>${sessionScope.message.remark}</textarea></td></tr>
					<tr><td>注册时间</td><td><input type="text" value="${sessionScope.rest.regtime}" disabled="disabled"/></td></tr>
					<tr><td>更新时间</td><td><input type="text" value="${sessionScope.rest.modifedtime}" disabled="disabled"/></td></tr>
					<tr><td>版本号：</td><td><input type="text" value="${sessionScope.rest.vnum}" disabled="disabled"/></td></tr>
					<tr><td>状态：</td><td><input type="text" value="${sessionScope.rest.status}" disabled="disabled"/></td></tr>
					<tr><td></td><td><input type = "submit" value = "提交修改" onclick="tijiao()"></td></tr>
					</table>
					</form>
				</div>
			</div>
			<div id="Layout_Left_Msg_MenuMsgMng">
					<div id="MenuMsgMng_look">
						<table border="1" id = "dishMenu" >
							<caption>菜单查看</caption>
							<tr>
								<td>菜品ID</td>
								<td>所属菜系</td>
								<td>餐馆ID</td>
								<td>餐品名称</td>
								<td>餐品价格</td>
								<td>被购买次数</td>
								<td>图片</td>
								<td>备注</td>
								<td>注册时间</td>
								<td>更新时间</td>
								<td>版本号</td>
								<td>状态</td>
								<td>删除</td>
								<td>修改</td>
							</tr>
						</table>
					</div>
					<div id="MenuMsgMng_add">
					
					<form action="/Ordering/RestCustomAddMenu" METHOD="POST" ENCTYPE="multipart/form-data" >
						<table border="1">
							<caption>添加菜单</caption>
								<tr><td>所属菜系</td><td><input type="text" name="style"/></td></tr>
								<tr><td>餐馆ID</td><td><input type="text"  name="restId" value="${rest.rest_ID }" readonly="readonly"/></td></tr>
								<tr><td>餐品名称</td><td><input type="text"  name="name"/></td></tr>
								<tr><td>餐品价格</td><td><input type="text" name="price"/></td></tr>		
								<tr><td>图片</td><td><input type="file" name="photo" id ="photo"/></td></tr>
								<tr><td>备注</td><td><input type="text" name="remark"/></td></tr>
								<tr><td><input type="reset" id="reset" name="reset" value="重置"/></td>
								<td><input type="submit" id="menuMsgBtn" name="menuMsgBtn" value="提交"/></td></tr>
						</table>
					</form>
					</div>
			</div>
			<div id="Layout_Left_Msg_MenuMng">
			
				<table border="1" id ="Order">
					<caption>订单管理</caption>
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
						<td>取消交易</td>
					</tr>
				</table>
			</div>
			<div id="Layout_Left_Msg_RestMsg">
				<table border="1" id = "rest_message">
					<caption>留言管理</caption>
			
				</table>
			</div>
		</div>
	</div>
</body>
</html>
