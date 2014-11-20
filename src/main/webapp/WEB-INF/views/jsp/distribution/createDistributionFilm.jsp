<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<script>
    $(document).ready(function () {
        var distLinks = [
            {
                "position": 1,
                "name": "test name",
                "magnet": "magnet?2349vdc971fghdr56ejdfghjnh45bbh63546yhghd45tmkdrfgmnw546ytdfghmndn56233-",
                "size": "144032"
            },
            {
                "position": 1,
                "name": "test name",
                "magnet": "magnet?2349vdc971233-",
                "size": "144032"
            }
        ];

        $("#filmDescription").cleditor();

        $("#tableLinks").dataTable({
            "data": distLinks,
            "scrollX": true,
            "columns": [
                {data: "position", "title": "Position", width: "10%"},
                {data: "name", "title": "Name", width: "30%"},
                {data: "size", "title": "Size", width: "15%"},
                {data: "magnet", "title": "Link"}
            ]
        });

        $("a[data-toggle='tab']").on("show.bs.tab", function (e) {

            if (e.target.getAttributeNode("aria-controls").value == "asText") {
                var linksAsText = '';
                $.each(distLinks, function (index, value) {
                    linksAsText += value.magnet;
                    linksAsText += "\n";
                });
                $("#linksAsText").val(linksAsText);
            }

        });

        $("#createDistrButton").click(function () {

            var hasEmpty = false;
            var film = new FilmDistribution();

            $(".not-empty").each(function () {
                if ($(this).val() === "") {
                    $(this).closest("div.form-group").addClass("has-error");
                    hasEmpty = true;
                }
                else {
                    $(this).closest("div.form-group").removeClass("has-error");
                    $(this).closest("div.form-group").addClass("has-success");
                }
            });

            if (!hasEmpty) {
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
                    success: function (data) {

                        var formData = new FormData();
                        var poster = document.getElementById("filmPoster").files[0];
                        formData.append("posterFile", poster);

                        var xhr = new XMLHttpRequest();
                        xhr.open("POST", "upload/distribution/poster/" + data, true);
                        xhr.send(formData);
                        xhr.onload = function (e) {
                            if (this.status = 200) {
                                window.location.href = "home";
                            }
                        };

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
                <input type="text" id="filmNameNative" class="form-control not-empty" accept="image/*">
            </div>
        </div>

        <div class="form-group">
            <label for="filmPoster" class="col-md-3 control-label"><spring:message
                    code="distribution.poster"/></label>

            <div class="col-md-9">
                <input type="file" name="poster" id="filmPoster" class="form-control not-empty">
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
            <label for="filmCountry" class="col-md-3 control-label"><spring:message
                    code="distribution.country"/></label>

            <div class="col-md-9">
                <input type="text" id="filmCountry" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmLinkImdb" class="col-md-3 control-label"><spring:message
                    code="distribution.linkImdb"/></label>

            <div class="col-md-9">
                <input type="url" id="filmLinkImdb" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmLinkKinopoisk" class="col-md-3 control-label"><spring:message
                    code="distribution.linkKinopoisk"/></label>

            <div class="col-md-9">
                <input type="url" id="filmLinkKinopoisk" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="filmDescription" class="col-md-3 control-label"><spring:message
                    code="distribution.description"/></label>

            <div class="col-md-9">
                <textarea id="filmDescription" class="not-empty"></textarea>
            </div>
        </div>

        <div class="col-md-9 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><spring:message code="distribution.links"/></h3>
                </div>

                <div class="panel-body">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="#asList" aria-controls="asList" role="tab"
                                                                  data-toggle="tab"><spring:message
                                code="distribution.links_asList"/> </a></li>
                        <li role="presentation"><a href="#asText" aria-controls="asText" role="tab"
                                                   data-toggle="tab"><spring:message
                                code="distribution.links_asText"/> </a></li>
                    </ul>

                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="asList">
                            <div style="padding: 5px">
                                <table class="table table-striped" id="tableLinks"></table>
                            </div>
                            <button class="btn btn-default" id="addLinkButton"><spring:message
                                    code="distribution.add_link"></spring:message></button>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="asText">
                            <textarea id="linksAsText" class="form-control" rows="10" wrap="off" style="margin: 5px"></textarea>
                            <button class="btn btn-default" id="addLinksButton"><spring:message
                                    code="distribution.add_links"></spring:message> </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-9     col-md-offset-3">
                <button class="btn btn-primary col-md-12" id="createDistrButton"><spring:message
                        code="distribution.create"/></button>
            </div>
        </div>


    </div>
</div>