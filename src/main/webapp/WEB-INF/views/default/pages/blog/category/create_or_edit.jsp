<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../common/inc.jspf"%>
<div class="row">
	<div class="col-md-6">
		<spring:url value="/category/save" htmlEscape="true" var="saveActionUrl"/>
		<form:form method="post" action="${saveActionUrl}" modelAttribute="form" cssClass="form-horizontal">
			<form:hidden path="id" />
			<spring:bind path="name">	
				<div class="form-group">
					<form:label path="name" cssClass="col-sm-3 control-label">
						<spring:message code="blog.name" text="Name"/>
					</form:label>
					<div class="col-sm-9${status.error ? ' has-error' : ''}">
						<form:input path="name" cssClass="form-control"/>
						<c:if test="${status.error}">
							<form:errors path="name" cssClass="help-block"/>
						</c:if>
					</div>
				</div>
			</spring:bind>
			<spring:bind path="slug">
				<div class="form-group">
					<form:label path="slug" cssClass="col-sm-3 control-label">
						<spring:message code="blog.slug" text="Slug"/>
					</form:label>
					<div class="col-sm-9${status.error ? ' has-error' : ''}">
						<form:input path="slug" cssClass="form-control"/>
						<c:if test="${status.error}">
							<form:errors path="slug" cssClass="help-block"/>
						</c:if>
					</div>
				</div>
			</spring:bind>
			<spring:bind path="order">
				<div class="form-group">
					<form:label path="order" cssClass="col-sm-3 control-label">
						<spring:message code="blog.sort_order" text="Sort order"/>
					</form:label>
					<div class="col-sm-9${status.error ? ' has-error' : ''}">
						<form:input path="order" cssClass="form-control"/>
						<c:if test="${status.error}">
							<form:errors path="order" cssClass="help-block"/>
						</c:if>
					</div>
				</div>
			</spring:bind>
			<spring:bind path="parent">
				<div class="form-group">
					<form:label path="parent" cssClass="col-sm-3 control-label">
						<spring:message code="blog.parent_category" text="Parent category"/>
					</form:label>
					<div
						class="col-sm-9${status.error ? ' has-error' : ''}">
						<form:input path="parent" cssClass="form-control"/>
						<c:if test="${status.error}">
							<form:errors path="parent" cssClass="help-block"/>
						</c:if>
					</div>
				</div>
			</spring:bind>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<button type="submit" class="btn btn-sm btn-primary">
						<spring:message code="blog.save" text="Save"/>
					</button>
					<a href="<spring:url value="/category/index" htmlEscape="true" />" class="btn btn-sm btn-default">
						<spring:message code="blog.cancel" text="Cancel"/>
					</a>
				</div>
			</div>
		</form:form>
	</div>
	<div class="col-md-6">
		<table class="table table-striped">
			<tr>
				<th><spring:message code="blog.categories" text="Categories"/></th>
				<th><spring:message code="blog.actions" text="Actions"/></th>
			</tr>
			{% for id, name, level in categories %}
			<tr>
				<td>{{ ('&nbsp;&nbsp;&nbsp;&nbsp;' | safe) * level }}{{ name }}</td>
				<td>
					<a href="{{ url_for('page.category_edit', category_id=id) }}" class="btn btn-sm btn-primary">
						<spring:message code="blog.edit" text="Edit"/>
					</a>
					<a href="{{ url_for('page.category_delete', category_id=id) }}" class="btn btn-sm btn-danger">
						<spring:message code="blog.delete" text="Delete"/>
					</a>
				</td>
			</tr>
			{% endfor %}
		</table>
	</div>
</div>