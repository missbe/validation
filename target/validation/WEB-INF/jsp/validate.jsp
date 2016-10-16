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
<meta charset="utf-8" />
<title>Missbe-Validate</title>
<base href="${basePath }" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link href="${basePath }static/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${basePath }static/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="${basePath }static/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->


<!-- ace styles -->

<link rel="stylesheet" href="${basePath }static/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${basePath }static/assets/css/ace-rtl.min.css" />
<link rel="stylesheet"
	href="${basePath }static/assets/css/ace-skins.min.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${basePath }static/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="${basePath }static/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="${basePath }static/assets/js/html5shiv.js"></script>
		<script src="${basePath }static/assets/js/respond.min.js"></script>
		<![endif]-->
<style>
th,td{
  font-size:14px;
  text-align:center;
}
th{
  font-size:18px;
}
</style>
<link rel="shortcut icon" href="${basePath }static/img/favicon.ico">
</head>
<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> 签到后台查阅
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue">
					<a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> 
						<img class="nav-user-photo"
							src="${basePath }static/assets/avatars/user.jpg" alt="Jason's Photo" /> 
							<span class="user-info"> <small>欢迎登录！</small>
							Admin </span> <i class="icon-caret-down"></i>
					</a>
				    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
					<li><a href="logout.action"> <i class="icon-off"></i> 退出</a></li>
					</ul>
				  </li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<ul class="nav nav-list">
					<li class="active"><a href="index.action"> <i
							class="icon-dashboard"></i> <span class="menu-text"> 控制台 </span>
					</a></li>

					<li><a href="list.action?validate=in"> <i class="icon-list"></i> <span
							class="menu-text"> 已签到列表 </span>
					</a></li>
					<li><a href="list.action?validate=out"> <i class="icon-list"></i> <span
							class="menu-text"> 未签到列表 </span>
					</a></li>
				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i></li>
					</ul>
					<!-- .breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- #nav-search -->
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="alert alert-block alert-success">
								<button type="button" class="close" data-dismiss="alert">
									<i class="icon-remove"></i>
								</button>

								<i class="icon-ok green"></i> 欢迎使用 <strong class="green">
									Ace后台管理系统 <small>(v1.2)</small>
								</strong> ,轻量级好用的后台管理系统模版.
							</div>
							<div class="hr hr32 hr-dotted"></div>
							<div class="container" style="margin-top: 5px;">
								<div class="row clearfix">
									<div class="col-md-12 column">
										<div class="page-header">
											<h1 align="center">
												<small>------------</small>用户签到信息列表 <small>------------</small>
											</h1>
										</div>
										<table class="table table-hover table-bordered" >
											<thead>
												<tr>
													<th>${requestScope.message } </th>
													<c:if test="${null != requestScope.title }">
														<c:forEach var="item" items="${requestScope.title }"
															step="1">
															<th class="text-center text-success">${item  }</th>
														</c:forEach>
													</c:if>
												</tr>
											</thead>
											<tbody>
												<c:if test="${null != requestScope.list }">
													<c:forEach var="items" items="${requestScope.list }"
														step="1" varStatus="var">
														<tr class="info">
															<td>${var.index}</td>
															<c:forEach var="item" items="${items }" step="1">
																<td class="text-center text-success">${item  }</td>
															</c:forEach>
														</tr>
													</c:forEach>
												</c:if>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->


		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->


	<!--[if !IE]> -->

	<script type="text/javascript">
			window.jQuery || document.write("<script src='${basePath }static/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${basePath }static/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${basePath }static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
	<script src="${basePath }static/assets/js/bootstrap.min.js"></script>
	<script src="${basePath }static/assets/js/typeahead-bs2.min.js"></script>
	<script src="${basePath }static/assets/js/ace-elements.min.js"></script>
	<script src="${basePath }static/assets/js/ace.min.js"></script>

</body>
</html>

