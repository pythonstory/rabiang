<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../common/inc.jspf" %>
<!-- Title -->
<h1>${post.title}</h1>

<!-- Date/Time, Author, Categories, Tags, ... -->
<p class="lead">
<ul class="list-inline post_head">
    <li>
    	<i class="fa fa-calendar" aria-hidden="true"></i>
    	${post.createdDate}
    </li>
    <li>
    	<i class="fa fa-user" aria-hidden="true"></i>
        <a href="<spring:url value="/post/user/" htmlEscape="true"/>">username</a>
    </li>
    <li>
    	<i class="fa fa-folder-open-o" aria-hidden="true"></i>
        <a href="<spring:url value="/post/category/" htmlEscape="true"/>">category.name</a>
    </li>
    <li>
    	<i class="fa fa-comments" aria-hidden="true"></i>
        <a href="<spring:url value="/post/${post.slug}" htmlEscape="true"/>#comments">19</a>
    </li>
    <li>
    	<i class="fa fa-link" aria-hidden="true"></i>
        <a href="<spring:url value="/post/detail/${post.id}" htmlEscape="true"/>">permalink</a>
    </li>
</ul>
</p>

<p>
	<i class="fa fa-tag" aria-hidden="true"></i>
	    
	<a href="{{ url_for('page.tag_detail', tag_name=tag.name) }}" class="label label-default">tag-name</a>
	    
</p>
	
<hr>

<!-- Post Content -->
<div class="page">
    ${post.body}
</div>

<hr>

<div>
	<a class="btn btn-primary btn-sm" href="{{ url_for('page.post_edit', post_id=post.id) }}">Edit</a>
	<a class="btn btn-danger btn-sm" href="{{ url_for('page.post_delete', post_id=post.id) }}">Delete</a>
    <a class="btn btn-info btn-sm" href="{{ url_for('page.post_index') }}">List</a>
</div>
<hr>

<!-- Blog Comments -->

<!-- Comments Form -->
<div id="comments" class="well">
    <h4>{{ _('Leave a Comment') }}</h4>
    <form action="{{ url_for('page.post_detail_slug', slug=post.slug) }}"
          method="post" role="form" class="form-horizontal">
        {{ form.csrf_token }}
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
                <button type="submit"
                        class="btn btn-primary btn-sm">{{ _('Save') }}</button>
            </div>
        </div>

    </form>
</div>

<hr>

<!-- Posted Comments -->

<!-- Comment -->
{% for comment in comments %}
    <div class="media spacer-bottom-50" id="comment-{{ comment.id }}">
        <a class="pull-left" href="#">
            <img class="media-object" src="{{ comment.name | gravatar(size=64) }}"
                 alt="">
        </a>
        <div class="media-body">
            <div class="spacer-left-10">
                <h4 class="media-heading">{{ comment.name }}
                    <small>{{ comment.created_timestamp | datetimeformat(format='short') }}</small>
                </h4>
                {{ comment.body | markdown }}
            </div>
        </div>
    </div>
{% endfor %}