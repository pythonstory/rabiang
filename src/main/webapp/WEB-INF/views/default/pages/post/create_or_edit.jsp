<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../common/inc.jspf"%>
<spring:url value="/post/save" htmlEscape="true" var="saveActionUrl"/>
<form:form method="post" action="${saveActionUrl}" modelAttribute="post" cssClass="form-horizontal">
	<form:hidden path="id" />
	<div class="form-group">
		<form:label path="title" cssClass="col-sm-2 control-label"><spring:message code="blog.title" text="Title"/></form:label>
		<div class="col-sm-10">
			<form:input path="title" id="post_title" cssClass="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<form:label path="slug" cssClass="col-sm-2 control-label"><spring:message code="blog.slug" text="Slug"/></form:label>
		<div class="col-sm-10">
			<form:input path="slug" id="post_slug" cssClass="form-control"/>
		</div>
	</div>	
	<div class="form-group">
		<form:label path="status" cssClass="col-sm-2 control-label"><spring:message code="blog.status" text="Status"/></form:label>
		<div class="col-sm-10">
			<form:input path="status" cssClass="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<form:label path="format" cssClass="col-sm-2 control-label"><spring:message code="blog.format" text="Format"/></form:label>
		<div class="col-sm-10">
			<form:input path="format" cssClass="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<form:label path="body" cssClass="col-sm-2 control-label"><spring:message code="blog.body" text="Body"/></form:label>
		<div class="col-sm-10">
			<form:textarea path="body" rows="10" cssClass="form-control"/>			
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary"><spring:message code="blog.save" text="Save"/></button>
			<a href="<spring:url value="/post/index" htmlEscape="true"/>" class="btn btn-default"><spring:message code="blog.cancel" text="Cancel"/></a>
		</div>
	</div>
</form:form>