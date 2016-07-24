<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../common/inc.jspf"%>
<spring:url value="/post/save" htmlEscape="true" var="saveActionUrl"/>
<form:form method="post" action="${saveActionUrl}" modelAttribute="post" cssClass="form-horizontal">
	<form:hidden path="id" />
	<spring:bind path="title">
		<div class="form-group">
			<form:label path="title" cssClass="col-sm-2 control-label">
				<spring:message code="blog.title" text="Title"/>
			</form:label>
			<div class="col-sm-10${status.error ? ' has-error' : ''}">
				<form:input path="title" cssClass="form-control"/>
				<c:if test="${status.error}">
					<span class="help-block"><form:errors path="title" /></span>
				</c:if>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="slug">
		<div class="form-group">
			<form:label path="slug" cssClass="col-sm-2 control-label">
				<spring:message code="blog.slug" text="Slug"/>
			</form:label>
			<div class="col-sm-10${status.error ? ' has-error' : ''}">
				<form:input path="slug" cssClass="form-control"/>
				<c:if test="${status.error}">
					<span class="help-block"><form:errors path="slug" /></span>
				</c:if>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="status">
		<div class="form-group">
			<form:label path="status" cssClass="col-sm-2 control-label">
				<spring:message code="blog.status" text="Status"/>
			</form:label>
			<div class="col-sm-10${status.error ? ' has-error' : ''}">
				<form:select path="status" items="${statusList}" cssClass="form-control"/>
				<c:if test="${status.error}">
					<span class="help-block"><form:errors path="status" /></span>
				</c:if>
			</div>
		</div>
	</spring:bind>
	<div class="form-group">
		<form:label path="format" cssClass="col-sm-2 control-label">
			<spring:message code="blog.format" text="Format"/>
		</form:label>
		<div class="col-sm-10">
			<form:select path="format" items="${formatList}" cssClass="form-control"/>
		</div>
	</div>
	<spring:bind path="body">
		<div class="form-group">
			<form:label path="body" cssClass="col-sm-2 control-label">
				<spring:message code="blog.body" text="Body"/>
			</form:label>
			<div class="col-sm-10${status.error ? ' has-error' : ''}">
				<form:textarea path="body" rows="10" cssClass="form-control"/>
				<c:if test="${status.error}">
					<span class="help-block"><form:errors path="body" /></span>
				</c:if>			
			</div>
		</div>
	</spring:bind>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">
				<spring:message code="blog.save" text="Save"/>
			</button>
			<a href="<spring:url value="/post/index" htmlEscape="true"/>" class="btn btn-default">
				<spring:message code="blog.cancel" text="Cancel"/>
			</a>
		</div>
	</div>
</form:form>