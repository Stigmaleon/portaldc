package com.portaldc.api.service.archive;

import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface DistributionArchiveService {
    public void savePoster(MultipartHttpServletRequest request, Long distributionId);
}
