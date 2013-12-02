<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>颅内肿瘤病患信息添加</title>
</head>
<body>

    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>

        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="${ctx}/">首页</a>
                <span class="divider">
                    <i class="icon-angle-right arrow-icon"></i>
                </span>
            </li>

            <li class="active">颅内肿瘤病患信息添加</li>
        </ul><!-- .breadcrumb -->

        <div class="nav-search" id="nav-search">
            <form class="form-search">
                <span class="input-icon">
                    <input type="text" placeholder="查询 ..." class="input-small nav-search-input" id="nav-search-input" autocomplete="off" />
                    <i class="icon-search nav-search-icon"></i>
                </span>
            </form>
        </div><!-- #nav-search -->
    </div>
    <div id="page-content" class="page-content">
        <div class="page-header position-relative">
            <h1>颅内动脉瘤病患信息管理 <small><i class="icon-double-angle-right"></i>颅内动脉瘤病患信息添加页面</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/artery/${action}" method="post" class="form-horizontal">
            <input type="hidden" name="id" value="${artery.id}"/>
            <fieldset>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientNumber" class="control-label">住院号:</label>
                            <div class="controls">
                                <input type="text" id="patientNumber" name="patientNumber" value="${artery.patientNumber}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientName" class="control-label">病患姓名:</label>
                            <div class="controls">
                                <input type="text" id="patientName" name="patientName" value="${artery.patientName}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label class="control-label">病患性别:</label>
                            <div class="controls">
                                <label>
                                    <input name="patientSex" id="patientSexMan" class="ace" value="true" type="radio" <c:if test="${artery.patientSex eq true}">checked="true" </c:if> />
                                    <span class="lbl">男性</span>
                                </label>
                                <label>
                                    <input name="patientSex" id="patientSexWoman" class="ace" value="false" type="radio" <c:if test="${artery.patientSex eq false}">checked="true" </c:if> />
                                    <span class="lbl">女性</span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientAge" class="control-label">病患年龄:</label>
                            <div class="controls">
                                <input type="text" id="patientAge" name="patientAge" value="${artery.patientAge}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientAddress" class="control-label">病患联系地址:</label>
                            <div class="controls">
                                <input type="text" id="patientAddress" name="patientAddress" value="${artery.patientAddress}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="highBloodPressure" class="control-label">是否有高血压:</label>
                            <div class="controls">
                                <label>
                                    <input name="highBloodPressure" id="highBloodPressure" class="ace ace-switch ace-switch-5" <c:if test="${artery.highBloodPressure eq true}">checked="checked" </c:if> type="checkbox" />
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="glycuresis" class="control-label">是否有高血压:</label>
                            <div class="controls">
                                <label>
                                    <input name="glycuresis" id="glycuresis" class="ace ace-switch ace-switch-5" <c:if test="${artery.glycuresis eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="bloodFat" class="control-label">是否有高血脂:</label>
                            <div class="controls">
                                <label>
                                    <input name="bloodFat" id="bloodFat" class="ace ace-switch ace-switch-5" <c:if test="${artery.bloodFat eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="heartDisease" class="control-label">心脏病:</label>
                            <div class="controls">
                                <label>
                                    <input name="heartDisease" id="heartDisease" class="ace ace-switch ace-switch-5" <c:if test="${artery.heartDisease eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="smoking" class="control-label">是否吸烟:</label>
                            <div class="controls">
                                <label>
                                    <input name="smoking" id="smoking" class="ace ace-switch ace-switch-5" <c:if test="${artery.smoking eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="drink" class="control-label">是否酗酒:</label>
                            <div class="controls">
                                <label>
                                    <input name="drink" id="drink" class="ace ace-switch ace-switch-5" <c:if test="${artery.drink eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="familyHistory" class="control-label">是否有家族病史:</label>
                            <div class="controls">
                                <label>
                                    <input name="familyHistory" id="familyHistory" class="ace ace-switch ace-switch-5" <c:if test="${artery.familyHistory eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientMobile" class="control-label">联系方式:</label>
                            <div class="controls">
                                <input type="text" id="patientMobile" name="patientMobile" value="${artery.patientMobile}" class="input-large required" minlength="3"/>
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