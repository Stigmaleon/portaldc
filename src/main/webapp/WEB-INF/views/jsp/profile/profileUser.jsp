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
            }
        });

    });
</script>

<div class="central-block">
    <h1>PROFILE!</h1>
</div>