<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../../common/inc.jspf"%>

<c:forEach var="node" items="${node.children}" varStatus="status">
	<c:if test="${status.first}">
		<ul>
	</c:if>
			<li>
				<a href="<spring:url value="/category/${node.data}" htmlEscape="true"/>">
					${node.data}
				</a>
			</li>
			<c:set var="node" value="${node}" scope="request" />
			<jsp:include page="./node.jsp" />
	<c:if test="">
		</ul>
	</c:if>
</c:forEach>
