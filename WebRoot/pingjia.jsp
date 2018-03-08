<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String dakaState= ""+request.getAttribute("dakaState");
String dakaimage = ""+request.getAttribute("dakaimage");
String []dakaimage1 = dakaimage.split("#");
String dakacanlei= ""+request.getAttribute("dakacanlei");
String dakashicaiyuliang= ""+request.getAttribute("dakashicaiyuliang");
String []dakashicaiyuliang1 = dakashicaiyuliang.split("#");
String dakabuzhou= ""+request.getAttribute("dakabuzhou");
String []dakabuzhou1 = dakabuzhou.split(";");
String []dakabuzhou11 = dakabuzhou1[0].split("#");
String []dakabuzhou12 = dakabuzhou1[1].split("#");
String daka_username= ""+request.getAttribute("daka_username");
String daka_pingjia= ""+request.getAttribute("daka_username");
String daka_time= ""+request.getAttribute("daka_time");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>评价用户打卡</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" charset="utf-8" src="ueditor/js/jquery.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<style type="text/css">
.imgall{
  -webkit-box-shadow: inset 0 0 4px rgba(0,0,0,1), inset 0 2px 1px rgba(255,255,255,.5), inset 0 -9px 2px rgba(0,0,0,.6), inset 0 -12px 2px rgba(255,255,255,.3); 
    -moz-box-shadow: inset 0 0 4px rgba(0,0,0,1), inset 0 2px 1px rgba(255,255,255,.5), inset 0 -9px 2px rgba(0,0,0,.6), inset 0 -12px 2px rgba(255,255,255,.3); 
    box-shadow: inset 0 0 4px rgba(0,0,0,1), inset 0 2px 1px rgba(255,255,255,.5), inset 0 -9px 2px rgba(0,0,0,.6), inset 0 -12px 2px rgba(255,255,255,.3); 
    -webkit-border-radius: 20px; 
    -moz-border-radius: 20px; 
    border-radius: 20px; 
    width:150px;
}
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
function postcall(url, params, target){  
    var tempform = document.createElement("form");  
    tempform.action = url;  
    tempform.method = "post";  
    tempform.style.display="none"  
    if(target) {  
        tempform.target = target;  
    }  
  
    for (var x in params) {  
        var opt = document.createElement("input");  
        opt.name = x;  
        opt.value = params[x];  
        tempform.appendChild(opt);  
    }  
  
    var opt = document.createElement("input");  
    opt.type = "submit";  
    tempform.appendChild(opt);  
    document.body.appendChild(tempform);  
    tempform.submit();  
    document.body.removeChild(tempform);  
}
function pingjia(){
var friUsername=document.getElementById("7").value;

  var o=document.getElementById("10").value;
  var a="";
  for(var i=0;i<o;i++){
  a=document.getElementById("shicai"+i).value+"*"+document.getElementById("liang"+i).value+"#"+document.getElementById("first"+i).value+"?"+a;
  }
 // alert(a);//第一行数据获取到
  var b="";
  var r=document.getElementsByName("imageName");
  var m=document.getElementsByName("note");
  for(var j=0;j<r.length;j++){
  b=r[j].value+"#"+m[j].value+"?"+b;
  }
  //alert(b);//第二行数据获取到
  var c=document.getElementById("txt1").value;
  var d=document.getElementById("txt2").value;
  var e=document.getElementById("sheruzongnengliang").value;
  //alert(c);
  //alert(d);
var friTime=document.getElementById("9").value;
var fridakaleibie=document.getElementById("2").value;
var shicaiyuliangNengliang=a;
var yingyangjisuan=b;
var yinshijianyi=c;
var chanpintuijian=d;
var zongnengliang=e;
  var user_json = {"friUsername": friUsername,"friTime":friTime,"fridakaleibie":fridakaleibie,
                "shicaiyuliangNengliang":shicaiyuliangNengliang,
                "yingyangjisuan":yingyangjisuan,
                "yinshijianyi":yinshijianyi,
                "chanpintuijian":chanpintuijian,
                "zongnengliang":zongnengliang
            } 
 postcall("updatepingjia.do",user_json); 
}  
</script>
	<script>
	function addCurrentRow()
	{
	var trcomp="<tr><td><input name='imageName'></input></td><td><input name='note' /></td><td><a href='javascript:;' onclick='deleteCurrentRow(this);'><font color='red'>删除</font></a></td></tr>";
	$("#allDatas tr:last-child").after(trcomp);
	}
	  
	function deleteCurrentRow(obj)
	{
	var isDelete=confirm("真的要删除吗？");
	if(isDelete)
	{
	var tr=obj.parentNode.parentNode;
	var tbody=tr.parentNode;
	tbody.removeChild(tr);
	}
	}
	</script>

  </head>
  
  <body style="display:inline; text-align:center;border:1px solid #000;">
  <span>打卡时间：<%=daka_time%></span>
  <div style="display:none;">
    <c:forEach items="${list}" var="list">
		<input type="text" id="1" value="${list.dakaId}"/>
		<input type="text" id="2" value="${list.dakaState}"/>
		<input type="text" id="3" value="${list.dakaimage}"/>
		<input type="text" id="4" value="${list.dakacanlei}"/>
		<input type="text" id="5" value="${list.dakashicaiyuliang}"/> 
		<input type="text" id="6" value="${list.dakabuzhou}"/> 
		<input type="text" id="7" value="${list.daka_username}"/> 
		<input type="text" id="8" value="${list.daka_pingjia}"/>
		<input type="text" id="9" value="${list.daka_time}"/>	
		
	</c:forEach>
	<input type="text" id="10" value="<%=dakashicaiyuliang1.length%>"/>
	</div>
	<h1>用户：<%=daka_username%></h1>
	<h2>打卡形式：<%=dakaState%></h2>
	<h3>打卡类型：<%=dakacanlei%>打卡</h3>
	<h3><%=daka_username%>的上传图片</h3>
	<div>
	<%for(int i=0;i<dakaimage1.length;i++) {%>
	<img alt="上传的图片" src="app_imagesText/<%=dakaimage1[i]%>" class="imgall">
	<%}%>
	</div>
	<h3><%=daka_username%>的食材与量</h3>
	<div>
	<%for(int i=0;i<dakashicaiyuliang1.length;i++) {
	String[] a=dakashicaiyuliang1[i].split(";");
	%>
	<span><%=a[0] %></span><input type="text" id="shicai<%=i%>" value="<%=a[0] %>" style="display:none;"/> <span><%=a[1] %>克</span><input type="text" id="liang<%=i%>" value="<%=a[1] %>" style="display:none;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计算能量<input type="text" id="first<%=i%>"/><br/>
	<%}%>
	</div>
	<h3><%=daka_username%>的烹饪方法</h3>
	<div style="margin:0 auto;">
		<%for(int i=0;i<dakabuzhou11.length;i++) {%>
		<img alt="上传的图片" src="app_imagesText/<%=dakabuzhou11[i]%>" class="imgall">
		<span><%=dakabuzhou12[i] %></span>
	<%}%> 
	</div>
	<h3>营养师：营养计算</h3>
	<div style="margin:0 auto;">
	<table id="allDatas" class="imagetable" style="margin:0 auto;">
	<tr>
	<th>营养物质</th>
	<th>含量</th>
	<th>操作</th>
	</tr>
	<tr>
	<td><input name="imageName" value="蛋白质"/></td>
	<td><input name="note" /> </td>
	<td><a href="javascript:;" onclick="deleteCurrentRow(this);"><font color='red'>删除</font></a> </td>
	<td><input name="imageName" value="碳水化合物"/></td>
	<td><input name="note" /> </td>
	<td><a href="javascript:;" onclick="deleteCurrentRow(this);"><font color='red'>删除</font></a> </td>
	<td><input name="imageName" value="钠"/></td>
	<td><input name="note" /> </td>
	<td><a href="javascript:;" onclick="deleteCurrentRow(this);"><font color='red'>删除</font></a> </td>
	</tr>
	</table>
	<button onclick="javascript:addCurrentRow();" >添加</button>
	</div>
	<h3>营养师：饮食建议</h3>
	<div style="margin:0 auto;">
	<textarea id="txt1" name="txt" clos="100" rows="5" warp="virtual"></textarea>
	</div>
	<h3>营养师：产品推荐</h3>
	<div style="margin:0 auto;">
	<textarea id="txt2" name="txt2" clos="100" rows="5" warp="virtual"></textarea>
	</div>
	<h3>用户摄入的总能量：</h3><div style="margin:0 auto;"><input type="text" id="sheruzongnengliang"/></div>
	<div style="margin:0 auto;">
	<button onclick="pingjia()">发布评价</button>
	</div>
  </body>
</html>
