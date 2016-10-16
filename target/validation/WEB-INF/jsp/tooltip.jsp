<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("Login:" + basePath);
%>
<c:set var="basePath" value="<%=basePath%>" />
<!DOCTYPE html >
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Missbe-权限</title>

  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="${basePath }static/dist/img/favicon.ico">
</head>
<body>
<div class="container">
	<div class="row clearfix" style="margin-top:10%;">
		<div class="col-md-3 col-md-offset-2 ">
			<img alt="加载中ing...." src="${basePath }/static/assets/img/message.jpg" />
		</div>
		<div class="col-md-6 " style="margin-top:7%;">
			<dl>
				<dt>	
				<span style="font-size:32px">				
				<p class="text-info"><b>提示信息</b></p>	
				</span>
				</dt>
				<dd>
					<span style="font-size:20px" >
					<p class="text-warning"><b>Message:${requestScope.message  }</b></p>
					</span>
				</dd>
			</dl>
		</div>
	</div>
</div>
</body>
</html>