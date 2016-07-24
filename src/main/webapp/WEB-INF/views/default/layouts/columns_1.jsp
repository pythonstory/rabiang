<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/inc.jspf" %>
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
    <title>${title} - Rabiang.net</title>
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
<p class="browserupgrade">
	You are using an <strong>outdated</strong> browser.
    Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.
</p>
<![endif]-->

<tiles:insertAttribute name="navigation"/>

<div class="container">
    
    <div class="row">
        <div class="col-sm-12">
        	<tiles:insertAttribute name="body"/>
        </div>
    </div>

</div> <!-- /container -->

<tiles:insertAttribute name="footer"/>


<!-- AUI -->
<script src="//cdn.alloyui.com/3.0.1/aui/aui-min.js"></script>
<script src="<spring:url value="/resources/default/js/main.js" htmlEscape="true"/>"></script>
<script src="<spring:url value="/resources/default/js/google_analytics.js" htmlEscape="true"/>"></script>
</body>
</html>