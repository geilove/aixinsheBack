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
<body style="background-color: #019875">

<div class="container" >
        <div class="row">
            <div class="col-lg-12 col-lg-offset-8">
                <img src="../../../images/cloud_s.png">
                <img src="../../../images/cloud_m.png">
            </div>

        </div>

           <div class="row" >
                    <div class="col-lg-4 col-md-offset-2" style="height:370px;margin-top: 10px;border-right-style:solid; border-width:1px; border-color:0xFDFFEA;background-color:#f2f2f2;">

                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-md-6 " style="margin-left: 60px;margin-top: 20px;">ç»ç¹ç±ï¼ä¸èµ·æ¸©æä¸çï¼</label>

                            </div>
                            <div class="form-group"style="margin-top: 30px;">
                                <label for="inputEmail3" class="col-sm-2 control-label">é®ä»¶</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">å¯ç </label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                                </div>
                            </div>
                              <div class="form-group">
                                <div class=" col-md-4">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> æ®éç¨æ·
                                        </label>
                                    </div>
                                </div>


                                <div class=" col-md-4">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> çç£ç¨æ·
                                        </label>
                                    </div>
                                </div>

                                <div class="col-sm-offset-8 col-md-4" style="margin-top: -30px;">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> ç¤¾å¢ç¨æ·
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">æ³¨&nbsp;&nbsp;&nbsp;&nbsp; å</button>
                                </div>
                            </div>
                        </form>


                     </div>
               <!--ä»¥ä¸æ¯å³ä¾§é¨å-->
                  <div class="col-lg-3" style="height:370px;background-color:#f2f2f2;margin-top: 10px;border-left-style:solid; border-width:1px; border-color:#000;">
                      <div style="margin-top: 100px;"> å·²æè´¦å·ï¼</div>
                   </div>
      </div>
</div>
</body>
</html>