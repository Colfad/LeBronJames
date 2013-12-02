<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>梗阻性黄疸病患影像信息添加</title>
</head>
<body>

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">梗阻性黄疸病患影像信息添加</li>
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
            <h1>梗阻性黄疸病患影像信息管理 <small><i class="icon-double-angle-right"></i>梗阻性黄疸病患影像信息添加页面 --> </small>   <small style="color: #ff0000">${icterus.patientName}</small><small> 病患的信息</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/icterus/saveOrUpdateIcterusPic" method="post" class="form-horizontal">
            <input type="hidden" name="parent.id" value="${icterus.id}"/>
            <input type="hidden" name="id" value="${icterusPic.id}" />
            <fieldset>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="ctTime" class="control-label">CT时间:</label>
                            <div class="controls">
                                <input type="text" id="ctTime" name="ctTime" value="${icterusPic.ctTime}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="mrTime" class="control-label">MR时间:</label>
                            <div class="controls">
                                <input type="text" id="mrTime" name="mrTime" value="${icterusPic.mrTime}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="mrcpTime" class="control-label">MRCP时间:</label>
                            <div class="controls">
                                <input type="text" id="mrcpTime" name="mrcpTime" value="${icterusPic.mrcpTime}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="petctTime" class="control-label">PET-CT时间:</label>
                            <div class="controls">
                                <input type="text" id="petctTime" name="petctTime" value="${icterusPic.petctTime}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="ctReport" class="control-label">CT报告:</label>
                            <div class="controls">
                                <input type="text" id="ctReport" name="ctReport" value="${icterusPic.ctReport}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="mrReport" class="control-label">MR报告:</label>
                            <div class="controls">
                                <input type="text" id="mrReport" name="mrReport" value="${icterusPic.mrReport}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="mrcpReport" class="control-label">MRCP报告:</label>
                            <div class="controls">
                                <input type="text" id="mrcpReport" name="mrcpReport" value="${icterusPic.mrcpReport}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="petctReport" class="control-label">PET-CT报告:</label>
                            <div class="controls">
                                <input type="text" id="petctReport" name="petctReport" value="${icterusPic.petctReport}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="ectReport" class="control-label">ECT报告:</label>
                            <div class="controls">
                                <input type="text" id="ectReport" name="ectReport" value="${icterusPic.ectReport}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                     </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="site" class="control-label">肿瘤位置:</label>
                            <div class="controls">
                                <input type="text" id="site" name="site" value="${icterusPic.site}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="height" class="control-label">肿瘤高度:</label>
                            <div class="controls">
                                <input type="text" id="height" name="height" value="${icterusPic.height}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="length" class="control-label">肿瘤长度 :</label>
                            <div class="controls">
                                <input type="text" id="length" name="length" value="${icterusPic.length}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="width" class="control-label">肿瘤高度:</label>
                            <div class="controls">
                                <input type="text" id="width" name="width" value="${icterusPic.width}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="type" class="control-label">肿瘤类型:</label>
                            <div class="controls">
                                <input type="text" id="type" name="type" value="${icterusPic.type}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="cuLength" class="control-label">胆道狭窄度:</label>
                            <div class="controls">
                                <input type="text" id="cuLength" name="cuLength" value="${icterusPic.cuLength}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="strut" class="control-label">支架的通畅行:</label>
                            <div class="controls">
                                <input type="text" id="strut" name="strut" value="${icterusPic.strut}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="strutMove" class="control-label">支架是否位移:</label>
                            <div class="controls">
                                <label>
                                    <input name="strutMove" id="strutMove" class="ace-switch ace-switch-7" <c:if test="${icterusPic.strutMove eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="iNumber" class="control-label">I-125粒子数目:</label>
                            <div class="controls">
                                <input type="text" id="iNumber" name="iNumber" value="${icterusPic.iNumber}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="iMove" class="control-label">I-125粒子位置是否位移:</label>
                            <div class="controls">
                                <label>
                                    <input name="iMove" id="iMove" class="ace-switch ace-switch-7" <c:if test="${icterusPic.iMove eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="iMount" class="control-label">I-125粒子辐射剂量:</label>
                            <div class="controls">
                                <input type="text" id="iMount" name="iMount" value="${icterusPic.iMount}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
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