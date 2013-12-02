<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="sidebar" id="sidebar">
<script type="text/javascript">
    try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
</script>

<div class="sidebar-shortcuts" id="sidebar-shortcuts">
    <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
        <button class="btn btn-small btn-success">
            <i class="icon-signal"></i>
        </button>

        <button class="btn btn-small btn-info">
            <i class="icon-pencil"></i>
        </button>

        <button class="btn btn-small btn-warning">
            <i class="icon-group"></i>
        </button>

        <button class="btn btn-small btn-danger">
            <i class="icon-cogs"></i>
        </button>
    </div>

    <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
        <span class="btn btn-success"></span>

        <span class="btn btn-info"></span>

        <span class="btn btn-warning"></span>

        <span class="btn btn-danger"></span>
    </div>
</div><!-- #sidebar-shortcuts -->

    <ul class="nav nav-list">

        <shiro:hasPermission name="chart:view">
            <li <c:if test="${indexActive != null}">class="active"</c:if>>
                <a href="${ctx}/">
                    <i class="icon-dashboard"></i>
                    <span class="menu-text">整体数据分析</span>

                </a>
            </li>
        </shiro:hasPermission>

        <!--
        <li <c:if test="${baseInfoActive != null}">class="active"</c:if>>
            <a href="${ctx}/baseInfo">
                <i class="icon-key"></i>
                <span>病患基本信息</span>
            </a>
        </li>
        -->

        <shiro:hasPermission name="mind:view">
            <li <c:if test="${arteryInfoActive != null}">class="active open"</c:if>>
                <a href="#" class="dropdown-toggle">
                    <i class="icon-briefcase"></i>
                    <span class="menu-text">神经介入</span>
                    <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                    <shiro:hasPermission name="artery:view">
                        <li <c:if test="${arteryInfoActive != null}">class="active"</c:if>><a href="${ctx}/artery/"><i class="icon-double-angle-right"></i>颅内动脉瘤</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="cerebral:view">
                        <li <c:if test="${baseInfo1 != null}">class="active"</c:if>><a href="${ctx}/baseInfo"><i class="icon-double-angle-right"></i> 脑动静脉畸形</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="bloodvessel:View">
                        <li <c:if test="${baseInfo2 != null}">class="active"</c:if>><a href="${ctx}/baseInfo"><i class="icon-double-angle-right"></i> 脑血管狭窄</a></li>
                    </shiro:hasPermission>
                </ul>
            </li>
        </shiro:hasPermission>

        <shiro:hasPermission name="cube:view">
            <li <c:if test="${baseInfoActive2 != null}">class="active open"</c:if>>
                <a href="#" class="dropdown-toggle">
                    <i class="icon-beaker"></i>
                    <span class="menu-text">外周血管介入</span>
                    <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                    <shiro:hasPermission name="aorta:view">
                        <li <c:if test="${baseInfoActive2 != null}">class="active"</c:if>><a href="${ctx}/baseInfo"><i class="icon-double-angle-right"></i>主动脉夹层</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="kidney:view">
                        <li <c:if test="${baseInfo1 != null}">class="active"</c:if>><a href="${ctx}/baseInfo"><i class="icon-double-angle-right"></i> 肾动脉狭窄</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="arms:view">
                        <li <c:if test="${baseInfo2 != null}">class="active"</c:if>><a href="${ctx}/baseInfo"><i class="icon-double-angle-right"></i> 四肢血管或瘘狭窄</a></li>
                    </shiro:hasPermission>
                </ul>
            </li>
        </shiro:hasPermission>

        <shiro:hasPermission name="all:view">
            <li <c:if test="${icterusActive != null}">class="active open"</c:if>>
                <a href="#" class="dropdown-toggle">
                    <i class="icon-heart"></i>
                    <span class="menu-text">综合介入</span>
                    <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                    <shiro:hasPermission name="cancer:view">
                        <li <c:if test="${baseInfoActive != null}">class="active"</c:if>><a href="${ctx}/baseInfo"><i class="icon-double-angle-right"></i>肝癌</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="icterus:view">
                        <li <c:if test="${icterusActive != null}">class="active"</c:if>><a href="${ctx}/icterus/"><i class="icon-double-angle-right"></i> 梗阻性黄疸</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="alimentary:view">
                        <li <c:if test="${baseInfo2 != null}">class="active"</c:if>><a href="${ctx}/baseInfo"><i class="icon-double-angle-right"></i> 消化道梗阻</a></li>
                    </shiro:hasPermission>
                </ul>
            </li>
        </shiro:hasPermission>

        <shiro:hasPermission name="system:view">
            <li <c:if test="${userActive != null || teamActive != null || roleActive != null}">class="active open"</c:if>>
                <a href="#" class="dropdown-toggle">
                    <i class="icon-desktop"></i>
                    <span class="menu-text">系统管理</span>
                    <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                    <shiro:hasPermission name="user:view">
                        <li <c:if test="${userActive != null}">class="active"</c:if>><a href="${ctx}/account/user/"><i class="icon-double-angle-right"></i> 用户管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="team:view">
                        <li <c:if test="${teamActive != null}">class="active"</c:if>><a href="${ctx}/account/team/"><i class="icon-double-angle-right"></i> 用户组管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="role:view">
                        <li <c:if test="${roleActive != null}">class="active"</c:if>><a href="${ctx}/role"><i class="icon-double-angle-right"></i> 权限管理</a></li>
                    </shiro:hasPermission>
                </ul>
            </li>
        </shiro:hasPermission>

        <shiro:hasPermission name="setting:view">
            <li <c:if test="${tableActive != null || menuActive != null}">class="active open"</c:if>>
                <a href="#" class="dropdown-toggle">
                    <i class="icon-desktop"></i>
                    <span class="menu-text">系统配置</span>
                    <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                    <shiro:hasPermission name="user:view">
                        <li <c:if test="${menuActive != null}">class="active"</c:if>><a href="${ctx}/menu/"><i class="icon-double-angle-right"></i> 菜单管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="table:view">
                        <li <c:if test="${tableActive != null}">class="active"</c:if>><a href="${ctx}/table/"><i class="icon-double-angle-right"></i> 表管理</a></li>
                    </shiro:hasPermission>
                </ul>
            </li>
        </shiro:hasPermission>



    </ul><!--/.nav-list-->
<div class="sidebar-collapse" id="sidebar-collapse">
    <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
</div>

<script type="text/javascript">
    try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
</script>
</div>