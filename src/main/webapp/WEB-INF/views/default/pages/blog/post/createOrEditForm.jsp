<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../common/inc.jspf"%>
<spring:url value="/post/save" htmlEscape="true" var="saveActionUrl"/>
<form:form method="post" action="${saveActionUrl}" modelAttribute="form" cssClass="form-horizontal">
	<form:hidden path="id" />
	<spring:bind path="title">
		<div class="form-group">
			<form:label path="title" cssClass="col-sm-2 control-label">
				<spring:message code="blog.title" text="Title"/>
			</form:label>
			<div class="col-sm-10${status.error ? ' has-error' : ''}">
				<form:input path="title" cssClass="form-control"/>
				<c:if test="${status.error}">
					<form:errors path="title" cssClass="help-block"/>
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
					<form:errors path="slug" cssClass="help-block"/>
				</c:if>
			</div>
		</div>
	</spring:bind>
	<div class="form-group">
		<form:label path="category" cssClass="col-sm-2 control-label">
			<spring:message code="blog.category" text="Category"/>
		</form:label>
		<div class="col-sm-10">
			<form:input path="category" cssClass="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<form:label path="stage" cssClass="col-sm-2 control-label">
			<spring:message code="blog.stage" text="stage"/>
		</form:label>
		<div class="col-sm-10">
			<form:select path="stage" items="${statusList}" cssClass="form-control"/>
		</div>
	</div>
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
					<form:errors path="body" cssClass="help-block"/>
				</c:if>
			</div>
		</div>
	</spring:bind>
	<div class="form-group">
		<form:label path="title" cssClass="col-sm-2 control-label">
			<spring:message code="blog.tags" text="Tags"/>
		</form:label>
		<div class="col-sm-10">
			<form:input path="tagString" cssClass="form-control"/>
		</div>
	</div>
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

<script>
YUI().use(
	'aui-node',
	function (Y) {
	    var slug = Y.one('#slug');
	    var tagString = Y.one('#tagString');
	
	 	// slugify title automatically
	    slug.on(
	        'keyup',
	        function () {
	        	// Ignores all special characters and whitespaces but '-' dash.
	        	slug.val(slug.val()
		            .replace(/(^\s*)|(\s*$)/g, '')
		            .replace(/[\u2000-\u206F\u2E00-\u2E7F\\'!"#$%&()*+,.\/:;<=>?@\[\]^_`{|}~]/g, '')
		            .replace(/\s+/g, '-').toLowerCase());
	        }
	    );
	
	    // tagify
	    tagString.on(
	   		'keyup',
        	function() {
	   			// Ignores all special characters and whitespaces but ',' comma.
	   			tagString.val(tagString.val()
					.replace(/(^\s*)|(\s*$)/g, '')
					.replace(/[\u2000-\u206F\u2E00-\u2E7F\\'!"#$%&()*+\-.\/:;<=>?@\[\]^_`{|}~]/g, '')
					.replace(/\s+/g, '')
				);
           }
	    )
	}
);
</script>