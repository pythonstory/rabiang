<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../common/inc.jspf"%>
<spring:url value="/post/delete/${post.id}" htmlEscape="true" var="deleteActionUrl"/>
<form:form action="${deleteActionUrl}" method="post">
	<fieldset>
		<legend>
			<spring:message code="blog.delete_this_post" text="Delete this post?"/>
		</legend>
		<button class="btn btn-danger">
			<spring:message code="blog.delete" text="Delete"/>
		</button>
		<a class="btn btn-default" href="<spring:url value="/post/detail/${post.id}" htmlEscape="true"/>">
			<spring:message code="blog.cancel" text="Cancel"/>
		</a>
	</fieldset>
</form:form>