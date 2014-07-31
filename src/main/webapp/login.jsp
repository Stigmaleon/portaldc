<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/global.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>

<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
    <!--DONT WORK -->
<script type="text/javascript">
    $("button_register").click(function(){
        window.location.href = "register.jsp";
    });
</script>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="j_spring_security_check" method="post">
			<h3>
				<spring:message code="page_login.info" />
			</h3>
			<input type="text" class="form-control"
				placeholder="<spring:message code="page_login.login"/>" autofocus name="j_username">
			<input type="password" class="form-control"
				placeholder="<spring:message code="page_login.password"/>" name="j_password">
			<button class="btn btn-lg btn-primary btn-block"
				id="button_login" type="submit" name="submit">
				<spring:message code="page_login.enter_button" />
			</button>
            <button class="btn btn-lg btn-primary btn-block" type="button"
                    id="button_register" name="register">
                <spring:message code="register_page.register" />
            </button>
		</form>
	</div>
</body>
</html>