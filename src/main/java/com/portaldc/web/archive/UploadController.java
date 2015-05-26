package com.portaldc.web.archive;

import com.portaldc.api.service.archive.DistributionArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {
    @Autowired
    DistributionArchiveService distributionArchiveService;

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/distribution/poster/{distId}",
            method = RequestMethod.POST,
            headers = "Accept=*/*")
    public
    @ResponseBody
    String saveDistributionPoster(@PathVariable("distId") Long distributionId, MultipartHttpServletRequest servletRequest) throws IOException {

        distributionArchiveService.savePoster(servletRequest, distributionId);
        return "success";

    }
}
