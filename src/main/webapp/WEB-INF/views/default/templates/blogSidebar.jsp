<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/inc.jspf"%>
<!-- Blog Search Well -->
<div class="well">
	<h4><spring:message code="blog.search" text="Search"/></h4>
	<form action="<spring:url value="/post/index" htmlEscape="true"/>" method="get" class="form-inline">
		<div class="input-group">
			<input type="text" class="form-control" name="q" value="${param.q}">
			<span class="input-group-btn">
				<button class="btn btn-default" type="submit">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</span>

		</div>
	</form>
	<!-- /.input-group -->
</div>

<!-- Blog Categories Well -->
<div class="well">
	<h4><spring:message code="blog.categories" text="Categories"/></h4>
	<ul class="list_outer">
		<li><i class="fa fa-angle-double-right"></i> <a
			href="/page/category/Flask"> Flask </a>
			<ul class="list">
				<li>
					<i class="fa fa-angle-double-right"></i>
					<a href="/page/category/depth1"> depth1 </a>
					<ul class="list">
						<li>
							<i class="fa fa-angle-double-right"></i>
							<a href="/page/category/depth2"> depth2 </a>
						</li>
					</ul>
				</li>
			</ul>
		</li>
	</ul>
</div>

<!-- Side Widget Well -->
<div class="well">
	<h4><spring:message code="blog.recent_posts" text="Recent posts"/></h4>
	<ul class="list_outer">
		<c:forEach var="post" items="${recentPosts}">
			<li>
				<a href="<spring:url value="/post/${post.slug}" htmlEscape="true"/>">
				<i class="fa fa-angle-double-right"></i> ${post.title}</a>
			</li>
		</c:forEach>
	</ul>
</div>

<div class="well">
	<h4><spring:message code="blog.recent_comments" text="Recent comments"/></h4>
	<ul class="list_outer">
		<li>
			<a href="/page/tttt"><i class="fa fa-angle-double-right"></i> tttt</a>
		</li>
	</ul>
</div>

<div class="well">
	<h4><spring:message code="blog.tags" text="Tags"/></h4>
	<p>
		<c:forEach var="tag" items="${tags}">
			<a href="<spring:url value="/tag/${tag.name}" htmlEscape="true"/>" class="btn btn-sm btn-default spacer-bottom-10">
				${tag.name}
				<span class="badge">${tag.count}</span>
			</a>
		</c:forEach>		
	</p>
</div>

<div class="well">
	<h4><spring:message code="blog.archives" text="Archives"/></h4>
	<ul class="list_outer">
		<li>
			<a href="/page/month/2016/7"><i class="fa fa-angle-double-right"></i> 2016년 7월</a>
		</li>
	</ul>
</div>
