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
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span>é¦é¡µ</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" style="font-weight:bolder; font-size: 18px;">
                <li class="active"  style="margin-left:10px;"><a href="#"><span class="glyphicon glyphicon-leaf"></span>é¡¹ç®</a></li>

                <li class="dropdown" style="margin-left:10px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-volume-up"></span>æ¶æ¯</a>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="æ¥æ¾ä½ æå´è¶£çè¯é¢ äººç©" style="width:200px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-danger">éæ©</button>
                        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">ç¨æ·</a></li>
                            <li><a href="#">æ¨æ</a></li>
                            <li><a href="#">ç¤¾å¢</a></li>
                            <li class="divider"></li>
                            <li><a href="#">é¡¹ç®</a></li>
                        </ul>
                    </div>
                </div>
                <button type="submit" class="btn btn-default">æ£ç´¢</button>
            </form>
            <ul class="nav navbar-nav " style="font-weight: bolder;margin-left: 10px;">
                <li style="margin-left:10px;"><a href="#"><span class="glyphicon glyphicon-camera"></span>åºé</a></li>

                <li class="dropdown" style="margin-left: 10px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-bell"></span>ç±å¿ç¤¾</a>
                </li>
                <li class="dropdown" style="margin-left:10px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-eye-open"></span>çç£å¢</a>
                </li>

                <li class="dropdown" style="margin-left: 20px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user" style="margin-right:0px;"></span>è¾æµ·æ¶</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container" style="margin-top: -8px;">
            <div class="row" style="margin-top: -8px;height: 59px;background-color: #efeeec">
                <div class="col-lg-1  col-md-offset-5" >
                    <div style="font-weight: bolder;font-size: 17px"> è¾æµ·æ¶ </div><!--è¿éæ¾ç¤ºç¨æ·å-->

                </div>

            </div>
            <div class="row" style="background-color: #ffffff;height: 220px;">
                <div class="col-md-2">
                    <div style="padding: 3px;"> <img src="../../../images/touxiang.jpg/" style="margin-top:-20px; "></div>
                    <div class="pMessage"style="margin-top: 5px;">
                        <div class="btn btn-md btn-primary btn-shadow col-sm-6"  role="button">ç§ä¿¡é®é®</div>
                        <div class="btn btn-md btn-primary btn-shadow col-sm-5 col-md-offset-1" role="button" >å·²å³æ³¨</div> <!--è¿éæ¾ç¤ºçæ¯å³æ³¨ç¶æï¼å·²å³æ³¨ï¼å³æ³¨ä»-->
                    </div>
                </div>

                <div class="col-md-2" style="margin-left: -20px;">
                    <div style="margin-top: 8px;"> <a href="#"><span style="font-weight: bolder">å·²æé±:</span><span>10000</span></a></div>
                    <div style="margin-top: 8px;"><a href="#"> <span style="font-weight: bolder">ç²ä¸:</span><span>1002</span></a> </div>
                    <div style="margin-top: 8px; "><a href="#"> <span style="font-weight: bolder">å³æ³¨:</span><span>10030</span></a></div>
                    <div style="margin-top: 8px;"> <a href="#"><span style="font-weight: bolder">æ¥è®¿:</span><span>1200</span></a></div>
                </div>
                <!-- è¿ä¸ªæ¯æ°çº¿æ¡-->
                <div  class="col-sm-1" style="border-right:1px solid #000;height:178px;margin-left: -70px;"> </div>
                <!--è¿ä¸ªæ¯å·¦å³è¾¹ç-->

                <div class="col-md-1"style="margin-top: 50px;">
                    <span style="font-size: 19px;font-weight: bolder">ç»ç¹ç±</span>
                </div>
                <div class="col-md-6">
                    <div style="margin-top: 6px;"><span style="font-size: 16px;">ç¶æ:</span>è¿è¡ä¸­</div>
                    <div style="margin-top: 6px;"><span style="font-size: 16px;">æ¥æ :</span>2015-01-12å°2015-03-12

                    </div>
                    <div style="margin-top: 6px;"><span style="font-size: 16px;">ç®æ éé¢ :</span>10ä¸</div>
                    <div style="margin-top: 6px;"><span style="font-size: 16px;">å®¡æ ¸å¢é :</span>åäº¬å¤§å­¦ç±å¿ç¤¾</div>
                    <div style="margin-top: 6px;">
                        <span style="font-size: 16px;" >æåµç®ä»:</span><p>å¼ ä¸ï¼ç·ï¼å±±ä¸å¾·å·äººï¼èº«ä»½è¯å·ï¼199955588514145415145151ï¼èº«æ£å¿èçï¼å®¶å¢è´«å¯ï¼å®å¨è´æä¸èµ·ï¼æ¿å¥½å¿äººå¸®å¿ä¸ä¸ï¼ä¸èææ¿</p>
                    </div>

                </div>
            <!--ä»¥ä¸divæ¯æä¸é¢çä¸çº§æ é¢æ -->
            <div class="row" style="height: 80px;background-color: #fafafa;line-height: 80px;">
                <div class="col-md-2" style="font-size: 20px;font-weight: bolder">æ¨æ</div>
                <div class="col-md-2" style="font-size: 20px;font-weight: bolder">ç¸å</div>
                <div class="col-md-2"style="font-size: 20px;font-weight: bolder">è´¦æ·</div>
                <div class="col-md-2"style="font-size: 20px;font-weight: bolder">çè¨æ¿</div>
                <div class="col-md-2"style="font-size: 20px;font-weight: bolder">å¶å®</div>
                <div class="col-md-2"style="font-size: 20px;font-weight: bolder">è®¾ç½®</div>
            </div>
    <!--ä»¥ä¸divæ¯æ ¹æ®ç¹å»ä»¥ä¸æ¨æãç¸åãè´¦æ·ãè®¾ç½®å¯å¨ææ´æ°çåºå,å¶ä¸­å·¦ä¾§æ¯ä¸ªäºçº§æ é¢æ -->
        <div class="row"><!--è¿éæ ¹æ®ä¸çº§æ é¢æ æ¾ç¤ºä¸åçç®å½-->
                <div class="col-md-2" style="border-right:1px solid #FDFFEA;height:200px;margin-left: -15px;">
                     <ul class="list-group">
                           <li class="list-group-item list-group-item-success">é»è®¤</li>
                           <li class="list-group-item list-group-item-info">å¬å¼</li>
                           <li class="list-group-item list-group-item-warning">ç§äºº</li>
                       </ul>
                </div>
                <div class="col-md-10" style="background-color: #ffffff">
                    <div class="row">
                        <div class="col-md-4">
                            <img   src="../../../images/touxiang.jpg"/>
                        </div>

                        <div class="col-md-4">
                            <img   src="../../../images/touxiang.jpg"/>
                        </div>

                        <div class="col-md-4">
                            <img  src="../../../images/touxiang.jpg"/>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-4">
                            <img  style="width: 200px;height: 300px;"  src="../../../images/55.jpg"/>
                        </div>

                        <div class="col-md-4">
                            <img  style="width: 200px;height: 300px;" src="../../../images/55.jpg"/>
                        </div>

                        <div class="col-md-4" >
                            <img  style="width: 200px;height: 300px;" src="../../../images/55.jpg"/>
                        </div>
                    </div>

                </div>
          </div>
  </div><!--container-->



  <script src="http://code.jquery.com/jquery.js"></script>
</body>
</html>