<%@tag pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<div class="nav dropdown pull-right">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
    	排序: ${sortTypes[param.sortType]} <b class="caret"></b>
    </a>
	<ul class="dropdown-menu" >
	   	<c:forEach items="${sortTypes}" var="entry">
	   		<li><a href="?sortType=${entry.key}&${searchParams}">${entry.value}</a></li>
		</c:forEach>
	</ul>
</div>--%>

<div class="btn-group pull-right">
    <button class="btn btn-small btn-primary">
        排序:${sortTypes[param.sortType]}
    </button>
    <button data-toggle="dropdown" class="btn btn-small btn-primary dropdown-toggle icon-angle-down">
        <%--<i class="icon-angle-down" />--%>
    </button>
    <ul class="dropdown-menu">
        <c:forEach items="${sortTypes}" var="entry">
            <li><a href="?sortType=${entry.key}&${searchParams}">${entry.value}</a></li>
        </c:forEach>
    </ul>
</div>