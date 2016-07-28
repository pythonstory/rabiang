<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../common/inc.jspf"%>

<c:forEach var="tag" items="${tags}">
	<a href="<spring:url value="/tag/${tag.name}" htmlEscape="true" />" class="btn btn-default spacer-bottom-10">
		${tag.name}
		<span class="badge">${tag.count}</span>
	</a>
</c:forEach>