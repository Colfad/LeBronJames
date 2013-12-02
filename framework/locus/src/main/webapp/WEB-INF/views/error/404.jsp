<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>404 :( 页面不存在</title>
    <meta name="description" content="404 Error Page">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- basic styles -->
    <link href="/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/assets/css/bootstrap-responsive.min.css" rel="stylesheet">

    <link rel="stylesheet" href="/resources/assets/css/font-awesome.min.css">
    <!--[if IE 7]>
    <link rel="stylesheet" href="/resources/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->


    <!-- page specific plugin styles -->


    <!-- ace styles -->
    <link rel="stylesheet" href="/resources/assets/css/ace.min.css">
    <link rel="stylesheet" href="/resources/assets/css/ace-responsive.min.css">
    <link rel="stylesheet" href="/resources/assets/css/ace-skins.min.css">
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="/resources/assets/css/ace-ie.min.css" />
    <![endif]-->

</head>

<body>

<%@include file="../../common/header.jsp"%>

<div class="container-fluid" id="main-container">
<a href="#" id="menu-toggler"><span></span></a><!-- menu toggler -->
<%@include file="../../common/left.jsp"%>

<div id="main-content" class="clearfix">

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="#">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">Error 404</li>
        </ul><!--.breadcrumb-->

        <div id="nav-search">
            <form class="form-search">
									<span class="input-icon">
										<input autocomplete="off" id="nav-search-input" type="text" class="input-small search-query" placeholder="Search ...">
										<i id="nav-search-icon" class="icon-search"></i>
									</span>
            </form>
        </div><!--#nav-search-->
    </div><!--#breadcrumbs-->



    <div id="page-content" class="clearfix">


        <div class="row-fluid">
            <!-- PAGE CONTENT BEGINS HERE -->

            <div class="error-container">

                <div class="well">
                    <h1 class="grey lighter smaller">
                        <span class="blue bigger-125"><i class="icon-sitemap"></i> 404</span> 页面没有找到
                    </h1>
                    <hr>
                    <h3 class="lighter smaller">您所访问的URL不存在，请核实之后再访问相应的页面!</h3>

                    <div>
                        <form class="form-search">
			<span class="input-icon">
				<i class="icon-search"></i>
				<input type="text" class="input-medium search-query" placeholder="进行搜索吧...">
			</span>
                            <button class="btn btn-small" onclick="return false;">Go!</button>
                        </form>

                        <div class="space"></div>

                        <h4 class="smaller">尝试下面的方法来解决问题:</h4>
                        <ul class="unstyled spaced inline bigger-110">
                            <li><i class="icon-hand-right blue"></i> 重新检查您输入url拼写是否正确.</li>
                            <li><i class="icon-hand-right blue"></i> 重新阅读用户手册，查看是否是操作不当.</li>
                            <li><i class="icon-hand-right blue"></i> 联系管理员.</li>
                        </ul>
                    </div>

                    <hr>
                    <div class="space"></div>

                    <div class="row-fluid">
                        <div class="center">
                            <a onclick="history.back()" class="btn btn-grey"><i class="icon-arrow-left"></i> 返回</a>
                            <a href="${ctx}/" class="btn btn-primary"><i class="icon-dashboard"></i> 首页</a>
                        </div>
                    </div>
                </div>

            </div>


            <!-- PAGE CONTENT ENDS HERE -->
        </div><!--/row-->

    </div><!--/#page-content-->


</div><!-- #main-content -->


</div><!--/.fluid-container#main-container-->

<!-- basic scripts -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/resources/assets/js/jquery-1.9.1.min.js'>\x3C/script>");
</script>

<script src="/resources/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->


<!-- ace scripts -->
<script src="/resources/assets/js/ace-elements.min.js"></script>
<script src="/resources/assets/js/ace.min.js"></script>


<!-- inline scripts related to this page -->

<script type="text/javascript">

    $(function() {



    })

</script>



</body></html>