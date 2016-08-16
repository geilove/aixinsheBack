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
  <div class="container" >

    <div class="navbar-header" style="font-weight:bolder;margin-top:-14px;height: 20px;width:40px ">
      <!--<a class="navbar-brand" href="#"><img src="../../../images/0.jpg"></a>-->
    </div>
    <div class="navbar-header" style="font-weight:bolder;margin-left: 10px;">
      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span>首页</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav" style="font-weight:bolder; font-size: 18px;">
        <li class="active"  style="margin-left:10px;"><a href="#"><span class="glyphicon glyphicon-leaf"></span>项目</a></li>

        <li class="dropdown" style="margin-left:10px;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-volume-up"></span>消息</a>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="查找你感兴趣的话题人物" style="width:200px;">
          <div class="btn-group">
            <button type="button" class="btn btn-danger">选择</button>
            <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
              <span class="caret"></span>
              <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
              <li><a href="#">话题</a></li>
              <li><a href="#">人物</a></li>
              <li><a href="#">爱心社</a></li>
              <li class="divider"></li>
              <li><a href="#">推文</a></li>
            </ul>
          </div>
        </div>
        <button type="submit" class="btn btn-default">提交</button>
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
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user" style="margin-right:0px;"></span>艾海涛</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container" style="margin-top: -8px;">
  <div class="row" style="margin-top: -8px;height: 59px;background-color: #efeeec">
    <div class="col-lg-1  col-md-offset-5" >
      <div style="font-weight: bolder;font-size: 17px"> 艾海涛 </div>

    </div>

  </div>
  <div class="row" style="background-color: #ffffff;height: 178px;">
    <div class="col-md-2">
      <div style="padding: 3px;"> <img src="../image/touxiang.jpg/" style="margin-top:-20px; "></div>
      <div class="pMessage"style="margin-top: 5px;">
        <div class="btn btn-md btn-primary btn-shadow col-sm-6"  role="button">私信问问</div>
        <div class="btn btn-md btn-primary btn-shadow col-sm-5 col-md-offset-1" role="button" >已关注</div>
      </div>
    </div>

    <div class="col-md-2" style="margin-left: -20px;">
      <div style="margin-top: 8px;"> <a href="#"><span style="font-weight: bolder">已捐钱</span><span>10000</span></a></div>
      <div style="margin-top: 8px;"><a href="#"> <span style="font-weight: bolder">粉丝</span><span>1002</span></a> </div>
      <div style="margin-top: 8px; "><a href="#"> <span style="font-weight: bolder">关注</span><span>10030</span></a></div>
      <div style="margin-top: 8px;"> <a href="#"><span style="font-weight: bolder">来访</span><span>1200</span></a></div>
    </div>

    <div  class="col-sm-1" style="border-right:1px solid #000;height:178px;margin-left: -70px;"> </div>


    <div class="col-md-1"style="margin-top: 50px;">
      <span style="font-size: 19px;font-weight: bolder">给点爱</span>
    </div>
    <div class="col-md-6">
      <div style="margin-top: 6px;"><span style="font-size: 20px;">日期:</span>2015-01-12到2015-03-12

      </div>
      <div style="margin-top: 6px;"><span style="font-size: 20px;">目标金额 :</span>10万</div>
      <div style="margin-top: 6px;"><span style="font-size: 20px;">发起社团:</span>北京大学爱心社</div>
      <div style="margin-top: 6px;">
        <span style="font-size: 20px;" >情况简介:</span><p>啊啊啊 这个是什么 忘记了
        <a href="http://user.qzone.qq.com/1799920759/blog/1419260568">www </a></p>

      </div>
    </div>
  </div>

  <div class="row" style="height: 50px;background-color: #fafafa;line-height: 50px;">
    <div class="col-md-2" style="font-size: 20px;font-weight: bolder">推文</div>
    <div class="col-md-2" style="font-size: 20px;font-weight: bolder">相册</div>
    <div class="col-md-2"style="font-size: 20px;font-weight: bolder">账户</div>
    <div class="col-md-2"style="font-size: 20px;font-weight: bolder">留言板</div>
    <div class="col-md-2"style="font-size: 20px;font-weight: bolder">其它</div>
    <div class="col-md-2"style="font-size: 20px;font-weight: bolder">设置</div>
  </div>

  <div class="row">
    <div class="col-md-2" style="border-right:1px solid #FDFFEA;height:200px;">
      <ul class="list-group">
        <li class="list-group-item list-group-item-success">原创</li>
        <li class="list-group-item list-group-item-info">转载</li>
        <li class="list-group-item list-group-item-warning">收藏</li>
        <li class="list-group-item list-group-item-danger">默认</li>
      </ul>



    </div>
    <div class="col-md-10" style="background-color: #ffffff">
      <div class="row">
        <div class="col-md-2">
          <img  style="width:100px;height:103px;" src="../image/touxiang.jpg"/>
        </div>
        <div class="col-md-10" style="border-style: 1px solid #000;margin-left: -30px;background-color: #ffffff">
          <div><a>史上第一最最搞</a></div>
          <div>
            <p>
              爱犬不能进商场怎么办？国外新增了贴心的“停狗位”服务，特别设置一个安全专区，用人工草皮铺成，还提供饮水，
              让主人可以将狗狗暂时寄放在这边，就不用委屈它们待在闷热的车子里面等了！！！创意太赞
            </p>
          </div>

          <div style="background-color: #efeeec">
            <div class="zhuanzai" style="font-size: 12px;margin-left: 20px;">
              <div><a>关注我不后悔</a></div>
              <div>
                <p>“爱鲜蜂”第一次下单返券，花了1元钱买了1盒芒果，3只装，1小时送货到门，
                  棒棒哒！办公室小伙伴开始疯抢了，我芒果过敏，闻都不能闻，现在躲到楼下来发朋友圈了，他们告诉我好甜好香好好次
                </p>
              </div>
              <div style="margin-left: -15px;">
                <div class="col-sm-1">收藏</div>
                <div class="col-sm-1">转发</div>
                <div class="col-sm-1">评论</div>
                <div class="col-sm-2">给点爱</div>
              </div>
              <br/>
              <div style="font-size:12px;height:20px;line-height:20px;margin-left: 0px;">11分钟前</div>
            </div>
            <div>
              <div style="height:40px;line-height:40px;">16分钟前</div>
              <div style="height:40px;line-height:40px;border-top:1px solid #f7ecb5;height: 35px;background-color:#b2dba1">
                <div class="col-md-3">收藏<span>|</span></div>
                <div class="col-md-3">转发<span>|</span></div>
                <div class="col-md-3">评论<span>|</span></div>
                <div class="col-md-3">给点爱<span>|</span></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div><!--container-->

    <script src="http://code.jquery.com/jquery.js"></script>
</body>
</html>