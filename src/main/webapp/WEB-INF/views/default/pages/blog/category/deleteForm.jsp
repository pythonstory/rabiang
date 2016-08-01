<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../common/inc.jspf" %>
<form action="<spring:url value="/catgory/delete/${category.id}" htmlEscape="true"/>" method="post">
    <fieldset>
        <legend><spring:message code="blog.delete_this_category" text="Delete this category?"/></legend>
        <button class="btn btn-danger">
			<spring:message code="blog.delete" text="Delete"/>
		</button>
		<a class="btn btn-default" href="<spring:url value="/category/detail/${category.id}" htmlEscape="true"/>">
			<spring:message code="blog.cancel" text="Cancel"/>
		</a>
    </fieldset>
</form>