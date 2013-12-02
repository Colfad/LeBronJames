<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>列名添加</title>

</head>
<body>

<div id="breadcrumbs">
    <ul class="breadcrumb">
        <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
        <li class="active">列添加</li>
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
    <h1>表列管理 <small><i class="icon-double-angle-right"></i>表列添加操作</small></h1>
</div><!--/page-header-->
<c:if test="${message != null}">
    <div class="alert alert-success">
        <button type="button" class="close" data-dismiss="alert">×</button>
            ${message}
    </div>
</c:if>
<form id="inputForm" action="${ctx}/table/manageColumn/" method="post" class="form-horizontal">
<input type="hidden" name="table.id" value="${tableId}"/>

    <fieldset>
        <div class="control-group">
            <label for="column_name" class="control-label">列名:</label>
            <div class="controls">
                <input type="text" id="column_name" name="columnName" class="input-large required" minlength="3"/>
            </div>
        </div>
        <div class="control-group" style="margin-left: 101px">
            字段类型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <select id="column_type" multiple="multiple" name="columnType">
                <option value="varchar">字符串</option>
                <option value="int">整型数字</option>
                <option value="datetime">日期</option>
                <option value="pic">图片</option>
            </select>
        </div>
        <div class="control-group">
            <label for="column_length" class="control-label">列长度:</label>
            <div class="controls">
                <input type="text" id="column_length" name="columnLength" class="input-large required" minlength="3"/>
            </div>
        </div>
        <div class="control-group">
            <label for="show_name" class="control-label">页面显示名:</label>
            <div class="controls">
                <input type="text" id="show_name" name="showName" class="input-large required" minlength="3"/>
            </div>
        </div>
        <div class="control-group">
            <label for="grid_show" class="control-label">是否在表格中显示:</label>
            <div class="controls">
                <input type="text" id="grid_show" name="gridShow" class="input-large required" minlength="3"/>
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

    <table id="contentTable" class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <!--
            <th class="center">
                <label><input type="checkbox"><span class="lbl"></span></label>
            </th>
            -->
            <th>列名</th>
            <th>列类型</th>
            <th>列长度</th>
            <th>显示名称</th>
            <th>是否在表格中显示</th>
            <th><i class="icon-time hidden-phone"></i> 创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${columnVars}" var="columnVar">
            <tr>
                <!--
                <td class="center">
                    <label><input type="checkbox"><span class="lbl"></span></label>
                </td>
                -->
                <td>${columnVar.columnName}</td>
                <td>${columnVar.columnType}</td>
                <td>${columnVar.columnLength}</td>
                <td>${columnVar.showName}</td>
                <td>
                    <c:if test="${columnVar.gridShow == true}">页面显示</c:if>
                    <c:if test="${columnVar.gridShow == false}">页面不显示</c:if>
                </td>
                <td><fmt:formatDate value="${columnVar.createDate}" pattern="yyyy年MM月dd日 HH时mm分ss秒" /></td>
                <td>
                    <div class="inline position-relative">
                        <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"><i class="icon-cog icon-only"></i></button>
                        <ul class="dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close">
                            <shiro:hasPermission name="column:update">
                                <li><a href="${ctx}/column/update/${column.id}" class="tooltip-success" data-rel="tooltip" title="" data-placement="left" data-original-title="编辑"><span class="green"><i class="icon-edit"></i></span></a></li>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="column:delete">
                                <li><a href="${ctx}/column/delete/${column.id}" onmousedown="confirmDelete(this);" class="tooltip-error" data-rel="tooltip" title="" data-placement="left" data-original-title="删除"><span class="red"><i class="icon-trash"></i></span> </a></li>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="column:update">
                                <li><a href="${ctx}/column/setPermission/${column.id}" class="tooltip-success" data-rel="tooltip" title="" data-placement="left" data-original-title="权限"><span class="green"><i class="icon-book"></i></span></a></li>
                            </shiro:hasPermission>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


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