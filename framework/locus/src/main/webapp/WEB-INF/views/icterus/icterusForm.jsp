<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>梗阻性黄疸病患信息添加</title>

</head>
<body>

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">梗阻性黄疸病患信息添加</li>
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
            <h1>梗阻性黄疸病患信息管理 <small><i class="icon-double-angle-right"></i>梗阻性黄疸病患信息添加页面</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/icterus/${action}" method="post" class="form-horizontal">
            <input type="hidden" name="id" value="${icterus.id}"/>
            <fieldset>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientNumber" class="control-label">住院号:</label>
                            <div class="controls">
                                <input type="text" id="patientNumber" name="patientNumber" value="${icterus.patientNumber}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientName" class="control-label">病患姓名:</label>
                            <div class="controls">
                                <input type="text" id="patientName" name="patientName" value="${icterus.patientName}" class="input-large required" minlength="3"/>
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
                                    <input name="patientSex" id="patientSexMan" value="true" type="radio" <c:if test="${icterus.patientSex eq true}">checked="true" </c:if> />
                                    <span class="lbl">男性</span>
                                </label>
                                <label>
                                    <input name="patientSex" id="patientSexWoman" value="false" type="radio" <c:if test="${icterus.patientSex eq false}">checked="true" </c:if> />
                                    <span class="lbl">女性</span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientAge" class="control-label">病患年龄:</label>
                            <div class="controls">
                                <input type="text" id="patientAge" name="patientAge" value="${icterus.patientAge}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientAddress" class="control-label">病患联系地址:</label>
                            <div class="controls">
                                <input type="text" id="patientAddress" name="patientAddress" value="${icterus.patientAddress}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="highBloodPressure" class="control-label">是否有高血压:</label>
                            <div class="controls">
                                <label>
                                    <input name="highBloodPressure" id="highBloodPressure" class="ace-switch ace-switch-7" <c:if test="${icterus.highBloodPressure eq true}">checked="checked" </c:if> type="checkbox">
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
                                    <input name="glycuresis" id="glycuresis" class="ace-switch ace-switch-7" <c:if test="${icterus.glycuresis eq true}">checked="checked" </c:if> type="checkbox">
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
                                    <input name="bloodFat" id="bloodFat" class="ace-switch ace-switch-7" <c:if test="${icterus.bloodFat eq true}">checked="checked" </c:if> type="checkbox">
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
                                    <input name="heartDisease" id="heartDisease" class="ace-switch ace-switch-7" <c:if test="${icterus.heartDisease eq true}">checked="checked" </c:if> type="checkbox">
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
                                    <input name="smoking" id="smoking" class="ace-switch ace-switch-7" <c:if test="${icterus.smoking eq true}">checked="checked" </c:if> type="checkbox">
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
                                    <input name="drink" id="drink" class="ace-switch ace-switch-7" <c:if test="${icterus.drink eq true}">checked="checked" </c:if> type="checkbox">
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
                                    <input name="familyHistory" id="familyHistory" class="ace-switch ace-switch-7" <c:if test="${icterus.familyHistory eq true}">checked="checked" </c:if> type="checkbox">
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
                                <input type="text" id="patientMobile" name="patientMobile" value="${icterus.patientMobile}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="zCode" class="control-label">邮政编码:</label>
                            <div class="controls">
                                <input type="text" id="zCode" name="zCode" value="${icterus.zCode}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="checkInTime" class="control-label">入院时间:</label>
                            <div class="controls">
                                <input type="text" id="checkInTime" name="checkInTime" value="${icterus.patientMobile}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="weight" class="control-label">体重:</label>
                            <div class="controls">
                                <input type="text" id="weight" name="weight" value="${icterus.weight}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="height" class="control-label">身高:</label>
                            <div class="controls">
                                <input type="text" id="height" name="height" value="${icterus.height}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="operateInfo" class="control-label">手术史:</label>
                            <div class="controls">
                                <input type="text" id="operateInfo" name="operateInfo" value="${icterus.operateInfo}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="otherOperateInfo" class="control-label">其他病史:</label>
                            <div class="controls">
                                <input type="text" id="otherOperateInfo" name="otherOperateInfo" value="${icterus.otherOperateInfo}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="ecog" class="control-label">体能评分:</label>
                            <div class="controls">
                                <input type="text" id="ecog" name="ecog" value="${icterus.ecog}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="painScore" class="control-label">疼痛评分:</label>
                            <div class="controls">
                                <input type="text" id="painScore" name="painScore" value="${icterus.painScore}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="operateCheck" class="control-label">临床诊断:</label>
                            <div class="controls">
                                <input type="text" id="operateCheck" name="operateCheck" value="${icterus.operateCheck}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="operateAvidence" class="control-label">诊断依据:</label>
                            <div class="controls">
                                <input type="text" id="operateAvidence" name="operateAvidence" value="${icterus.operateAvidence}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="cType" class="control-label">肿瘤类型:</label>
                            <div class="controls">
                                <input type="text" id="cType" name="cType" value="${icterus.cType}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="treatGroup" class="control-label">治疗分组:</label>
                            <div class="controls">
                                <input type="text" id="treatGroup" name="treatGroup" value="${icterus.treatGroup}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="searchDept" class="control-label">研究单位:</label>
                            <div class="controls">
                                <input type="text" id="searchDept" name="searchDept" value="${icterus.searchDept}" class="input-large required" minlength="3"/>
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