package com.portaldc.web.archive;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UploadController
{
    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/upload/distribution/poster",
            method = RequestMethod.POST,
            headers = "Accept=multipart/form-data")
    public void saveDistributionPoster(@PathVariable ("distId") Long distributionId) {
        //TODO create service for save files

    }
}
