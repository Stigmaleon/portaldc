<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style type="text/css">
	#icon_home{
		height: 20px;
		padding: 3px;
	}
</style>

<script type="text/javascript">

$(function(){
	
	$("#homeButton").click(function(){
		window.location.href = "home";
	});
	
	$("#profileButton").click(function(){
		window.location.href = "profile";
	});
	
	$("#logoutButton").click(function(){
		window.location.href = "logout";
	});
});
	
</script>


<div class="globalMenu">
	<div class="btn-group">
		<button type="button" class="btn" id="homeButton"><span class="glyphicon glyphicon-home" id="icon_home"></span></button>
		<button type="button" class="btn" id="profileButton"><spring:message code="global_menu.profile"/></button>
		<button type="button" class="btn btn-primary" id="logoutButton"><spring:message code="global_menu.logout"/></button>
	</div>
</div>