<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/inc.jspf"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<spring:url value="/" htmlEscape="true"/>">Rabiang</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="<spring:url value="/post/index" htmlEscape="true"/>"><spring:message code="blog" text="Blog"/></a>
				</li>
				<li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        username <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                    	<li>
							<a href="{{ url_for('auth.logout') }}"><spring:message code="site.logout" text="Logout"/></a>
						</li>
						<li>
							<a href="{{ url_for('auth.change_password') }}"><spring:message code="site.change_password" text="Change password"/></a>
						</li>
						<li>
							<a href="{{ url_for('auth.unregister') }}"><spring:message code="site.unregister" text="Delete account"/></a>
						</li>
						<li>
							<a href="<spring:url value="/post/create" htmlEscape="true"/>"><spring:message code="blog.new_post" text="Write a new post"/></a>
						</li>
						<li>
							<a href="{{ url_for('page.category_create') }}"><spring:message code="blog.edit_categories" text="Edit categories"/></a>
						</li>
					</ul>
                </li>
				<li>
					<a href="<spring:url value="/auth/login" htmlEscape="true"/>"><spring:message code="site.login" text="Login"/></a>
				</li>
				<li>
					<a href="<spring:url value="/auth/register" htmlEscape="true"/>"><spring:message code="site.sign_up" text="Sign up"/></a>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
