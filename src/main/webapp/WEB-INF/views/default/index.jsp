<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Rabiang.net</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="<spring:url value="/resources/default/images/apple-touch-icon.png" htmlEscape="true"/>">
    <link rel="shortcut icon" href="<spring:url value="/resources/default/images/favicon.ico" htmlEscape="true"/>">

    <!-- AUI/Bootstrap Core CSS -->
    <link rel="stylesheet" href="//cdn.alloyui.com/3.0.1/aui-css/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<spring:url value="/resources/default/css/main.css" htmlEscape="true"/>">
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="<spring:url value="/vendors/modernizr-2.8.3-respond-1.4.2.min.js"/>"></script>
    <![endif]-->
</head>
<body>
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser.
    Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve
    your experience.</p>
<![endif]-->

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
            <a class="navbar-brand" href="/">Rabiang.net</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/page/index">블로그</a>
                </li>
                
                <li>
                    <a href="/auth/login">로그인</a>
                </li>
                <li>
                    <a href="/auth/register">회원가입</a>
                </li>
                
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="container">
    
    <div class="row">
        <div class="col-sm-12">
            <a href="<spring:url value="/" htmlEscape="true"/>">홈</a>            
        </div>
    </div>

</div> <!-- /container -->

<footer>
    <div class="container">
        <div class="row">
            <hr>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <p>&copy; Pythonstory 2016</p>
            </div>
            <div class="col-sm-6 text-right">
			    <a class="btn btn-default" href="https://www.facebook.com"><i class="fa fa-facebook"></i></a>
                <a class="btn btn-default" href="https://www.twitter.com"><i class="fa fa-twitter"></i></a>
                <a class="btn btn-default" href="https://www.linkedin.com"><i class="fa fa-linkedin"></i></a>
                <a class="btn btn-default" href="https://www.plus.google.com"><i class="fa fa-google-plus"></i></a>
                <a class="btn btn-default" href="https://www.youtube.com"><i class="fa fa-youtube"></i></a>
                <a class="btn btn-default" href="https://www.github.com/pythonstory"><i class="fa fa-github"></i></a>
                <a class="btn btn-default" href="/page/feed"><i class="fa fa-rss"></i></a>
            </div>
        </div>
    </div>
</footer><!-- /container -->

<!-- AUI -->
<script src="//cdn.alloyui.com/3.0.1/aui/aui-min.js"></script>
<script src="<spring:url value="/resources/default/js/main.js" htmlEscape="true"/>"></script>

<!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
<script>
    (function (b, o, i, l, e, r) {
        b.GoogleAnalyticsObject = l;
        b[l] || (b[l] =
                function () {
                    (b[l].q = b[l].q || []).push(arguments)
                });
        b[l].l = +new Date;
        e = o.createElement(i);
        r = o.getElementsByTagName(i)[0];
        e.src = '//www.google-analytics.com/analytics.js';
        r.parentNode.insertBefore(e, r)
    }(window, document, 'script', 'ga'));
    ga('create', 'UA-XXXXX-X', 'auto');
    ga('send', 'pageview');
</script>
</body>
</html>