<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>完整demo</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" charset="utf-8" src="ueditor/js/jquery.min.js"></script>
    <style type="text/css">
        div{
            width:100%;
        }
    </style>
 <style> 
body{ text-align:center} 
.div{ margin:0 auto; width:1024px;height:600px; border:1px solid #F00}
/* css注释：为了观察效果设置宽度 边框 高度等样式 */ 
</style>
</head>
<body>

    <h1>一级标题：</h1><input type="text" style="width:400px;">
    <h2>二级标题：</h2><input type="text" style="width:400px;">
    <h3>编辑正文</h3>
    <div class="div">
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
    
	</div>
<div id="btns">
    <div>
        <button onclick="getContentTxt()">提交发布</button>
    </div>
</div>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');

    function getContentTxt() {
		var content = ue.getContent();
		console.log("content:"+content);
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/test-ueditor/text/save.do",
			data:{
				"Content":content,
				
			},
			success:function(){
				alert("成功");
			},
			error:function(){
				alert("失败");
			}
		});
    }

</script>
</body>
</html>