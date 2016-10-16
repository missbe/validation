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
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Missbe-Login</title>
<meta name="description"
	content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version." />
<meta name="viewport"
	content="width=1000, initial-scale=1.0, maximum-scale=1.0">

<!-- Loading Bootstrap -->
<link
	href="${basePath }static/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Loading Flat UI -->
<link href="${basePath }static/dist/css/flat-ui.css" rel="stylesheet">
<link href="${basePath }static/assets/css/demo.css" rel="stylesheet">

<link rel="shortcut icon" href="${basePath }static/img/favicon.ico">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="dist/js/vendor/html5shiv.js"></script>
      <script src="dist/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">

		<section>
			<div class="login">
				<div class="login-screen">
					<div class="login-icon">
						<img src="${basePath }static/img/icons/png/Compas.png"
							alt="Welcome to Mail App" />
						<h4>
							Welcome to <small>Validate App</small>
						</h4>
					</div>

					<div class="login-form">
						<form id="myform" method="post">
							<div class="form-group">
								<input type="text" class="form-control login-field" value=""
									placeholder="Enter your name" id="login-name" name="username" />
								<label class="login-field-icon fui-user" for="login-name"></label>
							</div>

							<div class="form-group">
								<input type="password" class="form-control login-field" value=""
									placeholder="Password" id="login-pass" name="userpass" /> <label
									class="login-field-icon fui-lock" for="login-pass"></label>
							</div>
						</form>

						<a id="btn" class="btn btn-primary btn-lg btn-block" href="#">
							Log in</a> <a class="login-link" href="#">Lost your password?</a>
					</div>
				</div>
			</div>
		</section>
	</div>
	<script src="${basePath }static/dist/js/vendor/jquery.min.js"></script>
	<script src="${basePath }static/dist/js/vendor/video.js"></script>
	<script src="${basePath }static/dist/js/flat-ui.min.js"></script>
	<script src="${basePath }static/assets/js/application.js"></script>
	<script>
      $("#btn").click(function(){  
    	  var name=$("#login-name").val();
    	  var pass=$("#login-pass").val();
    	  console.log(name+":"+pass);  
	          
	       $("#myform").attr("action","admin.action");
	       $("#myform").submit();
	    });        
    </script>
</body>
</html>