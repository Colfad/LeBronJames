<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>文件上传测试</title>

    <!-- basic styles -->
    <link href="${ctx}/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/resources/assets/css/bootstrap-responsive.min.css" rel="stylesheet">

    <link rel="stylesheet" href="${ctx}/resources/assets/css/font-awesome.min.css">
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/resources/assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace.min.css">
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace-responsive.min.css">
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace-skins.min.css">
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace-ie.min.css"/>
    <![endif]-->
</head>
<body>
<div id="main-content" class="clearfix">
    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span>
            </li>
            <li class="active">文件上传测试</li>
        </ul>
        <!--.breadcrumb-->

        <div id="nav-search">
            <form class="form-search">
            <span class="input-icon">
                <input autocomplete="off" id="nav-search-input" type="text" class="input-small search-query"
                       placeholder="查询...">
                <i id="nav-search-icon" class="icon-search"></i>
            </span>
            </form>
        </div>
        <!--#nav-search-->
    </div>

    <div id="page-content" class="clearfix">
        <div class="page-header position-relative">
            <h1>文件上传测试
                <small><i class="icon-double-angle-right"></i> 对整体阿里云服务上传的测试工作</small>
            </h1>
        </div>
        <!--/page-header-->

        <form method="post" enctype="multipart/form-data" action="${ctx}/image/file/upload">

            <div class="ace-file-input ace-file-multiple">
                <input multiple="" name="file" type="file" id="id-input-file-3">
            </div>

            <div class="form-actions">
                <button class="btn btn-info" type="submit">
                    <i class="icon-ok">
                    </i>
                    上传
                </button>
            </div>
        </form>

    </div>

</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${ctx}/resources/assets/js/jquery-1.9.1.min.js'>\x3C/script>");
</script>

<script src="${ctx}/resources/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lt IE 9]>
<script type="text/javascript" src="${ctx}/resources/assets/js/excanvas.min.js"></script>
<![endif]-->

<script type="text/javascript" src="${ctx}/resources/assets/js/jquery-ui-1.10.2.custom.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/assets/js/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/assets/js/chosen.jquery.min.js"></script>

<!-- ace scripts -->
<script src="${ctx}/resources/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/resources/assets/js/ace.min.js"></script>

<script type="text/javascript">

    $(function () {

        $('#id-input-file-3').ace_file_input({
            style: 'well',
            btn_choose: '点击添加你想要上传的图片',
            btn_change: null,
            no_icon: 'icon-cloud-upload',
            droppable: true,
            onchange: null,
            thumbnail: 'small',
            before_change: function (files, dropped) {
                return true;
            }

        }).on('change', function () {
        });

    });

</script>
</body>
</html>