<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../common/inc.jspf"%>
<spring:url value="/post/save" htmlEscape="true" var="saveActionUrl"/>
<form:form method="post" action="${saveActionUrl}" modelAttribute="form" cssClass="form-horizontal">
	<form:hidden path="id" />
	<div class="form-group">
		<form:label path="title" cssClass="col-sm-1 control-label">title</form:label>
		<div class="col-sm-11">
			<form:input path="title" id="post_title" cssClass="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<form:label path="slug" cssClass="col-sm-1 control-label">slug</form:label>
		<div class="col-sm-11">
			<form:input path="slug" id="post_slug" cssClass="form-control"/>
		</div>
	</div>	
	<div class="form-group">
		<form:label path="status" cssClass="col-sm-1 control-label">status</form:label>
		<div class="col-sm-11">
			<form:input path="status" cssClass="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<form:label path="format" cssClass="col-sm-1 control-label">format</form:label>
		<div class="col-sm-11">
			<form:input path="format" cssClass="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<form:label path="body" cssClass="col-sm-1 control-label">body</form:label>
		<div class="col-sm-11">
			<form:input path="body" cssClass="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-1 col-sm-11">
			<button type="submit" class="btn btn-primary">save</button>
			<a href="<spring:url value="/post/index" htmlEscape="true"/>" class="btn btn-default">cancel</a>
		</div>
	</div>
</form:form>