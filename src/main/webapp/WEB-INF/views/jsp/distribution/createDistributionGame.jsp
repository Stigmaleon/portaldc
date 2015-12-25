<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<script>
    $(document).ready(function () {
        var distLinks = [];

        $("#gameDescription").cleditor();

        var tableWithLinks = $("#tableLinks").dataTable({
            "data": distLinks,
            "scrollX": true,
            "columns": [
                {data: "position", "title": "Position"},
                {data: "name", "title": "Name"},
                {data: "size", "title": "Size"},
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

        $("#addLinksButton").click(function () {
            distLinks = [];

            var linksFromTextArea = $("#linksAsText").val().split("\n");
            $.each(linksFromTextArea, function (index, value) {
                if (value.length > 0) {
                    var tempLink = {};
                    tempLink.position = index;
                    tempLink.magnet = value;
                    tempLink.name = "";
                    tempLink.size = 0;
                    var params = value.split("&");

                    $.each(params, function (index, value) {
                        var keyvalue = value.split("=");
                        if (keyvalue[0] == "dn")
                            tempLink.name = keyvalue[1].replace(/\+/g, " ");

                        if (keyvalue[0] == "dl")
                            tempLink.size = keyvalue[1];
                    });

                    distLinks.push(tempLink);
                }
            });

            tableWithLinks.fnClearTable();
            tableWithLinks.fnAddData(distLinks);

        });

        $("#addLinkButton").click(function () {
            var tempLink = {};
            tempLink.position = $("#newLinkPositionInput").val();
            tempLink.name = $("#newLinkNameInput").val();
            tempLink.magnet = $("#newLinkInput").val();
            tempLink.size = 0;

            var params = tempLink.magnet.split("&");
            $.each(params, function (index, value) {
                var keyvalue = value.split("=");
                if (keyvalue[0] == "dl")
                    tempLink.size = keyvalue[1];
            });

            distLinks.push(tempLink);

            tableWithLinks.fnClearTable();
            tableWithLinks.fnAddData(distLinks);
        });

        $("#createDistrButton").click(function () {

            var hasEmpty = false;
            var game = new GameDistribution();

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

            if (distLinks == undefined || distLinks.length == 0)
                hasEmpty = true;

            if (!hasEmpty) {
                game.name = $("#gameName").val();
                game.nativeName = $("#gameNameNative").val();
                game.ganre = $("#gameGanre").val();
                game.year = $("#gameYear").val();
                game.publisher = $("#gamePublisher").val();
                game.developer = $("#gameDeveloper").val();
                game.publicationType = $("#gamePublicationType").val();
                game.language = $("#gameLanguage").val();
                game.translate = $("#gameTranslate").val();
                game.country = $("#gameCountry").val();
                game.linkKinopoisk = $("#gameLinkImdb").val();
                game.linkImdb = $("#gameLinkKinopoisk").val();
                game.description = $("#gameDescription").val();
                game.links = distLinks;

                $.ajax({
                    url: "createGameDistribution",
                    type: "POST",
                    datatype: "json",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(game),
                    success: function (data) {

                        var formData = new FormData();
                        var poster = document.getElementById("gamePoster").files[0];
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
            <label for="gameName" class="col-md-3 control-label">
                <spring:message code="distribution.name"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gameName" class="form-control not-empty" autofocus="autofocus">
            </div>
        </div>

        <div class="form-group">
            <label for="gameNameNative" class="col-md-3 control-label">
                <spring:message code="distribution.native_name"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gameNameNative" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="gamePoster" class="col-md-3 control-label">
                <spring:message code="distribution.poster"/>
            </label>

            <div class="col-md-9">
                <input type="file" id="gamePoster" class="form-control not-empty" accept="image/*">
            </div>
        </div>

        <div class="form-group">
            <label for="gameGanre" class="col-md-3 control-label">
                <spring:message code="distribution.ganre"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gameGanre" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="gameYear" class="col-md-3 control-label">
                <spring:message code="distribution.year"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gameYear" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="gamePublisher" class="col-md-3 control-label">
                <spring:message code="distribution.publisher"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gamePublisher" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="gameDeveloper" class="col-md-3 control-label">
                <spring:message code="distribution.developer"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gameDeveloper" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="gamePublicationType" class="col-md-3 control-label">
                <spring:message code="distribution.publication_type"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gamePublicationType" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="gameLanguage" class="col-md-3 control-label">
                <spring:message code="distribution.language"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gameLanguage" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="gameTranslate" class="col-md-3 control-label">
                <spring:message code="distribution.translate"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gameTranslate" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="gameCountry" class="col-md-3 control-label">
                <spring:message code="distribution.country"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="gameCountry" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="gameDescription" class="col-md-3 control-label"><spring:message
                    code="distribution.description"/></label>

            <div class="col-md-9">
                <textarea id="gameDescription" class="not-empty"></textarea>
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
                            <button class="btn btn-default" data-toggle="modal" data-target="#addLinkModal">
                                <spring:message
                                        code="distribution.add_link"></spring:message>
                            </button>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="asText">
                            <textarea id="linksAsText" class="form-control" rows="10" wrap="off"
                                      style="margin: 5px"></textarea>
                            <button class="btn btn-default" id="addLinksButton">
                                <spring:message
                                        code="distribution.add_links"></spring:message>
                            </button>
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

<%--Dialog box to add link--%>
<div class="modal fade" id="addLinkModal" tabindex="-1" role="dialog" aria-labelledby="linkModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="linkModal"><spring:message code="distribution.add_link"/></h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="newLinkInput"><spring:message code="distribution.link"/> </label>
                    <input type="text" class="form-control" id="newLinkInput">
                </div>
                <div class="form-group">
                    <label for="newLinkPositionInput"><spring:message code="distribution.link_position"/> </label>
                    <input type="text" class="form-control" id="newLinkPositionInput">
                </div>
                <div class="form-group">
                    <label for="newLinkNameInput"><spring:message code="distribution.link_name"/> </label>
                    <input type="text" class="form-control" id="newLinkNameInput">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn" data-dismiss="modal"><spring:message code="global.close"/></button>
                <button type="button" class="btn btn-default" id="addLinkButton">
                    <spring:message
                            code="global.add"/>
                </button>
            </div>
        </div>
    </div>
</div>