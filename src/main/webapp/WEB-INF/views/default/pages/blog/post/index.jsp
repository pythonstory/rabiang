<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../common/inc.jspf" %>
<c:forEach var="post" items="${page.content}">
	<h2>
	    <a href="<spring:url value="/post/${post.slug}" htmlEscape="true"/>">${post.title}</a>
	</h2>
	
	<%@ include file="./common/postHead.jspf" %>

	<p>${post.body}</p>
	<p class="lead">
	    <a class="btn btn-info btn-sm" href="<spring:url value="/post/${post.slug}" htmlEscape="true"/>">
			<spring:message code="blog.read_more" text="Read more"/>
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</p>
	<hr>
</c:forEach>
<%@include file="./common/pagination.jspf"%>
