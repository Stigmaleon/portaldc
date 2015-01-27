<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css">
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.css">

    <script src="resources/js/libs/jquery.js"></script>
    <script src="resources/js/libs/bootstrap.js"></script>
    <%--<script src="resources/js/libs/bootstrap.min.js"></script>--%>

    <script src="resources/js/libs/angular/angular.js"></script>
    <script src="resources/js/libs/angular/angular-animate.js"></script>
    <script src="resources/js/libs/angular/angular-cookies.js"></script>
    <script src="resources/js/libs/angular/angular-route.js"></script>
    <script src="resources/js/libs/angular/angular-translate.js"></script>
    <script src="resources/js/libs/angular/angular-translate-loader-partial.js"></script>
    <script src="resources/js/libs/angular/angular-translate-loader-static-files.js"></script>
    <script src="resources/js/libs/angular/angular-translate-loader-url.js"></script>
    <script src="resources/js/libs/angular/angular-translate-storage-cookie.js"></script>
    <script src="resources/js/libs/angular/angular-translate-storage-local.js"></script>

    <script src="resources/js/controller/main.js"></script>
    <script src="resources/js/controller/home.js"></script>
    <script src="resources/js/controller/translate.js"></script>

    <script src="resources/js/directives.js"></script>
    <script src="resources/js/factories.js"></script>

    <script src="resources/js/app.js"></script>
</head>
<body ng-app="portalDC" ng-controller="AppCtrl" ng-init="init()">
    <div ng-view ng-controller="TranslateCtrl"></div>
</body>
</html>
