<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>文件上传表单</title>

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="${ctx}/resources/assets/css/dropzone.css" />

</head>

<body>

    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>

        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#">首页</a>

							<span class="divider">
								<i class="icon-angle-right arrow-icon"></i>
							</span>
            </li>

            <li>
                <a href="${ctx}/file/">文件上传列表</a>

							<span class="divider">
								<i class="icon-angle-right arrow-icon"></i>
							</span>
            </li>
            <li class="active">文件上传表单</li>
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

    <div class="page-content">
        <div class="page-header position-relative">
            <h1>
                文件上传
                <small>
                    <i class="icon-double-angle-right"></i>
                    拖 &amp; 拽文件到框内，或者点击上传文件
                </small>
            </h1>
        </div><!-- /.page-header -->

        <div class="row-fluid">
            <div class="span12">
                <!-- PAGE CONTENT BEGINS -->

                <div id="dropzone">
                    <form action="/file/create" class="dropzone" method="post">
                        <div class="fallback">
                            <input name="file" type="file" multiple="" />
                        </div>
                    </form>
                </div><!-- PAGE CONTENT ENDS -->
            </div><!-- /.span -->
        </div><!-- /.row-fluid -->
    </div><!-- /.page-content -->

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

<script src="${ctx}/resources/assets/js/dropzone.min.js"></script>

<!-- ace scripts -->

<script src="${ctx}/resources/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/resources/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    jQuery(function($){

        try {
            $(".dropzone").dropzone({
                paramName: "file", // The name that will be used to transfer the file
                maxFilesize: 1000, // MB

                addRemoveLinks : true,
                dictDefaultMessage :
                        '<span class="bigger-150 bolder"><i class="icon-caret-right red"></i> 拖拽文件</span> 上传 \
                        <span class="smaller-80 grey">(单击上传)</span> <br /> \
                        <i class="upload-icon icon-cloud-upload blue icon-3x"></i>'
                ,
                dictResponseError: '文件在上传的过程中发生错误!',

                //change the previewTemplate to use Bootstrap progress bars
                previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-success progress-striped active\"><span class=\"bar\" data-dz-uploadprogress></span></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>"
            });
        } catch(e) {
            alert('Dropzone.js 不支持旧版本浏览器，请升级浏览器!');
        }

    });
</script>
</body>
</html>