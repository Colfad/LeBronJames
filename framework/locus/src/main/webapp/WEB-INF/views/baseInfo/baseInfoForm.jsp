<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>病患信息添加</title>
</head>
<body>

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">病患信息添加</li>
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
            <h1>病患信息管理 <small><i class="icon-double-angle-right"></i>病患信息添加页面</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/baseInfo/${action}" method="post" class="form-horizontal">
            <input type="hidden" name="id" value="${baseInfo.id}"/>
            <fieldset>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientId" class="control-label">患者编号:</label>
                            <div class="controls">
                                <input type="text" id="patientId" name="patientId" value="${baseInfo.patientId}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="patientName" class="control-label">病患姓名:</label>
                            <div class="controls">
                                <input type="text" id="patientName" name="patientName" value="${baseInfo.patientName}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="ceReport" class="control-label">CT报告:</label>
                            <div class="controls">
                                <input type="text" id="ceReport" name="ceReport" value="${baseInfo.ceReport}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="ctDate" class="control-label">CT时间:</label>
                            <div class="controls">
                                <input type="text" id="ctDate" name="ctDate" value="${baseInfo.ctDate}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="mrReport" class="control-label">MR报告:</label>
                            <div class="controls">
                                <input type="text" id="mrReport" name="mrReport" value="${baseInfo.mrReport}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="mrDate" class="control-label">MR时间:</label>
                            <div class="controls">
                                <input type="text" id="mrDate" name="mrDate" value="${baseInfo.mrDate}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="mrcpReport" class="control-label">MRCP报告:</label>
                            <div class="controls">
                                <input type="text" id="mrcpReport" name="mrcpReport" value="${baseInfo.mrcpReport}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="mcrpDate" class="control-label">MRCP时间:</label>
                            <div class="controls">
                                <input type="text" id="mcrpDate" name="mcrpDate" value="${baseInfo.mcrpDate}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="rumorLength" class="control-label">肿瘤长度:</label>
                            <div class="controls">
                                <input type="text" id="rumorLength" name="rumorLength" value="${baseInfo.rumorLength}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="tumorKind" class="control-label">肿瘤类型:</label>
                            <div class="controls">
                                <input type="text" id="tumorKind" name="tumorKind" value="${baseInfo.tumorKind}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="rumorWidth" class="control-label">肿瘤宽度:</label>
                            <div class="controls">
                                <input type="text" id="rumorWidth" name="rumorWidth" value="${baseInfo.rumorWidth}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="rumorHeight" class="control-label">肿瘤高度:</label>
                            <div class="controls">
                                <input type="text" id="rumorHeight" name="rumorHeight" value="${baseInfo.rumorHeight}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="tumorLocation" class="control-label">肿瘤位置:</label>
                            <div class="controls">
                                <input type="text" id="tumorLocation" name="tumorLocation" value="${baseInfo.tumorLocation}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                        <label for="biliaryStenosis" class="control-label">胆道狭窄度:</label>
                        <div class="controls">
                            <input type="text" id="biliaryStenosis" name="biliaryStenosis" value="${baseInfo.biliaryStenosis}" class="input-large required" minlength="3"/>
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