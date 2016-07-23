<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../common/inc.jspf" %>
<c:forEach var="post" items="${page.content}">
	<h2>
	    <a href="<spring:url value="/post/${post.slug}" htmlEscape="true"/>">${post.title}</a>
	</h2>
	<p class="lead">
		<ul class="list-inline post_head">
		    <li><i class="fa fa-calendar" aria-hidden="true"></i>
		        ${post.createdDate}
		    </li>
		    <li><i class="fa fa-user" aria-hidden="true"></i>
		        <a href="<spring:url value="/post/user/" htmlEscape="true"/>">
		            username
		        </a>
		    </li>
		    <li><i class="fa fa-folder-open-o" aria-hidden="true"></i>
		        <a href="<spring:url value="/post/category/" htmlEscape="true"/>">
		            category name
		        </a>
		    </li>
		    <li><i class="fa fa-comments" aria-hidden="true"></i>
		        <a href="<spring:url value="/post/${post.slug}" htmlEscape="true"/>#comments">
		            19
		        </a>
		    </li>
		    <li><i class="fa fa-link" aria-hidden="true"></i>
		        <a href="<spring:url value="/post/detail/${post.id}" htmlEscape="true"/>">
		            permalink
		        </a>
		    </li>
		</ul>
	</p>
	
	<p>
	    <i class="fa fa-tag" aria-hidden="true"></i>
	    
	    <a href="{{ url_for('page.tag_detail', tag_name=tag.name) }}" class="label label-default">tag-name</a>
	    
	</p>
	
	<hr>
	<p>${post.body}</p>
	<p class="lead">
	    <a class="btn btn-info btn-sm" href="<spring:url value="/post/${post.slug}" htmlEscape="true"/>">
			Read More <span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</p>
	<hr>
</c:forEach>
<%@include file="./common/pagination.jspf"%>
