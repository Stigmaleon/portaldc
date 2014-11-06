<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<script>
    $(document).ready(function(){
        $("#filmDescription").cleditor();

        $("#createDistrButton").click(function(){

            var hasEmpty = false;
            var film = new FilmDistribution();

            $(".not-empty").each(function(){
                if($(this).val() === "") {
                    $(this).closest("div.form-group").addClass("has-error");
                    hasEmpty = true;
                }
                else {
                    $(this).closest("div.form-group").removeClass("has-error");
                    $(this).closest("div.form-group").addClass("has-success");
                }
            });

            if(!hasEmpty) {
                film.name = $("#filmName").val();
                film.nativeName = $("#filmNameNative").val();
                film.ganre = $("#filmGanre").val();
                film.year = $("#filmYear").val();
                film.time = $("#filmTime").val();
                film.country = $("#filmCountry").val();
                film.linkKinopoisk = $("#filmLinkImdb").val();
                film.linkImdb = $("#filmLinkKinopoisk").val();
                film.description = $("#filmDescription").val();

                $.ajax({
                    url: "createFilmDistribution",
                    type: "POST",
                    datatype: "json",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(film),
                    success:function(data){
                        console.log(data);
                        $.ajax({
                            url: "upload/distribution/poster?distId=" + data,
                            type: "POST",
                            datatype: "json",
                            enctype: "multipart/form-data",
                            data: new FormData($("#filmPoster")),
                            success: function(){
                                window.location.href = "home";
                            }
                        });
                    }
                });
            }

        });

    });
</script>

<div class="central-block">
    <div class="form-horizontal">

        <div class="form-group">
            <label for="filmName" class="col-md-3 control-label"><spring:message code="distribution.name"/></label>

            <div class="col-md-9">
                <input type="text" id="filmName" class="form-control not-empty" autofocus="autofocus">
            </div>
        </div>

        <div class="form-group">
            <label for="filmNameNative" class="col-md-3 control-label"><spring:message
                    code="distribution.native_name"/></label>

            <div class="col-md-9">
                <input type="text" id="filmNameNative" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmPoster" class="col-md-3 control-label"><spring:message
                    code="distribution.poster"/></label>

            <div class="col-md-9">
                <input type="file" id="filmPoster" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmGanre" class="col-md-3 control-label"><spring:message code="distribution.ganre"/></label>

            <div class="col-md-9">
                <input type="text" id="filmGanre" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmYear" class="col-md-3 control-label"><spring:message code="distribution.year"/></label>

            <div class="col-md-3">
                <input type="text" id="filmYear" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmTime" class="col-md-3 control-label"><spring:message code="distribution.time"/></label>

            <div class="col-md-3">
                <input type="text" id="filmTime" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmCountry" class="col-md-3 control-label"><spring:message code="distribution.country"/></label>

            <div class="col-md-9">
                <input type="text" id="filmCountry" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmLinkImdb" class="col-md-3 control-label"><spring:message code="distribution.linkImdb"/></label>

            <div class="col-md-9">
                <input type="url" id="filmLinkImdb" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmLinkKinopoisk" class="col-md-3 control-label"><spring:message code="distribution.linkKinopoisk"/></label>

            <div class="col-md-9">
                <input type="url" id="filmLinkKinopoisk" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmDescription" class="col-md-3 control-label"><spring:message code="distribution.description"/></label>

            <div class="col-md-9">
                <textarea id="filmDescription" class="not-empty"></textarea>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
                <button class="btn btn-primary" id="createDistrButton">Create distribution</button>
            </div>
        </div>


    </div>
</div>