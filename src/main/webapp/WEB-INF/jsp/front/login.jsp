

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
  String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="<%=path %>/resources/bootstrap3/css/bootstrap.css"></link>
<script	src="<%=path %>/resources/jquery/jquery-1.11.1.js"type="text/javascript"></script>
<script src="<%=path %>/resources/bootstrap3/js/bootstrap.js"type="text/javascript"></script>
</head>
<body style="background-color: #019875">

<div class="container" >
    <div class="row">
        <div class="col-lg-12 col-lg-offset-8">
            <img src="<%=path %>/resources/images/cloud_s.png">
            <img src="<%=path %>/resources/images/cloud_m.png">
        </div>
    </div>

    <div class="row" >
        <div class="col-lg-4 col-md-offset-2" style="height:370px;margin-top: 10px;border-right-style:solid; border-width:1px; border-color:0xFDFFEA;background-color:#f2f2f2;">

            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-md-6 " style="margin-left: 60px;margin-top: 20px;">给点爱，一起温暖世界！</label>
                </div>
                <div class="form-group"style="margin-top: 30px;">
                    <label for="inputEmail3" class="col-sm-2 control-label">邮件</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class=" col-md-4">
                        <div class="checkbox">
                            <label> <input type="checkbox"> 记住密码</label>
                        </div>
                    </div>

                    <div class=" col-md-4">
                        <div class="checkbox">
                            <label>	 忘记密码？ </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">注&nbsp;&nbsp;&nbsp;&nbsp; 册</button>
                    </div>
                </div>
            </form>
        </div>
        <!--以下是右侧部分-->
        <div class="col-lg-3" style="height:370px;background-color:#f2f2f2;margin-top: 10px;border-left-style:solid; border-width:1px; border-color:#000;">
            <div style="margin-top: 100px;"> 已有账号？</div>
        </div>
    </div>
</div>
</body>
</html>



























