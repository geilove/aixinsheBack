<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
  System.out.println(path);
  System.out.println(basePath);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<base href="<%=basePath%>">
	<title>CourseList</title>
	<meta charset="utf-8">
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/bootstrap3/css/bootstrap.css"></link>
<script	src="<%=path %>/resources/jquery/jquery-1.11.1.js"type="text/javascript"></script>
<script src="<%=path %>/resources/bootstrap3/js/bootstrap.js"type="text/javascript"></script>
</head>
<body style="background-color: #efeeec">
<nav class="navbar navbar-default" role="navigation" style="border-bottom-color: #FF2525;border-top-color: #B9EB6E;" >
    <div class="container">

        <div class="navbar-header" style="font-weight:bolder;margin-top:-14px;">
            <a class="navbar-brand" href="#"><img src="../../../images/0.jpg"></a>
        </div>
        <div class="navbar-header" style="font-weight:bolder;margin-left: 10px;">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span>é¦é¡µ</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" style="font-weight:bolder; font-size: 18px;">
                <li class="active"  style="margin-left:10px;"><a href="#"><span class="glyphicon glyphicon-leaf"></span>é¡¹ç®</a></li>
                <li style="margin-left:10px;"><a href="#"><span class="glyphicon glyphicon-camera"></span>è¯é¢</a></li>
                <li class="dropdown" style="margin-left:10px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-volume-up"></span>æ¶æ¯</a>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="æ¥æ¾ä½ æå´è¶£çè¯é¢ äººç©" style="width:260px;">
                </div>
                <button type="submit" class="btn btn-default">æ£ç´¢</button>
            </form>
            <ul class="nav navbar-nav " style="font-weight: bolder;margin-left: 10px;">
                <li class="dropdown" style="margin-left: 10px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-bell"></span>ç±å¿ç¤¾</a>
                </li>
                <li class="dropdown" style="margin-left:10px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-eye-open"></span>çç£å¢</a>
                </li>

                <li class="dropdown" style="margin-left: 20px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user" style="margin-right:5px;"></span>è¾æµ·æ¶</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
      åèç¹åæ¶é´ç­
</div>
</body>
</html>