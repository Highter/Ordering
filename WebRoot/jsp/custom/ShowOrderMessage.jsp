<%@ page language="java" import="java.util.*,bean.ShoppingCar" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowOrderMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function ToClose()
{
	window.close();
}
</script>
  </head>
  
  <body>
    <h1>您的订单已经提交成功！</h1>
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
    
    request.getSession().setAttribute("shop", null);
    %>
    <h1>您总共消费了${sum}元</h1>
    <h1  onclick="ToClose()">点击关闭窗口！</h1>
  </body>
</html>
