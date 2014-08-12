<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style type="text/css">
	#icon_home{
		height: 20px;
		padding: 3px;
	}
</style>

<script type="text/javascript">

$(function(){

    $.ajax({
        type: "GET",
        datatype: "json",
        contentType: "application/json; charset=utf-8",
        url: "getCategories",
        success: function(response){
            response.forEach(function(category){
                $("#modalSelectDistrType")
                        .append($("<option></option>")
                        .attr("value", category.id)
                        .text(category.name));
            });

        }
    });
	
	$("#homeButton").click(function(){
		window.location.href = "home";
	});
	
	$("#profileButton").click(function(){
		window.location.href = "profile";
	});
	
	$("#logoutButton").click(function(){
		window.location.href = "logout";
	});
	
	$("#showSelectModal").click(function(){
		$("#selectType").modal("show");
	});

    $("#modalSelectDistrType").click(function(){
        if($(this).val() == 1)
            window.location.href = "create_distribution_film";
    });
});
	
</script>


<div class="globalMenu">
	<div class="btn-group">
		<button type="button" class="btn" id="homeButton"><span class="glyphicon glyphicon-home" id="icon_home"></span></button>
		<button type="button" class="btn" id="profileButton"><spring:message code="global_menu.profile"/></button>
		<div class="btn-group">
			<button type="button" class="btn dropdown-toggle" data-toggle="dropdown" id="distributionButton">
				<spring:message code="global_menu.distribution"/> 
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li id="showSelectModal"><a><spring:message code="global_menu.create_distribution"/></a></li>
				<li><a href="view_distributions"><spring:message code="global_menu.view_distributions"/></a></li>
			</ul>
		</div>
		<button type="button" class="btn btn-primary" id="logoutButton"><spring:message code="global_menu.logout"/></button>
	</div>
</div>

<div class="modal fade bs-example-modal-sm" id="selectType" tabindex="-1" role="dialog" aria-labelledby="selectTypeModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="model-content">
			<div class="model-header">
				<h4 class="modal-title" id="selectTypeModal"><spring:message code="distribution.select_type" /></h4>
			</div>
			<div class="modal-body">
				<select class="form-control" id="modalSelectDistrType"></select>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn" data-dismiss="modal"><spring:message code="global.close" /></button>
			</div>
		</div>
	</div>
</div>