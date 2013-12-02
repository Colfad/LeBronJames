<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>颅内肿瘤病患肿瘤Coil信息添加</title>

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

            <li class="active">颅内肿瘤病患肿瘤Coil信息添加</li>
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
            <h1>颅内肿瘤病患肿瘤Coil信息管理 <small><i class="icon-double-angle-right"></i>颅内动脉瘤病患肿瘤Coil信息添加页面 --> </small>   <small style="color: #ff0000">${arteryVar.patientName}</small><small> 病患的信息</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/artery/saveOrUpdateCoilInfo" method="post" class="form-horizontal">
            <input type="hidden" name="parent.id" value="${arteryVar.id}"/>
            <input type="hidden" name="id" value="${coilVar.id}" />
            <fieldset>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="number" class="control-label">数目:</label>
                            <div class="controls">
                                <input type="text" id="number" name="number" value="${coilVar.number}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="length" class="control-label">成篮圈直径，长度:</label>
                            <div class="controls">
                                <input type="text" id="length" name="length" value="${coilVar.length}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="tenTotalLength" class="control-label">10系总长:</label>
                            <div class="controls">
                                <input type="text" id="tenTotalLength" name="tenTotalLength" value="${coilVar.tenTotalLength}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="tweTotalLength" class="control-label">12系总长:</label>
                            <div class="controls">
                                <input type="text" id="tweTotalLength" name="tweTotalLength" value="${coilVar.tweTotalLength}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="engTotalLength" class="control-label">18系总长:</label>
                            <div class="controls">
                                <input type="text" id="engTotalLength" name="engTotalLength" value="${coilVar.engTotalLength}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="bi" class="control-label">栓塞比:</label>
                            <div class="controls">
                                <input type="text" id="bi" name="bi" value="${coilVar.bi}" class="input-large required" minlength="3"/>
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