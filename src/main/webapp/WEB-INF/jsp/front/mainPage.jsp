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
<body>
<nav class="navbar navbar-default" role="navigation" style="border-bottom-color: #FF2525;border-top-color: #B9EB6E;" >
  <div class="container" >

    <div class="navbar-header" style="font-weight:bolder;margin-top:-14px;">
      <a class="navbar-brand" href="#"><img src="../image/0.jpg"></a>
    </div>
    <div class="navbar-header" style="font-weight:bolder;margin-left: 10px;">
      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span>首页</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav" style="font-weight:bolder; font-size: 18px;">
        <li class="active"  style="margin-left:10px;"><a href="#"><span class="glyphicon glyphicon-leaf"></span>项目</a></li>

        <li class="dropdown" style="margin-left:10px;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-volume-up"></span>话题</a>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="检索你感兴趣的内容" style="width:200px;">
          <div class="btn-group">
            <button type="button" class="btn btn-danger">消息</button>
            <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
              <span class="caret"></span>
              <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
              <li><a href="#">话题</a></li>
              <li><a href="#">人物</a></li>
              <li><a href="#">推文</a></li>
              <li class="divider"></li>
              <li><a href="#">爱心社</a></li>
            </ul>
          </div>
        </div>
        <button type="submit" class="btn btn-default">检索</button>
      </form>
      <ul class="nav navbar-nav " style="font-weight: bolder;margin-left: 10px;">
        <li style="margin-left:10px;"><a href="#"><span class="glyphicon glyphicon-camera"></span>基金</a></li>

        <li class="dropdown" style="margin-left: 10px;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-bell"></span>爱心社</a>
        </li>
        <li class="dropdown" style="margin-left:10px;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-eye-open"></span>监督团</a>
        </li>

        <li class="dropdown" style="margin-left: 20px;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user" style="margin-right:0px;"></span>爱心社</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">

  <div class="row">

    <div class="col-md-2" style="background-color: #AFD8EE;height: 1000px;">
      <ul class="left" style="margin-top: 20px;font-size: 16px;font-weight: bolder">
        <li>手套社</li>
        <li>监督团</li>
      </ul>
      <hr>
      <div class="left1" style="margin-top: 20px;margin-left: 30px;">
        <div><span class="glyphicon glyphicon-eye-open" style="margin-right: 5px;"></span>特别关注</div>
        <div><span class="glyphicon glyphicon-log-in" style="margin-right: 5px;"></span>默认分组</div>
        <div><span class="glyphicon glyphicon-phone" style="margin-right: 5px;"></span>好友</div>
      </div>
    </div>
    <div class="col-md-7" >
      <div>写点什么告诉大家</div>
            <textarea class="W_input " title="发布" name="" node-type="textEl" range="0&amp;0" content=""
                      style="width:100%;height:88px;margin: 0px; padding: 0px;  border-width: 1px; font-size: 14px; word-wrap: break-word; line-height: 18px; overflow-y: auto; overflow-x: hidden; outline: none;">
            </textarea>
      <br/>
      <div class="weibo col-md-11">
        <span class="glyphicon glyphicon-heart-empty">表情</span>
        <span class="glyphicon glyphicon-picture">图片</span>
        <span class="glyphicon glyphicon-facetime-video">视频</span>
        <span class="glyphicon glyphicon-comment">长推文</span>
      </div>
      <div class="col-md-1">
        <input type="button" value="发布" style="margin-left:-5px;">
      </div>
      <div><hr>这里是推文主体</div>

      <div></div>

    </div>

    <div class="col-md-3" style="background-color: #EAE0BD;height:1000px;">
      <div style="margin: auto 0; margin-left: 60px;" >
        <img  style="width:150px;height:143px;" src="../image/touxiang.jpg"/>
      </div>
      <div style="margin-left: 90px;">KbeCocos2dx</div>
      <div class="row" style="margin-top:20px;">
        <div class="col-md-3">
          <div>100</div>
          <div>关注</div>
        </div>
        <div class="col-md-3">
          <div>100</div>
          <div>粉丝</div>
        </div>
        <div class="col-md-3">
          <div>100</div>
          <div>推文</div>
        </div>
        <div class="col-md-3">
          <div>100元</div>
          <div>捐的钱</div>
        </div>
      </div>
      <hr class="hr">
      <div>
       可能感兴趣的人
      </div>
      <hr class="hr">
      <div>可能感兴趣的项目</div>
      <hr class="hr">
      <div>热门话题</div>
    </div><!-- col-md-3 -->
  </div><!-- row -->
</div> <!-- container -->
</body>
</html>
