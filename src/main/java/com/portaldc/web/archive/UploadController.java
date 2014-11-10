package com.portaldc.web.archive;

import com.portaldc.api.service.archive.DistributionArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class UploadController {
    @Autowired
    DistributionArchiveService distributionArchiveService;

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/upload/distribution/poster/{distId}",
            method = RequestMethod.POST,
            headers="Accept=*/*")
    public
    @ResponseBody
    String saveDistributionPoster(@PathVariable("distId") Long distributionId, HttpServletRequest  servletRequest) throws IOException {
        //TODO create service for save files
        distributionArchiveService.savePoster(servletRequest.getInputStream(), distributionId);
        return "success";
    }
}
