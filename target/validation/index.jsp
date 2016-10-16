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
<html lang="en">
<head>
<meta charset="utf-8">
<title>Missbe-Validate</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Loading Bootstrap -->
<link
	href="${basePath }static/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Loading Flat UI -->
<link href="${basePath }static/dist/css/flat-ui.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="dist/js/vendor/html5shiv.js"></script>
      <script src="dist/js/vendor/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="${basePath }static/img/favicon.ico">
</head>
<body>
	<div class="container jumbotron">
		<!--上面的说明文字--->
		<div class="row clearfix">
			<div class="col-xs-11 column col-xs-offset-1">				
					<h2>签到说明</h2>
					<p>---你可以选择手机号码或者学号进行扫码签到---	</p>
					<p>Demo测试数据：123456</p>				
			</div>
		</div>
		<!--进行参数选择，手机号码或者学号验证--->
		<div class="col-xs-11 col-xs-offset-1">
			<div class="row">
				<div class="col-xs-11">
					<select id="switchParam" name="switchParam" data-toggle="select"
						class="form-control select select-primary mrs mbm">
						<option value="phone">手机号码验证</option>
						<option value="id">学生学号验证</option>
					</select>
				</div>
			</div>
		</div>
		<!--设置两者之间高度矩离-->
		<div class="col-xs-12" style="margin-top: 20px;"></div>
		<!--输入框的DIV-->
		<div class="col-xs-11 col-xs-offset-1">
			<div class="row">
				<div class="col-xs-11 form-group">				   
					<input class="form-control typeahead-only" type="text"
						id="inputParam" /> <span
						class="form-control-feedback fui-radio-unchecked"></span>				   
				</div>
				<div class="col-xs-11">
					<a id="validate" class="btn btn-block btn-embossed btn-primary">Validate</a>
				</div>
			</div>
		</div>
	</div>
		<!-- /.container -->

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${basePath }static/dist/js/vendor/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${basePath }static/dist/js/flat-ui.min.js"></script>

		<script src="${basePath }static/assets/js/application.js"></script>
		<script>
       $("#validate").click(function(){
    	   var swicth=$("#switchParam").val();
    	   var input=$("#inputParam").val();
    	   console.log(swicth+":"+input);    	   
    	   window.location.href="validate.action?switchParam="+swicth+"&inputParam="+input;
       });
    </script>
</body>
</html>