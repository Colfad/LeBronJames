<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="utf-8" />
    <title>登录页面</title>

    <meta name="description" content="User login page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- basic styles -->

    <link href="${ctx}/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${ctx}/resources/assets/css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/resources/assets/css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/resources/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace-fonts.css" />

    <!-- ace styles -->

    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace-responsive.min.css" />
    <link rel="stylesheet" href="${ctx}/resources/assets/css/ace-skins.min.css" />

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="${ctx}/resources/assets/js/ace-extra.min.js"></script>
</head>

<body class="login-layout">
<div class="main-container container-fluid">
<div class="main-content">
<div class="row-fluid">
<div class="span12">
<div class="login-container">
<div class="row-fluid">
    <div class="center">
        <h1>
            <i class="icon-leaf green"></i>
            <span class="red">省人民医院</span>
            <span class="white">胆道病患信息管理系统</span>
        </h1>
        <h4 class="blue">&copy; 江苏省人民医院</h4>
    </div>
</div>

<div class="space-6"></div>

<div class="row-fluid">
    <div class="position-relative">
        <div id="login-box" class="login-box visible widget-box no-border">
            <div class="widget-body">
                <div class="widget-main">
                    <h4 class="header blue lighter bigger">
                        <i class="icon-coffee green"></i>
                        输入您的信息，登录系统
                    </h4>

                    <div class="space-6"></div>

                    <form action="${ctx}/login" method="post">
                        <fieldset>
                            <label>
															<span class="block input-icon input-icon-right">
																<input type="text" class="span12" name="username" placeholder="用户名" />
																<i class="icon-user"></i>
															</span>
                            </label>

                            <label>
															<span class="block input-icon input-icon-right">
																<input type="password" class="span12" name="password" placeholder="密码" />
																<i class="icon-lock"></i>
															</span>
                            </label>

                            <div class="space"></div>

                            <div class="clearfix">
                                <label class="inline">
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"> 记住我</span>
                                </label>

                                <button type="submit" class="width-35 pull-right btn btn-small btn-primary">
                                    <i class="icon-key"></i>
                                    登录
                                </button>
                            </div>

                            <div class="space-4"></div>
                        </fieldset>
                    </form>

                </div><!-- /widget-main -->

                <div class="toolbar clearfix">
                    <div>
                        <a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
                            <i class="icon-arrow-left"></i>
                            我忘记了密码
                        </a>
                    </div>

                </div>
            </div><!-- /widget-body -->
        </div><!-- /login-box -->

        <div id="forgot-box" class="forgot-box widget-box no-border">
            <div class="widget-body">
                <div class="widget-main">
                    <h4 class="header red lighter bigger">
                        <i class="icon-key"></i>
                        重置你的密码
                    </h4>

                    <div class="space-6"></div>
                    <p>
                        输入您注册时的邮箱地址
                    </p>

                    <form>
                        <fieldset>
                            <label>
															<span class="block input-icon input-icon-right">
																<input type="email" class="span12" placeholder="Email" />
																<i class="icon-envelope"></i>
															</span>
                            </label>

                            <div class="clearfix">
                                <button onclick="return false;" class="width-35 pull-right btn btn-small btn-danger">
                                    <i class="icon-lightbulb"></i>
                                    发送邮件!
                                </button>
                            </div>
                        </fieldset>
                    </form>
                </div><!-- /widget-main -->

                <div class="toolbar center">
                    <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                        返回至登录界面
                        <i class="icon-arrow-right"></i>
                    </a>
                </div>
            </div><!-- /widget-body -->
        </div><!-- /forgot-box -->

        <div id="signup-box" class="signup-box widget-box no-border">
            <div class="widget-body">
                <div class="widget-main">
                    <h4 class="header green lighter bigger">
                        <i class="icon-group blue"></i>
                        New User Registration
                    </h4>

                    <div class="space-6"></div>
                    <p> Enter your details to begin: </p>

                    <form>
                        <fieldset>
                            <label>
															<span class="block input-icon input-icon-right">
																<input type="email" class="span12" placeholder="Email" />
																<i class="icon-envelope"></i>
															</span>
                            </label>

                            <label>
															<span class="block input-icon input-icon-right">
																<input type="text" class="span12" placeholder="Username" />
																<i class="icon-user"></i>
															</span>
                            </label>

                            <label>
															<span class="block input-icon input-icon-right">
																<input type="password" class="span12" placeholder="Password" />
																<i class="icon-lock"></i>
															</span>
                            </label>

                            <label>
															<span class="block input-icon input-icon-right">
																<input type="password" class="span12" placeholder="Repeat password" />
																<i class="icon-retweet"></i>
															</span>
                            </label>

                            <label>
                                <input type="checkbox" class="ace" />
															<span class="lbl">
																I accept the
																<a href="#">User Agreement</a>
															</span>
                            </label>

                            <div class="space-24"></div>

                            <div class="clearfix">
                                <button type="reset" class="width-30 pull-left btn btn-small">
                                    <i class="icon-refresh"></i>
                                    Reset
                                </button>

                                <button onclick="return false;" class="width-65 pull-right btn btn-small btn-success">
                                    Register
                                    <i class="icon-arrow-right icon-on-right"></i>
                                </button>
                            </div>
                        </fieldset>
                    </form>
                </div>

                <div class="toolbar center">
                    <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                        <i class="icon-arrow-left"></i>
                        Back to login
                    </a>
                </div>
            </div><!-- /widget-body -->
        </div><!-- /signup-box -->
    </div><!-- /position-relative -->
</div>
</div>
</div><!-- /.span -->
</div><!-- /.row-fluid -->
</div>
</div><!-- /.main-container -->

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

<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#'+id).addClass('visible');
    }
</script>
</body>
</html>
