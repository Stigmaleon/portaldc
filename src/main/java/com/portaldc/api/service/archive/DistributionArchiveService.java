package com.portaldc.api.service.archive;

import java.io.InputStream;


public interface DistributionArchiveService {
    public void savePoster(InputStream inputStream, Long distributionId);
}
