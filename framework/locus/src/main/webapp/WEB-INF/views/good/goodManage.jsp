<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>商品管理</title>

    <!-- basic styles -->
    <link href="${ctx}/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/resources/assets/css/bootstrap-responsive.min.css" rel="stylesheet">

    <link rel="stylesheet" href="${ctx}/resources/assets/css/font-awesome.min.css">
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/resources/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->


    <!-- page specific plugin styles -->


    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace.css">
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace-responsive.min.css">
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace-skins.min.css">
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace-ie.min.css" />
    <![endif]-->
</head>
<body>

<div id="main-content" class="clearfix">
    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">商品管理</li>
        </ul><!--.breadcrumb-->

        <div id="nav-search">
            <form class="form-search">
            <span class="input-icon">
                <input autocomplete="off" id="nav-search-input" type="text" class="input-small search-query" placeholder="查询...">
                <i id="nav-search-icon" class="icon-search"></i>
            </span>
            </form>
        </div><!--#nav-search-->
    </div>
    <div id="page-content" class="clearfix">
        <div class="page-header position-relative">
            <h1>商品管理 <small><i class="icon-double-angle-right"></i>对商品进行管理工作</small></h1>
        </div><!--/page-header-->

    </div>
</div>


<!-- basic scripts -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${ctx}/resources/assets/js/jquery-1.9.1.min.js'>\x3C/script>");
</script>

<script src="${ctx}/resources/assets/js/bootstrap.min.js"></script>
<!-- ace scripts -->
<script src="${ctx}/resources/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/resources/assets/js/ace.min.js"></script>
</body>
</html>