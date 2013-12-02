<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>病患信息列表</title>
</head>

<body>

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">病患信息列表</li>
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
            <h1>病患信息管理 <small><i class="icon-double-angle-right"></i> 对病患信息进行基本的管理工作</small></h1>
        </div><!--/page-header-->

        <c:if test="${message != null}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            ${message}
        </div>
        </c:if>
        <form class="form-search" action="#">
            <div class="control-group">
                <label class="control-label">患者姓名:</label>
                <div class="controls">
                    <input type="text" id="search_patient_name" name="search_LIKE_patientName" placeholder="患者姓名" value="${param.search_LIKE_patientName}" />
                    <button type="submit" class="btn btn-primary btn-small" id="search_btn">查询</button>
                </div>
            </div>
        </form>
        <div class="row">
            <div class="span6">
                <div class="row">
                    <div class="span2">
                        <a href="${ctx}/baseInfo/create" id="create_new" class="btn btn-success btn-xzweb">新增数据</a>
                        <a id="delete_selected" class="btn btn-danger btn-xzweb">删除选中</a>
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
                <th>病患ID</th>
                <th>病患名称</th>
                <th>CT报告</th>
                <th>MR报告</th>
                <th>MRCP报告</th>
                <th>肿瘤类型</th>
                <th>肿瘤长度</th>
                <th>肿瘤高度</th>
                <th>肿瘤高度</th>
                <th><i class="icon-time hidden-phone"></i> 操作</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${baseInfos.content}" var="baseInfo">
                <tr>
                    <td class="center">
                        <label><input type="checkbox"><span class="lbl"></span></label>
                    </td>
                    <td>${baseInfo.patientId}</td>
                    <td>${baseInfo.patientName}</td>
                    <td>${baseInfo.ceReport}</td>
                    <td>${baseInfo.mrReport}</td>
                    <td>${baseInfo.mrcpReport}</td>
                    <td>${baseInfo.tumorKind}</td>
                    <td>${baseInfo.rumorLength}</td>
                    <td>${baseInfo.rumorWidth}</td>
                    <td>${baseInfo.rumorHeight}</td>
                    <td>
                        <div class="inline position-relative">
                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"><i class="icon-cog icon-only"></i></button>
                            <ul class="dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close">
                                <li><a href="${ctx}/baseInfo/update/${baseInfo.id}" class="tooltip-success" data-rel="tooltip" title="" data-placement="left" data-original-title="编辑"><span class="green"><i class="icon-edit"></i></span></a></li>
                                <li><a href="${ctx}/baseInfo/delete/${baseInfo.id}" onmousedown="confirmDelete(this);" class="tooltip-error" data-rel="tooltip" title="" data-placement="left" data-original-title="删除"><span class="red"><i class="icon-trash"></i></span> </a></li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <tags:pagination page="${baseInfos}" paginationSize="5" />
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