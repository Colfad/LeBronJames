<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>颅内肿瘤病患临床情况信息添加</title>

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

            <li class="active">颅内肿瘤病患临床情况信息添加</li>
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
            <h1>颅内肿瘤病患临床情况信息管理 <small><i class="icon-double-angle-right"></i>颅内动脉瘤病患治疗信息添加页面 --> </small>   <small style="color: #ff0000">${arteryVar.patientName}</small><small> 病患的信息</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/artery/saveOrUpdateClinicInfo" method="post" class="form-horizontal">
            <input type="hidden" name="parent.id" value="${arteryVar.id}"/>
            <input type="hidden" name="id" value="${clinicVar.id}" />
            <fieldset>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="wpCheckout" class="control-label">未破动脉瘤检出方式:</label>
                            <div class="controls">
                                <input type="text" id="wpCheckout" name="wpCheckout" value="${clinicVar.wpCheckout}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="firstSign" class="control-label">首发症状:</label>
                            <div class="controls">
                                <input type="text" id="firstSign" name="firstSign" value="${clinicVar.firstSign}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="blood" class="control-label">出血:</label>
                            <div class="controls">
                                <label>
                                    <input name="blood" id="blood" class="ace ace-switch ace-switch-5" <c:if test="${clinicVar.blood eq true}">checked="checked" </c:if> type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="fisherLevel" class="control-label">Fisher分级:</label>
                            <div class="controls">
                                <input type="text" id="fisherLevel" name="fisherLevel" value="${clinicVar.fisherLevel}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="bloodTimes" class="control-label">出血次数:</label>
                            <div class="controls">
                                <input type="text" id="bloodTimes" name="bloodTimes" value="${clinicVar.bloodTimes}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="toCTTime" class="control-label">距CT时间:</label>
                            <div class="controls">
                                <input type="text" id="toCTTime" name="toCTTime" value="${clinicVar.toCTTime}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="toShTime" class="control-label">距造影时间:</label>
                            <div class="controls">
                                <input type="text" id="toShTime" name="toShTime" value="${clinicVar.toShTime}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="huntHessLevel" class="control-label">hunt-hess分级:</label>
                            <div class="controls">
                                <input type="text" id="huntHessLevel" name="huntHessLevel" value="${clinicVar.huntHessLevel}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="wfns" class="control-label">WFNS评分:</label>
                            <div class="controls">
                                <input type="text" id="wfns" name="wfns" value="${clinicVar.wfns}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                     </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="gcs" class="control-label">GCS评分:</label>
                            <div class="controls">
                                <input type="text" id="gcs" name="gcs" value="${clinicVar.gcs}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="nihss" class="control-label">NIHSS评分:</label>
                            <div class="controls">
                                <input type="text" id="nihss" name="nihss" value="${clinicVar.nihss}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="mrs" class="control-label">MRS评分:</label>
                            <div class="controls">
                                <input type="text" id="mrs" name="mrs" value="${clinicVar.mrs}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="bloodPressure" class="control-label">血压:</label>
                            <div class="controls">
                                <input type="text" id="bloodPressure" name="bloodPressure" value="${clinicVar.bloodPressure}" class="input-large required" minlength="3"/>
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