<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<script>
    $(document).ready(function () {
        var distLinks = [];

        $("#audioDescription").cleditor();

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
            var audio = new AudioDistribution();

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
                audio.name = $("#audioName").val();
                audio.nativeName = $("#audioNameNative").val();
                audio.ganre = $("#audioGanre").val();
                audio.year = $("#audioYear").val();
                audio.time = $("#audioTime").val();
                audio.country = $("#audioCountry").val();
                audio.linkKinopoisk = $("#audioLinkImdb").val();
                audio.linkImdb = $("#audioLinkKinopoisk").val();
                audio.description = $("#audioDescription").val();
                audio.links = distLinks;

                $.ajax({
                    url: "createAudioDistribution",
                    type: "POST",
                    datatype: "json",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(audio),
                    success: function (data) {

                        var formData = new FormData();
                        var poster = document.getElementById("audioPoster").files[0];
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
            <label for="audioName" class="col-md-3 control-label">
                <spring:message code="distribution.name"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="audioName" class="form-control not-empty" autofocus="autofocus">
            </div>
        </div>

        <div class="form-group">
            <label for="audioNameNative" class="col-md-3 control-label">
                <spring:message code="distribution.native_name"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="audioNameNative" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="audioPoster" class="col-md-3 control-label">
                <spring:message code="distribution.poster"/>
            </label>

            <div class="col-md-9">
                <input type="file" id="audioPoster" class="form-control not-empty" accept="image/*">
            </div>
        </div>

        <div class="form-group">
            <label for="audioGanre" class="col-md-3 control-label">
                <spring:message code="distribution.ganre"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="audioGanre" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="audioYear" class="col-md-3 control-label">
                <spring:message code="distribution.year"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="audioYear" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="audioTime" class="col-md-3 control-label">
                <spring:message code="distribution.time"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="audioTime" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="audioCountry" class="col-md-3 control-label">
                <spring:message code="distribution.country"/>
            </label>

            <div class="col-md-9">
                <input type="text" id="audioCountry" class="form-control not-empty">
            </div>
        </div>

        <div class="form-group">
            <label for="audioDescription" class="col-md-3 control-label"><spring:message
                    code="distribution.description"/></label>

            <div class="col-md-9">
                <textarea id="audioDescription" class="not-empty"></textarea>
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