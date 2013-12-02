<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>颅内肿瘤病患肿瘤随访信息添加</title>

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

            <li class="active">颅内肿瘤病患肿瘤随访信息添加</li>
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
            <h1>颅内肿瘤病患肿瘤随访信息管理 <small><i class="icon-double-angle-right"></i>颅内动脉瘤病患肿瘤随访信息添加页面 --> </small>   <small style="color: #ff0000">${arteryVar.patientName}</small><small> 病患的信息</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/artery/saveOrUpdateVisit" method="post" class="form-horizontal">
            <input type="hidden" name="parent.id" value="${arteryVar.id}"/>
            <input type="hidden" name="id" value="${visitVar.id}" />
            <fieldset>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="visitDate" class="control-label">日期:</label>
                            <div class="controls">
                                <input type="text" id="visitDate" name="visitDate" value="${visitVar.visitDate}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="threeMRS" class="control-label">3月mRS:</label>
                            <div class="controls">
                                <input type="text" id="threeMRS" name="threeMRS" value="${visitVar.threeMRS}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="threeHIHSS" class="control-label">3月HIHSS:</label>
                            <div class="controls">
                                <input type="text" id="threeHIHSS" name="threeHIHSS" value="${visitVar.threeHIHSS}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="threeGOS" class="control-label">3月GOS:</label>
                            <div class="controls">
                                <input type="text" id="threeGOS" name="threeGOS" value="${visitVar.threeGOS}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="sixMRS" class="control-label">6月mRS:</label>
                            <div class="controls">
                                <input type="text" id="sixMRS" name="sixMRS" value="${visitVar.sixMRS}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="sixHIHSS" class="control-label">6月HIHSS:</label>
                            <div class="controls">
                                <input type="text" id="sixHIHSS" name="sixHIHSS" value="${visitVar.sixHIHSS}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="again" class="control-label">复发:</label>
                            <div class="controls">
                                <label>
                                    <input name="again" id="again" class="ace ace-switch ace-switch-5" <c:if test="${visitVar.again eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="treatAgain" class="control-label">再治疗:</label>
                            <div class="controls">
                                <input type="text" id="treatAgain" name="treatAgain" value="${visitVar.treatAgain}" class="input-large required" minlength="3"/>
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