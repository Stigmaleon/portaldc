<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
	<form role="form" class="register_form">
			<input type="text" class="form-control" id="loginInput" placeholder="<spring:message code="main.login" />">
			<input type="email" class="form-control" id="emailInput" placeholder="<spring:message code="main.email" />">
			<input type="password" class="form-control" id="passInput" placeholder="<spring:message code="main.password" />">
			<input type="password" class="form-control" id="passRepeat" placeholder="<spring:message code="main.password_repeat" />">		
	</form>
	<button class="btn btn-primary btn-block register_button">
			<spring:message code="register_page.register" />
	</button>


</div>