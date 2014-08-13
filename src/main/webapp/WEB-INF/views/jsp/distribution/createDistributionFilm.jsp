<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="central-block">
    <div class="form-horizontal">

        <div class="form-group">
            <label for="filmName" class="col-md-3 control-label"><spring:message code="distribution.name"/></label>

            <div class="col-md-9">
                <input type="text" id="filmName" class="form-control" autofocus="autofocus">
            </div>
        </div>

        <div class="form-group">
            <label for="filmNameNative" class="col-md-3 control-label"><spring:message
                    code="distribution.native_name"/></label>

            <div class="col-md-9">
                <input type="text" id="filmNameNative" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="filmGanre" class="col-md-3 control-label"><spring:message code="distribution.ganre"/></label>

            <div class="col-md-9">
                <input type="text" id="filmGanre" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="filmYear" class="col-md-3 control-label"><spring:message code="distribution.year"/></label>

            <div class="col-md-3">
                <input type="text" id="filmYear" class="form-control">
            </div>
            <label for="filmTime" class="col-md-3 control-label"><spring:message code="distribution.time"/></label>

            <div class="col-md-3">
                <input type="text" id="filmTime" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="filmCountry" class="col-md-3 control-label"><spring:message code="distribution.country"/></label>

            <div class="col-md-9">
                <input type="text" id="filmCountry" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="filmLinkImdb" class="col-md-3 control-label"><spring:message code="distribution.linkImdb"/></label>

            <div class="col-md-9">
                <input type="text" id="filmLinkImdb" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="filmLinkKinopoisk" class="col-md-3 control-label"><spring:message code="distribution.linkKinopoisk"/></label>

            <div class="col-md-9">
                <input type="text" id="filmLinkKinopoisk" class="form-control">
            </div>
        </div>


    </div>
</div>