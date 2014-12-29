<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<script>
    $(document).ready(function (){
        var profile;
        $.ajax({
            url: "get_user_profile",
            type: "GET",
            datatype: "JSON",
            contentType: "application/json; charset=utf-8",
            success: function(data){
                profile = data;
                $("#login").text(profile.login);
                $("#email").text(profile.email);
                if (profile.role == "ADMIN")
                    $("#role_type").text("<spring:message code="main.admin"/> ");
                else if (profile.role == "USER")
                    $("#role_type").text("<spring:message code="main.user"/> ");
            }
        });

    });
</script>

<div class="central-block">
    <div class="form-horizontal">
        <div class="row">
            <label class="col-md-3 control-label"><spring:message code="main.login"/>:</label>
            <p class="col-md-9 form-control-static" id="login"></p>
        </div>
        <div class="row">
            <label class="col-md-3 control-label"><spring:message code="main.email"/>:</label>
            <p class="col-md-9 form-control-static" id="email"></p>
        </div>
        <div class="row">
            <label class="col-md-3 control-label"><spring:message code="main.role_type"/>:</label>
            <p class="col-md-9 form-control-static" id="role_type"></p>
        </div>
    </div>
</div>