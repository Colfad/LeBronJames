<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%response.setStatus(200);%>

<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Throwable) request.getAttribute("javax.servlet.error.exception");

	//记录日志
	Logger logger = LoggerFactory.getLogger("500.jsp");
	logger.error(ex.getMessage(), ex);
%>

<!DOCTYPE html>
<html>
<head>
	<title>500 - 系统内部错误</title>

    <!-- basic styles -->
    <link href="${ctx}/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/resources/assets/css/bootstrap-responsive.min.css" rel="stylesheet">

    <link rel="stylesheet" href="${ctx}/resources/assets/css/font-awesome.min.css">
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/resources/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->


    <!-- page specific plugin styles -->


    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace.min.css">
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
            <li class="active">500页面错误</li>
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
                        <span class="blue bigger-125"><i class="icon-random"></i> 500</span> 系统发生内部错误
                    </h1>
                    <hr>
                    <h3 class="lighter smaller"> 但是我们正在 <i class="icon-wrench icon-animated-wrench bigger-125"></i> 解决它! </h3>

                    <div class="space"></div>
                    <div>

                        <h4 class="lighter smaller">但是在我们解决之前您可以尝试下面的方法:</h4>
                        <ul class="unstyled spaced inline bigger-110">
                            <li><i class="icon-hand-right blue"></i> 读用户手册，查看是不是自己的操作不当.</li>
                            <li><i class="icon-hand-right blue"></i> 给我们提供更多的信息，是不是经常在某种情况下发生这种错。向我们提交!</li>
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
    window.jQuery || document.write("<script src='${ctx}/resources/assets/js/jquery-1.9.1.min.js'>\x3C/script>");
</script>

<script src="${ctx}/resources/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->


<!-- ace scripts -->
<script src="${ctx}/resources/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/resources/assets/js/ace.min.js"></script>


<!-- inline scripts related to this page -->

<script type="text/javascript">

    $(function() {



    })

</script>
</body>
</html>
