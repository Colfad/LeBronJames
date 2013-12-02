<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>颅内肿瘤病患肿瘤描述信息添加</title>

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

            <li class="active">颅内肿瘤病患肿瘤描述信息添加</li>
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
            <h1>颅内肿瘤病患肿瘤描述信息管理 <small><i class="icon-double-angle-right"></i>颅内动脉瘤病患肿瘤描述添加页面 --> </small>   <small style="color: #ff0000">${arteryVar.patientName}</small><small> 病患的信息</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/artery/saveOrUpdateDescribInfo" method="post" class="form-horizontal">
            <input type="hidden" name="parent.id" value="${arteryVar.id}"/>
            <input type="hidden" name="id" value="${describVar.id}" />
            <fieldset>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="lr" class="control-label">LR:</label>
                            <div class="controls">
                                <input type="text" id="lr" name="lr" value="${describVar.lr}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="num" class="control-label">NUM:</label>
                            <div class="controls">
                                <input type="text" id="num" name="num" value="${describVar.num}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="shape" class="control-label">Shape:</label>
                            <div class="controls">
                                <input type="text" id="shape" name="shape" value="${describVar.shape}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="location" class="control-label">Location:</label>
                            <div class="controls">
                                <input type="text" id="location" name="location" value="${describVar.location}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="length" class="control-label">Length:</label>
                            <div class="controls">
                                <input type="text" id="length" name="length" value="${describVar.length}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="width" class="control-label">Width:</label>
                            <div class="controls">
                                <input type="text" id="width" name="width" value="${describVar.width}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="span5">
                        <div class="control-group">
                            <label for="height" class="control-label">Height:</label>
                            <div class="controls">
                                <input type="text" id="height" name="height" value="${describVar.height}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="volume" class="control-label">Volume:</label>
                            <div class="controls">
                                <input type="text" id="volume" name="volume" value="${describVar.volume}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="parentA" class="control-label">ParentA:</label>
                            <div class="controls">
                                <input type="text" id="parentA" name="parentA" value="${describVar.parentA}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                     </div>

                    <div class="span5">
                        <div class="control-group">
                            <label for="ratioNeck" class="control-label">Ratio(Neck/Artery):</label>
                            <div class="controls">
                                <input type="text" id="ratioNeck" name="ratioNeck" value="${describVar.ratioNeck}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="span5">
                        <div class="control-group">
                            <label for="ratioDome" class="control-label">RatioDome:</label>
                            <div class="controls">
                                <input type="text" id="ratioDome" name="ratioDome" value="${describVar.ratioDome}" class="input-large required" minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="span5">
                        <div class="control-group">
                            <label for="blood" class="control-label">血管痉挛:</label>
                            <div class="controls">
                                <input type="text" id="blood" name="blood" value="${describVar.blood}" class="input-large required" minlength="3"/>
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