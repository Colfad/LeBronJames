<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>文件上传列表</title>
    <link rel="stylesheet" href="${ctx}/resources/assets/css/colorbox.css" />
    <style>
        .picBro {

        }
    </style>
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

        <li class="active">文件上传列表</li>
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
        <h1>文件中心管理 <small><i class="icon-double-angle-right"></i> 可以在这里上传文件，下载内容文件</small></h1>
    </div><!--/page-header-->

    <c:if test="${message != null}">
        <div class="alert alert-success" id="alertInfo">
            <button type="button" class="close" data-dismiss="alert">×</button>
                ${message}
        </div>
    </c:if>
    <form class="form-search" action="#">
        <div class="control-group">
            <label class="control-label">查询条件:</label>
            <div class="controls">
                <input type="text" id="search_file_name" name="search_LIKE_fileName" placeholder="文件名" value="${param.search_LIKE_fileName}" />&nbsp;&nbsp;
                <input type="text" id="search_mimeTypeExtensionName" name="search_LIKE_mimeTypeExtensionName" placeholder="文件扩展名" value="${param.search_LIKE_mimeTypeExtensionName}" />
                <button type="submit" class="btn btn-primary btn-small" id="search_btn">查询</button>
            </div>
        </div>
    </form>
    <div class="row">
        <div class="span6">
            <div class="row">
                <div class="span6">
                    <a href="${ctx}/file/create" id="create_new" class="btn btn-success btn-xzweb">新增数据</a>
                    <a id="delete_selected" class="btn btn-danger btn-xzweb">删除选中</a>
                </div>
            </div>
        </div>
        <div class="span3 pull-right">
            <tags:sort />
        </div>
    </div>

    <br />
    <table id="contentTable" class="table table-striped table-bordered table-hover picBro">
        <thead>
        <tr>
            <th class="center">
                <label><input type="checkbox" class="ace"><span class="lbl"></span></label>
            </th>

            <th>文件ID</th>
            <th>文件名</th>
            <th><i class="icon-time hidden-phone"></i> 文件上传日期</th>
            <th>MIMETYPE</th>
            <th>文件扩展名</th>
            <th>预览(图片)</th>

            <th>操作</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${fileRepositories.content}" var="fileRepository">
            <tr>
                <td class="center">
                    <label><input type="checkbox" class="ace"><span class="lbl"></span></label>
                </td>
                <td>${fileRepository.id}</td>
                <td>${fileRepository.fileName}</td>
                <td><fmt:formatDate value="${fileRepository.createDate}" pattern="yyyy年MM月dd日 HH时mm分ss秒" /></td>
                <td>${fileRepository.mimeTypeName}</td>
                <td>${fileRepository.mimeTypeExtensionName}</td>
                <td>
                    <c:if test="${fn:containsIgnoreCase(fileRepository.mimeTypeName, 'image')}">
                        <ul class="ace-thumbnails">
                            <li>
                                <a href="${ctx}/file/download/<fmt:formatDate value="${fileRepository.createDate}" pattern="yyyy/MM/dd" />/${fileRepository.id}/image" data-rel="colorbox">
                                    <img alt="150x150" style="width: 150px" src="${ctx}/file/download/<fmt:formatDate value="${fileRepository.createDate}" pattern="yyyy/MM/dd" />/${fileRepository.id}" />
                                    <div class="text">
                                        <div class="inner">${fileRepository.fileName}</div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </c:if>
                </td>
                <td>
                    <div class="inline position-relative">
                        <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"><i class="icon-cog icon-only"></i></button>
                        <ul class="dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close">
                            <li><a href="${ctx}/file/update/${fileRepository.id}" class="tooltip-success" data-rel="tooltip" title="" data-placement="left" data-original-title="编辑"><span class="green"><i class="icon-edit"></i></span></a></li>
                            <li><a href="${ctx}/file/delete/${fileRepository.id}" onmousedown="confirmDelete(this);" class="tooltip-error" data-rel="tooltip" title="" data-placement="left" data-original-title="删除"><span class="red"><i class="icon-trash"></i></span> </a></li>
                        </ul>
                    </div>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <tags:pagination page="${fileRepositories}" paginationSize="10" />
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
<script src="${ctx}/resources/assets/js/jquery.colorbox-min.js"></script>

<!-- ace scripts -->

<script src="${ctx}/resources/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/resources/assets/js/ace.min.js"></script>
<script src="${ctx}/resources/assets/js/bootbox.min.js"></script>

<!-- inline scripts related to this page -->


<script type="text/javascript">
    jQuery(function($) {
        var colorbox_params = {
            reposition:true,
            scalePhotos:true,
            scrolling:false,
            previous:'<i class="icon-arrow-left"></i>',
            next:'<i class="icon-arrow-right"></i>',
            close:'&times;',
            current:'{current} of {total}',
            maxWidth:'100%',
            maxHeight:'100%',
            onOpen:function(){
                document.body.style.overflow = 'hidden';
            },
            onClosed:function(){
                document.body.style.overflow = 'auto';
            },
            onComplete:function(){
                var img = $('#loadImage');

                // 这里获得图片的长宽高，然后再进行相应的设置就可以了
                $.colorbox.resize({width: img.width(), height: img.height()})
            }
        };

        $('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
        $("#cboxLoadingGraphic").append("<i class='icon-spinner orange'></i>");//let's add a custom loading icon

        /**$(window).on('resize.colorbox', function() {
		try {
			//this function has been changed in recent versions of colorbox, so it won't work
			$.fn.colorbox.load();//to redraw the current frame
		} catch(e){}
	});*/
    })

    $(function() {

        $('table th input:checkbox').on('click' , function(){
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                    .each(function(){
                        this.checked = that.checked;
                        $(this).closest('tr').toggleClass('selected');
                    });

        });

        $('[data-rel=tooltip]').tooltip();

        var alertInfo = $('#alertInfo');
        if (alertInfo) {

            function deleteAlertInfo() {
                alertInfo.toggle('slow');
            }

            // 3秒之后信息框将消失
            window.setTimeout(deleteAlertInfo, 3000);
        }
    });

    function confirmDelete(obj) {
        bootbox.confirm("确定要删除此条数据?删除此条数据将不可以再找回.", "取消", "确定", function(result) {
            if (!result) {
                return;
            }
            window.location.href = obj.getAttribute("href");
        });
    }

</script>
</body>
</html>