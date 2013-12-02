<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>梗阻性黄疸病患信息列表</title>
</head>

<body>

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">梗阻性黄疸病患信息列表</li>
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
            <h1>梗阻性黄疸病患信息管理 <small><i class="icon-double-angle-right"></i> 对梗阻性黄疸病患信息进行基本的管理工作</small></h1>
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
                    <div class="span6">
                        <a href="${ctx}/icterus//create" id="create_new" class="btn btn-success btn-xzweb">新增数据</a>
                        <a id="delete_selected" class="btn btn-danger btn-xzweb">删除选中</a>
                        <a href="${ctx}/icterus/exportExcel" id="exportExcel" class="btn btn-warning btn-xzweb">导出Excel</a>
                        <a href="#" id="importExcel" class="btn btn-info btn-xzweb">导入Excel</a>
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

                <th>住院号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>联系地址</th>
                <th>高血压</th>
                <th>糖尿病</th>
                <th>高血脂</th>
                <th>心脏病</th>
                <th>吸烟</th>
                <th>酗酒</th>
                <th>家族病史</th>
                <th><i class="icon-time hidden-phone"></i> 操作</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${icteruses.content}" var="icterus">
                <tr>
                    <td class="center">
                        <label><input type="checkbox"><span class="lbl"></span></label>
                    </td>
                    <td>${icterus.patientNumber}</td>
                    <td>${icterus.patientName}</td>
                    <td>
                        <c:choose>
                            <c:when test="${icterus.patientSex eq true}">
                                男
                            </c:when>
                            <c:otherwise>
                                女
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${icterus.patientAge}</td>
                    <td>${icterus.patientAddress}</td>
                    <td>
                        <c:choose>
                            <c:when test="${icterus.highBloodPressure eq true}">
                                <i class="icon-ok green" />
                            </c:when>
                            <c:otherwise>
                                <i class="icon-remove red" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${icterus.glycuresis eq true}">
                                <i class="icon-ok green" />
                            </c:when>
                            <c:otherwise>
                                <i class="icon-remove red" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${icterus.bloodFat eq true}">
                                <i class="icon-ok green" />
                            </c:when>
                            <c:otherwise>
                                <i class="icon-remove red" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${icterus.heartDisease eq true}">
                                <i class="icon-ok green" />
                            </c:when>
                            <c:otherwise>
                                <i class="icon-remove red" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${icterus.smoking eq true}">
                                <i class="icon-ok green" />
                            </c:when>
                            <c:otherwise>
                                <i class="icon-remove red" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${icterus.drink eq true}">
                                <i class="icon-ok green" />
                            </c:when>
                            <c:otherwise>
                                <i class="icon-remove red" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${icterus.familyHistory eq true}">
                                <i class="icon-ok green" />
                            </c:when>
                            <c:otherwise>
                                <i class="icon-remove red" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <div class="inline position-relative">
                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"><i class="icon-cog icon-only"></i></button>
                            <ul class="dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close">
                                <li><a href="${ctx}/icterus/update/${icterus.id}" class="tooltip-success" data-rel="tooltip" title="" data-placement="left" data-original-title="编辑"><span class="green"><i class="icon-edit"></i></span></a></li>
                                <li><a href="${ctx}/icterus/delete/${icterus.id}" onmousedown="confirmDelete(this);" class="tooltip-error" data-rel="tooltip" title="" data-placement="left" data-original-title="删除"><span class="red"><i class="icon-trash"></i></span> </a></li>
                            </ul>

                        </div>


                        <a class="btn btn-minier btn-primary btn-warning icon-leaf" href="${ctx}/icterus/toIcterusPicForm/${icterus.id}/pic/${icterus.icterusPic.id}" />
                            <%--
                            <a class="btn btn-minier btn-primary btn-success icon-eye-open" href="${ctx}/icterus/toDescribForm/${icterus.id}/describ/${icterus.arteryDescrib.id}" />
                            <a class="btn btn-minier btn-primary btn-info icon-fire" href="${ctx}/icterus/toCoilForm/${icterus.id}/coil/${icterus.arteryCoil.id}" />
                            <a class="btn btn-minier btn-primary btn-info icon-group" href="${ctx}/icterus/toVisitForm/${icterus.id}/visit/${icterus.arteryVisit.id}" />
                            --%>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <tags:pagination page="${icteruses}" paginationSize="10" />
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