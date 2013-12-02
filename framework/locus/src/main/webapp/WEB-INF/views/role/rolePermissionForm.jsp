<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>权限添加</title>

</head>
<body>

    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i> <a href="${ctx}/">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
            <li class="active">权限添加</li>
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
            <h1>权限管理 <small><i class="icon-double-angle-right"></i>对后台管理员进行权限分配工作</small></h1>
        </div><!--/page-header-->
        <form id="inputForm" action="${ctx}/role/${action}" method="post" class="form-horizontal">
            <input type="hidden" name="id" value="${role.id}"/>
            <input type="hidden" name="permissions" id="permissions" value="${role.permissions}" />

            <fieldset>

                <div class="tabbable">
                    <ul class="nav nav-tabs" id="myTab3">
                        <li class="active"><a data-toggle="tab" href="#home1"><i class="green icon-dashboard bigger-110"></i> 整体数据分析&神经介入</a></li>
                        <li class=""><a data-toggle="tab" href="#home2"><span class="badge icon-beaker bigger-110"><i></i></span> 外周血管介入</a></li>
                        <li class=""><a data-toggle="tab" href="#home3"><span class="badge btn-yellow icon-heart bigger-110"><i></i></span> 综合介入</a></li>
                        <li class=""><a data-toggle="tab" href="#home4"><span class="purple icon-desktop bigger-110"><i></i></span> 系统管理</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="home1" class="tab-pane active">
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-success btn-small" style="width: 107px">整体数据分析</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="chart:view" id="chart:view" class="ace-switch ace-switch-6" value="chart:view" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                            </div>
                            <hr />
                            <dl />
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-yellow btn-small" style="width: 107px">颅内动脉瘤</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="artery:view" value="artery:view" id="artery:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="artery:add" id="artery:add" value="artery:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="artery:update" id="artery:update" value="artery:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="artery:delete" id="artery:delete" value="artery:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="artery:export" id="artery:export" value="artery:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="artery:import" id="artery:import" value="artery:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                            <hr />
                            <dl />
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-grey btn-small" style="width: 107px">脑动静脉畸形</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cerebral:view" id="cerebral:view" value="cerebral:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cerebral:add" id="cerebral:add" value="cerebral:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cerebral:update" id="cerebral:update" value="cerebral:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cerebral:delete" id="cerebral:delete" value="cerebral:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cerebral:export" id="cerebral:export" value="cerebral:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cerebral:import" id="cerebral:import" value="cerebral:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                            <hr />
                            <dl />
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-warning btn-small" style="width: 107px">脑血管狭窄</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="bloodvessel:view" id="bloodvessel:view" value="bloodvessel:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="bloodvessel:add" id="bloodvessel:add" value="bloodvessel:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="bloodvessel:update" id="bloodvessel:update" value="bloodvessel:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="bloodvessel:delete" id="bloodvessel:delete" value="bloodvessel:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="bloodvessel:export" id="bloodvessel:export" value="bloodvessel:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="bloodvessel:import" id="bloodvessel:import" value="bloodvessel:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div id="home2" class="tab-pane">
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-success btn-small" style="width: 107px">主动脉夹层</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="aorta:view" id="aorta:view" value="aorta:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="aorta:add" id="aorta:add" value="aorta:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="aorta:update" id="aorta:update" value="aorta:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="aorta:delete" id="aorta:delete" value="aorta:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="aorta:export" id="aorta:export" value="aorta:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="aorta:import" id="aorta:import" value="aorta:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                            <hr />
                            <dl />
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-yellow btn-small" style="width: 107px">肾动脉狭窄</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="kidney:view" id="kidney:view" value="kidney:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="kidney:add" id="kidney:add" value="kidney:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="kidney:update" id="kidney:update" value="kidney:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="kidney:delete" id="kidney:delete" value="kidney:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="kidney:export" id="kidney:export" value="kidney:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="kidney:import" id="kidney:import" value="kidney:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                            <hr />
                            <dl />
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-grey btn-small" style="width: 107px">四肢血管或瘘狭窄</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="arms:view" id="arms:view" value="arms:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="arms:add" id="arms:add" value="arms:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="arms:update" id="arms:update" value="arms:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="arms:delete" id="arms:delete" value="arms:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="arms:export" id="arms:export" value="arms:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="arms:import" id="arms:import" value="arms:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div id="home3" class="tab-pane">
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-success btn-small" style="width: 107px">肝癌</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cancer:view" id="cancer:view" value="cancer:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cancer:add" id="cancer:add" value="cancer:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cancer:update" id="cancer:update" value="cancer:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cancer:delete" id="cancer:delete" value="cancer:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cancer:export" id="cancer:export" value="cancer:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="cancer:import" id="cancer:import" value="cancer:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                            <hr />
                            <dl />
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-yellow btn-small" style="width: 107px">梗阻性黄疸</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="icterus:view" id="icterus:view" value="icterus:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="icterus:add" id="icterus:add" value="icterus:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="icterus:update" id="icterus:update" value="icterus:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="icterus:delete" id="icterus:delete" value="icterus:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="icterus:export" id="icterus:export" value="icterus:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="icterus:import" id="icterus:import" value="icterus:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                            <hr />
                            <dl />
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-grey btn-small" style="width: 107px">消化道梗阻</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="alimentary:view" id="alimentary:view" value="alimentary:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="alimentary:add" id="alimentary:add" value="alimentary:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="alimentary:update" id="alimentary:update" value="alimentary:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="alimentary:delete" id="alimentary:delete" value="alimentary:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="alimentary:export" id="alimentary:export" value="alimentary:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="alimentary:import" id="alimentary:import" value="alimentary:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div id="home4" class="tab-pane">
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-success btn-small" style="width: 107px">用户管理</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="user:view" id="user:view" value="user:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="user:add" id="user:add" value="user:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="user:update" id="user:update" value="user:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="user:delete" id="user:delete" value="user:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="user:export" id="user:export" value="user:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="user:import" id="user:import" value="user:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                            <hr />
                            <dl />
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-success btn-small" style="width: 107px">用户组管理</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="team:view" id="team:view" value="team:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="team:add" id="team:add" value="team:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="team:update" id="team:update" value="team:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="team:delete" id="team:delete" value="team:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="team:export" id="team:export" value="team:export" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导出</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="team:import" id="team:import" value="team:import" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">Excel导入</span>
                                    </label>
                                </div>
                            </div>
                            <hr />
                            <dl />
                            <div class="row">
                                <div class="span2">
                                    <span class="btn btn-yellow btn-small" style="width: 107px">权限管理</span>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="role:view" id="role:view" value="role:view" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">查看</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="role:add" id="role:add" value="role:add" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">新增</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="role:update" id="role:update" value="role:update" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">修改</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="role:delete" id="role:delete" value="role:delete" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">删除</span>
                                    </label>
                                </div>
                                <div class="span2">
                                    <label>
                                        <input name="role:permission" id="role:permission" value="role:permission" class="ace-switch ace-switch-6" type="checkbox">
                                        <span class="lbl">权限</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-actions">
                    <button class="btn btn-info" type="button" onclick="submitForm();">
                        <i class="icon-ok">
                        </i>
                        提交
                    </button>
                    <button class="btn" type="button" onclick="resetCheckbox();">
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


    <script>
    $(document).ready(function() {

        // 把现在的这个角色所具有的权限进行输出
        var permissions = '${role.permissions}';
        if (permissions != null && permissions != '') {
            var permissionArr = permissions.split(",");
            for (var i=0; i<permissionArr.length; i++) {
                var id = permissionArr[i].replace(":", "\\:");
                var val = $('#' + id);
                val.attr('checked', true);
            }
        }
    });

    function submitForm() {
        // 这里是将提交权限值到数据库里去
        var permissions = '';
        $('.ace-switch-6:checked').each(function(){
//            console.log($(this).val());
            var val = $(this).val();
            permissions = permissions + "," + val;

        });
        permissions = permissions.substring(1);
        $('#permissions').val(permissions);
        $('#inputForm').submit();
//        console.log(permissions);

    }

    function resetCheckbox() {
        $('.ace-switch-6:checked').each(function(){
//            console.log($(this).val());
            $(this).attr("checked",false);

        });
    }

</script>
</body>
</html>