<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String aaa="赋值";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>打卡操作页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table.imagetable {
font-family: verdana,arial,sans-serif;
font-size:11px;
color:#333333;
border-width: 1px;
border-color: #999999;
border-collapse: collapse;
}
table.imagetable th {
background:#b5cfd2 url('cell-blue.jpg');
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #999999;
}
table.imagetable td {
background:#dcddc0 url('cell-grey.jpg');
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #999999;
}
</style>
  <script type="text/javascript">
  		function pingjia(a,b){
  		if(a=="审核中"){
  		window.location.href="selectDakaALLTextByid.do?id="+b;
  		}else{
  		alert("您已经评价过了");
  		}
  		}
  </script>
  </head>
  
  <body>
   <table class="imagetable">
		<tr>
		<th>id</th>
		<th>打卡时间</th>
		<th>打卡人</th>
		<th>打卡类型</th>
		<th>打卡状态</th>
		<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="list">
		<tr>
		<td>${list.dakaId}</td>
		<td>${list.daka_time}</td>
		<td>${list.daka_username}</td>
		<td>${list.dakaState}</td>
		<td>${list.daka_pingjia}</td>
		<td><button onclick="pingjia('${list.daka_pingjia}','${list.dakaId}')">
		<c:if test="${list.daka_pingjia eq '审核中'}">去评价</c:if>
		<c:if test="${list.daka_pingjia ne '审核中'}">已评价</c:if></button></td>
		</tr>
		</c:forEach>
</table>
  </body>
</html>
