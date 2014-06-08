<%@ page language="java" import="java.util.*,bean.ShoppingCar" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShoppingCar.jsp' starting page</title>
    
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
   
    <%
    if(request.getSession().getAttribute("shop")!=null)
    {
   		 int size = ((List<ShoppingCar>)request.getSession().getAttribute("shop")).size();
   		 request.getSession().setAttribute("size", size);
    	
    }
    else
    {
    	int size = 0;
    	request.getSession().setAttribute("size", size);
    }   
    %>
    <h1>欢迎查看购物车</h1>
    	<table border="1">
		<c:forEach var="val" begin="0" end="${sessionScope.size }" items="${sessionScope.shop }"
			step="1">
			<tr>
				<td>餐馆名</td>
				<td>${val.restName }</td>
				<td>菜名</td>
				<td>${val.dishName }</td>
			</tr>
			<tr>
			<td colspan="2"><img  width="100" height="100"  src="/Ordering${val.photo }"/></td>
			</tr>
			<tr>
			<td>价格:</td><td>${val.price }</td>
			</tr>
			<tr>
			<td>数量</td><td>${val.count }</td>
			</tr>
		
			
			
		</c:forEach>
		
		    <%
    if(request.getSession().getAttribute("shop")!=null)
    {
   		 List<ShoppingCar> all=(List<ShoppingCar>)request.getSession().getAttribute("shop");
   		 double sum = 0;
   		 for(int i =0;i<all.size();i++)
   		 {
   		 	sum = sum+all.get(i).getCount()*all.get(i).getPrice();
   		 }
   		 request.getSession().setAttribute("sum", sum);
    	
    }
    else
    {
    	double sum = 0;
    	request.getSession().setAttribute("sum", sum);
    }   
    %>
		<tr>
		<td>总价格</td><td>${sum}</td>
			<td></td>
			<td>
			<form action="/Ordering/CustomCommit" method="post">
			<input type="submit" value="提交订单"/>
			</form>
			</td>
			</tr>
	</table>
    
    	
  </body>
</html>
