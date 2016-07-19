<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<tiles:insertDefinition name="1-cols-main-definition">
	<tiles:putAttribute name="title">
		Rabiang.net
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<a href="<spring:url value="/" htmlEscape="true"/>">홈</a>
	</tiles:putAttribute>
</tiles:insertDefinition>
