<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
$(function(){
	var User = function(login, email, password){
		this.login = login;
		this.email = email;
		this.password = password;
	};
	
	$("#registerButton").click(function(){
		var checkedPassword;
		if($("#passInput").val() === $("#passRepeat").val()){
			checkedPassword = $("#passInput").val();
			$(".alert").hide();
		} else {			
			$(".alert").show();
			return;
		}
		
		var newUser = new User(
				$("#loginInput").val(),
				$("#emailInput").val(),
				checkedPassword);
		
		$.ajax({
			type: "POST",
			datatype: "json",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(newUser),
			url: "user/register",
			success: function(response) {
				console.log(response);
                window.location.href = "login.jsp";
			}
		});
		
	});
	
	$("#loginButton").click(function(){
		window.location.href = "login";
	});
	
});
</script>

<div class="container">
	<form role="form" class="register_form">
			<input type="text" class="form-control" id="loginInput" placeholder="<spring:message code="main.login" />">
			<input type="email" class="form-control" id="emailInput" placeholder="<spring:message code="main.email" />">
			<input type="password" class="form-control" id="passInput" placeholder="<spring:message code="main.password" />">
			<input type="password" class="form-control" id="passRepeat" placeholder="<spring:message code="main.password_repeat" />">		
	</form>
	<button class="btn btn-primary btn-block register_button" id="registerButton">
			<spring:message code="register_page.register" />
	</button>
	<button class="btn btn-primary btn-block register_button" id="loginButton">
			<spring:message code="page_login.enter_button"/>
	</button>
	<div class="alert alert-warning fade in" role="alert" style="display:none;">
		
		<spring:message code="register_page.different_password" />
	</div>


</div>