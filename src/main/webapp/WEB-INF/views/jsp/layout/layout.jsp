<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/jquery.cleditor.css" rel="stylesheet" type="text/css">
    <link href="resources/css/global.css" rel="stylesheet">
    <link href="resources/css/dataTables.bootstrap.css" rel="stylesheet">
    <%--<link href="resources/css/jquery.dataTables.css" rel="stylesheet">--%>

    <script src="resources/js/jquery.js"></script>
	<script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/jquery.cleditor.js"></script>
    <script src="resources/js/model.js"></script>
    <script src="resources/js/jquery.dataTables.js"></script>
    <script src="resources/js/dataTables.bootstrap.js"></script>

    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="menu"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>
</body>
</html>