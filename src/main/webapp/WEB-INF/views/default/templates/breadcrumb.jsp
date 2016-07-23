<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/inc.jspf"%>
<c:if test="${not empty breadcrumb}">
	<div class="container">
		<ol class="breadcrumb">
			<c:forEach var="link" items="${breadcrumb}">
				<li>
					<c:choose>
						<c:when test="${not empty link['href']}">
							<a href="<spring:url value="${link['href']}" htmlEscape="true"/>"><c:out value="${link['text']}"/></a>
						</c:when>
						<c:otherwise>
							<c:out value="${link['text']}"/>
						</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
		</ol>
	</div>
</c:if>
