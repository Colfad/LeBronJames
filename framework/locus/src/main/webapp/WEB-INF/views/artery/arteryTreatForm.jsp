<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>颅内肿瘤病患肿治疗信息添加</title>

</head>
<body>

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">颅内肿瘤病患肿瘤治疗信息添加</li>
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
            <h1>颅内肿瘤病患肿瘤治疗信息管理 <small><i class="icon-double-angle-right"></i>颅内动脉瘤病患肿瘤治疗添加页面 --> </small>   <small style="color: #ff0000">${arteryVar.patientName}</small><small> 病患的信息</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/artery/saveOrUpdateTreatInfo" method="post" class="form-horizontal">
            <input type="hidden" name="parent.id" value="${arteryVar.id}"/>
            <input type="hidden" name="id" value="${treatVar.id}" />
            <fieldset>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="toShTime" class="control-label">距造影时间:</label>
                            <div class="controls">
                                <input type="text" id="toShTime" name="toShTime" value="${treatVar.toShTime}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="microcatheter" class="control-label">microcatheter:</label>
                            <div class="controls">
                                <input type="text" id="microcatheter" name="microcatheter" value="${treatVar.microcatheter}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="guidewire" class="control-label">guidewire:</label>
                            <div class="controls">
                                <input type="text" id="guidewire" name="guidewire" value="${treatVar.guidewire}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="guiding" class="control-label">guiding:</label>
                            <div class="controls">
                                <input type="text" id="guiding" name="guiding" value="${treatVar.guiding}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="auxiliary" class="control-label">辅助:</label>
                            <div class="controls">
                                <input type="text" id="auxiliary" name="auxiliary" value="${treatVar.auxiliary}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="stent" class="control-label">stent:</label>
                            <div class="controls">
                                <input type="text" id="stent" name="stent" value="${treatVar.stent}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="technicalSuccess" class="control-label">technicalSuccess:</label>
                            <div class="controls">
                                <label>
                                    <input name="technicalSuccess" id="technicalSuccess" class="ace-switch ace-switch-7" <c:if test="${treatVar.technicalSuccess eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="complication" class="control-label">并发症:</label>
                            <div class="controls">
                                <input type="text" id="complication" name="complication" value="${treatVar.complication}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="checkInTime" class="control-label">住院时间:</label>
                            <div class="controls">
                                <input type="text" id="checkInTime" name="checkInTime" value="${treatVar.checkInTime}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                     </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="checkOutTime" class="control-label">出院时间:</label>
                            <div class="controls">
                                <input type="text" id="checkOutTime" name="checkOutTime" value="${treatVar.checkOutTime}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="memo" class="control-label">备注:</label>
                            <div class="controls">
                                <input type="text" id="memo" name="memo" value="${treatVar.memo}" class="input-large required" minlength="3"/>
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