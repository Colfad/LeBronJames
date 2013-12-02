<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户添加</title>
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

            <li class="active">系统用户信息管理</li>
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
            <h1>系统用户信息管理 <small><i class="icon-double-angle-right"></i>系统用户添加/更新操作</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/account/user/${action}" method="post" class="form-horizontal">
            <input type="hidden" name="id" value="${baseInfo.id}"/>
            <fieldset>

                <div class="control-group">
                    <label for="userName" class="control-label">登录名:</label>
                    <div class="controls">
                        <input type="text" id="userName" name="userName" value="${user.userName}" class="input-large required" minlength="3"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="realName" class="control-label">用户真实姓名:</label>
                    <div class="controls">
                        <input type="text" id="realName" name="realName" value="${user.realName}" minlength="3"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="plainPassword" class="control-label">密码:</label>
                    <div class="controls">
                        <input type="text" id="plainPassword" name="plainPassword" <c:if test="${action eq 'update'}">value="**********"</c:if> class="input-large required" minlength="3"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="plainPasswordRepeat" class="control-label">重复密码:</label>
                    <div class="controls">
                        <input type="text" id="plainPasswordRepeat" name="plainPasswordRepeat" <c:if test="${action eq 'update'}">value="**********"</c:if> class="input-large required" minlength="3"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="address" class="control-label">地址:</label>
                    <div class="controls">
                        <input type="text" id="address" name="address" value="${user.address}" class="input-large required" minlength="3"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="mobile" class="control-label">电话:</label>
                    <div class="controls">
                        <input type="text" id="mobile" name="mobile" value="${user.mobile}" class="input-large required" minlength="3"/>
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
    <script src="${ctx}/resources/assets/js/fuelux/fuelux.wizard.min.js"></script>
    <script src="${ctx}/resources/assets/js/jquery.validate.min.js"></script>
    <script src="${ctx}/resources/assets/js/additional-methods.min.js"></script>
    <script src="${ctx}/resources/assets/js/bootbox.min.js"></script>
    <script src="${ctx}/resources/assets/js/jquery.maskedinput.min.js"></script>
    <script src="${ctx}/resources/assets/js/select2.min.js"></script>

    <!-- ace scripts -->

    <script src="${ctx}/resources/assets/js/ace-elements.min.js"></script>
    <script src="${ctx}/resources/assets/js/ace.min.js"></script>

    <!-- inline scripts related to this page -->

    <script>
        jQuery(function($) {

            $('#inputForm').validate({
                errorElement: 'span',
                errorClass: 'help-inline',
                focusInvalid: false,
                rules: {
                    plainPassword: {
                        required: true,
                        minlength: 5
                    },
                    plainPasswordRepeat: {
                        required: true,
                        minlength: 5,
                        equalTo: "#plainPassword"
                    },
                    userName: {
                        required: true
                    }
                },

                messages: {
                    plainPassword: {
                        required: "请输入密码.",
                        minlength: "最小为6位密码."
                    },
                    plainPasswordRepeat: {
                        equalTo: "两次密码输入的结果不同，请输入与上面相同的密码."
                    },
                    userName: {
                        required: "请输入用户名."
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit
                    $('.alert-error', $('.login-form')).show();
                },

                highlight: function (e) {
                    $(e).closest('.control-group').removeClass('info').addClass('error');
                },

                success: function (e) {
                    $(e).closest('.control-group').removeClass('error').addClass('info');
                    $(e).remove();
                },

                errorPlacement: function (error, element) {
                    if(element.is(':checkbox') || element.is(':radio')) {
                        var controls = element.closest('.controls');
                        if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
                        else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                    }
                    else if(element.is('.select2')) {
                        error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                    }
                    else if(element.is('.chosen-select')) {
                        error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                    }
                    else error.insertAfter(element);
                },

                submitHandler: function (form) {
                },
                invalidHandler: function (form) {
                }
            });
        });
    </script>

</body>
</html>