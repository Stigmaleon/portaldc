package com.portaldc.impl.service.archive;

import com.portaldc.api.service.archive.DistributionArchiveService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class DistributionArchiveServiceImpl implements DistributionArchiveService {

    @Value("${application.archive_path}")
    private String archivePath;

    @Override
    public void savePoster(InputStream inputStream, Long distributionId) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    " + archivePath);
    }

    private void checkArchiveFolder() {

    }

    private void checkPosterFolder() {

    }
}
