<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=contextPath%>/resources/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript">
		$(function(){
		    $("#send").click(function(){
		    	var jsondata = $("#jsondata").val();
		    	var requestType = $("#requestType").val();
		    	var requestUrl = $("#requestUrl").val();
		    	var jsonobj = JSON.parse(jsondata);
		    	var callback = function (data) {
		    		$("#result").html(JSON.stringify(data));
		    	};
		    	
				$.postJSON('<%=contextPath%>/' + requestUrl, requestType, jsonobj, callback);
			});
		});
		$.postJSON = function(url, requestType, data, callback){
			return jQuery.ajax({
				'type' : requestType,
				'url' : url,
				'contentType' : 'application/json',
				'processData' : false,
				'data' : JSON.stringify(data),
				'dataType' : 'json',
				'success' : callback
			});
		};
</script>
</head>
<body>
		请求地址
	<br/>
	<input type="text" id="requestUrl" />
	<br/>
	<br/>
		JSON对象
	<br>
	<textarea id="jsondata" cols="60" rows="10"></textarea>
	<br/>

	<select id="requestType">
		<option value="POST">POST</option>
	</select>
	<button id="send">SUBMIT</button><br>
	<font color="red" id="result"></font>
	
	<a href="http://localhost:8080/glove/main/">首页</a>
	<a href="http://localhost:8080/glove/login">登录</a>
	<a href="http://localhost:8080/glove/register">注册</a>
	
</body> 
</html>