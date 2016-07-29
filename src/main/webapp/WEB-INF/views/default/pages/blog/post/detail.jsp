<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../../common/inc.jspf" %>
<!-- Title -->
<h1>${post.title}</h1>

<%@ include file="./common/post_head.jspf" %>
	
<!-- Post Content -->
<div class="page">
    ${post.body}
</div>

<hr>

<div>
	<a class="btn btn-primary btn-sm" href="<spring:url value="/post/edit/${post.id}" htmlEscape="true"/>">
		<spring:message code="blog.edit" text="Edit"/>
	</a>
	<a class="btn btn-danger btn-sm" href="<spring:url value="/post/delete/${post.id}" htmlEscape="true"/>">
		<spring:message code="blog.delete" text="Delete"/>
	</a>
    <a class="btn btn-info btn-sm" href="<spring:url value="/post/index" htmlEscape="true"/>">
    	<spring:message code="blog.list" text="List"/>
	</a>
</div>
<hr>

<!-- Blog Comments -->

<!-- Comments Form -->
<div id="comments" class="well">
    <h4><spring:message code="blog.leave_a_comment" text="Leave a comment"/></h4>
    <form action="{{ url_for('page.post_detail_slug', slug=post.slug) }}"
          method="post" role="form" class="form-horizontal">        
        <div class="form-group">
            {{ form.name.label(class='col-sm-2 control-label') }}
            <div class="col-sm-10{% if form.name.errors %} has-error{% endif %}">
                {{ form.name(class='form-control') }}
                {% if form.name.errors %}
                    {% for error in form.name.errors %}
                        <span class="help-block">{{ error }}</span>
                    {% endfor %}
                {% endif %}
            </div>
        </div>
        <div class="form-group">
            {{ form.email.label(class='col-sm-2 control-label') }}
            <div class="col-sm-10{% if form.email.errors %} has-error{% endif %}">
                {{ form.email(class='form-control') }}
                {% if form.email.errors %}
                    {% for error in form.email.errors %}
                        <span class="help-block">{{ error }}</span>
                    {% endfor %}
                {% endif %}
            </div>
        </div>
        <div class="form-group">
            {{ form.body.label(class='col-sm-2 control-label') }}
            <div class="col-sm-10{% if form.body.errors %} has-error{% endif %}">
                {{ form.body(class='form-control') }}
                {% if form.body.errors %}
                    {% for error in form.body.errors %}
                        <span class="help-block">{{ error }}</span>
                    {% endfor %}
                {% endif %}
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10{% if form.recaptcha.errors %} has-error{% endif %}">
                {{ form.recaptcha(class='form-control') }}
                {% if form.recaptcha.errors %}
                    {% for error in form.recaptcha.errors %}
                        <span class="help-block">{{ error }}</span>
                    {% endfor %}
                {% endif %}
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10 col-md-offset-2">
                <button type="submit" class="btn btn-primary btn-sm">
                	<spring:message code="blog.save" text="Save"/>
                </button>
            </div>
        </div>

    </form>
</div>

<hr>

<!-- Posted Comments -->

<!-- Comment -->
<c:forEach var="comment" items="${comments}">
    <div class="media spacer-bottom-50" id="comment-${comment.id}">
        <a class="pull-left" href="#">
            <img class="media-object" src="" alt="">
        </a>
        <div class="media-body">
            <div class="spacer-left-10">
                <h4 class="media-heading">${comment.name}
                    <small>${comment.createdDate}</small>
                </h4>
                ${comment.body}
            </div>
        </div>
    </div>
</c:forEach>