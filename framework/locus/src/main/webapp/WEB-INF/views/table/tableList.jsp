<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>表管理</title>
</head>

<body>

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">表管理</li>
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
            <h1>表管理 <small><i class="icon-double-angle-right"></i> 管理除基本表以外的其他模块的表</small></h1>
        </div><!--/page-header-->

        <c:if test="${message != null}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            ${message}
        </div>
        </c:if>
        <form class="form-search" action="#">
            <div class="control-group">
                <label class="control-label">数据库表名:</label>
                <div class="controls">
                    <input type="text" id="search_table_name" name="search_LIKE_tableName" placeholder="数据库表名" value="${param.search_LIKE_tableName}" />
                    <button type="submit" class="btn btn-primary btn-small" id="search_btn">查询</button>
                </div>
            </div>
        </form>
        <div class="row">
            <div class="span6">
                <div class="row">
                    <div class="span2">
                        <shiro:hasPermission name="table:add">
                        <a href="${ctx}/table/create" id="create_new" class="btn btn-success btn-xzweb">新增数据</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="table:delete">
                        <a id="delete_selected" class="btn btn-danger btn-xzweb">删除选中</a>
                        </shiro:hasPermission>
                    </div>
                </div>
            </div>
            <div class="span3 pull-right">
                <tags:sort />
            </div>
        </div>

        <br />
        <table id="contentTable" class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th class="center">
                    <label><input type="checkbox"><span class="lbl"></span></label>
                </th>
                <th>数据库表名</th>
                <th>用途描述</th>
                <th><i class="icon-time hidden-phone"></i> 创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tables.content}" var="tableVar">
                <tr>
                    <td class="center">
                        <label><input type="checkbox"><span class="lbl"></span></label>
                    </td>
                    <td>${tableVar.tableName}</td>
                    <td>${tableVar.useFor}</td>
                    <td><fmt:formatDate value="${tableVar.createDate}" pattern="yyyy年MM月dd日 HH时mm分ss秒" /></td>
                    <td>
                        <div class="inline position-relative">
                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"><i class="icon-cog icon-only"></i></button>
                            <ul class="dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close">
                                <shiro:hasPermission name="table:update">
                                <li><a href="${ctx}/table/update/${tableVar.id}" class="tooltip-success" data-rel="tooltip" title="" data-placement="left" data-original-title="编辑"><span class="green"><i class="icon-edit"></i></span></a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="table:delete">
                                <li><a href="${ctx}/table/delete/${tableVar.id}" onmousedown="confirmDelete(this);" class="tooltip-error" data-rel="tooltip" title="" data-placement="left" data-original-title="删除"><span class="red"><i class="icon-trash"></i></span> </a></li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="table:column">
                                <li><a href="${ctx}/table/manageColumn/${tableVar.id}" class="tooltip-success" data-rel="tooltip" title="" data-placement="left" data-original-title="配置列"><span class="green"><i class="icon-book"></i></span></a></li>
                                </shiro:hasPermission>
                            </ul>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <tags:pagination page="${tables}" paginationSize="5" />
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



    <script type="text/javascript">
        $(function() {

            $('table th input:checkbox').on('click' , function(){
                var that = this;
                $(this).closest('table').find('tr > td:first-child input:checkbox')
                        .each(function(){
                            this.checked = that.checked;
                            $(this).closest('tr').toggleClass('selected');
                        });

            });

            $('[data-rel=tooltip]').tooltip();
        });

        function confirmDelete(obj) {
            bootbox.confirm("确定要删除此条数据?删除此条数据将不可以再找回.", "取消", "确定", function(result) {
               if (!result) {
                   return;
               }
               window.location.href = obj.getAttribute("href");
            });
        }

    </script>
</body>
</html>