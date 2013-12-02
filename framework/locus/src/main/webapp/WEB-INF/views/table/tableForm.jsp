<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>数据库表添加</title>
</head>
<body>

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">数据库表添加</li>
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
            <h1>数据库表添加 <small><i class="icon-double-angle-right"></i>对后台的数据库进行添加操作</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/table/${action}" method="post" class="form-horizontal">
            <input type="hidden" name="id" value="${tableVar.id}"/>
            <input type="hidden" name="oldName" value="${tableVar.tableName}" />
            <fieldset>
                <div class="control-group">
                    <label for="table_name" class="control-label">表名:</label>
                    <div class="controls">
                        <input type="text" id="table_name" name="tableName" value="${tableVar.tableName}" class="input-large required" minlength="3"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="useFor" class="control-label">用途:</label>
                    <div class="controls">
                        <input type="text" id="useFor" name="useFor" value="${tableVar.useFor}" class="input-large required" minlength="3"/>
                    </div>
                </div>
                <div class="form-actions">
                    <button class="btn btn-info" type="submit">
                        <i class="icon-ok">
                        </i>
                        提交
                    </button>
                    <button class="btn" type="reset">
                        <i class="icon-undo"></i>
                        重填
                    </button>
                    <button class="btn" type="button" onclick="history.back()">
                        <i class="icon-arrow-left"></i>
                        返回
                    </button>
                </div>
            </fieldset>
        </form>
    </div>

    <!-- basic scripts -->

    <!--[if !IE]> -->

    <script type="text/javascript">
        window.jQuery || document.write("<script src='${ctx}/resources/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
    </script>

    <!-- <![endif]-->

    <!--[if IE]>
    <script type="text/javascript">
        window.jQuery || document.write("<script src='${ctx}/resources/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
    </script>
    <![endif]-->

    <script type="text/javascript">
        if("ontouchend" in document) document.write("<script src='${ctx}/resources/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
    </script>
    <script src="${ctx}/resources/assets/js/bootstrap.min.js"></script>

    <!-- page specific plugin scripts -->

    <!-- ace scripts -->

    <script src="${ctx}/resources/assets/js/ace-elements.min.js"></script>
    <script src="${ctx}/resources/assets/js/ace.min.js"></script>

    <!-- inline scripts related to this page -->

</body>
</html>