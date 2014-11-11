package com.portaldc.impl.service.archive;

import com.portaldc.api.service.archive.DistributionArchiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;

@Service
public class DistributionArchiveServiceImpl implements DistributionArchiveService {

    @Value("${application.archive_path}")
    private String ARCHIVE_PATH;

    Logger logger = LoggerFactory.getLogger(DistributionArchiveServiceImpl.class);

    @Override
    public void savePoster(MultipartHttpServletRequest request, Long distributionId) {

        if (checkArchiveFolder()) {

            File posterFolder = getPosterFolder();
            File poster = new File(posterFolder.getPath() + "/" + distributionId + ".png");

            MultipartFile multipartFiles = request.getFile("posterFile");

            try {
                multipartFiles.transferTo(poster);
            } catch (IOException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }

        }

    }

    private Boolean checkArchiveFolder() {

        File archiveDirectory = new File(ARCHIVE_PATH);
        return (archiveDirectory.exists() && archiveDirectory.isDirectory());

    }

    private File getPosterFolder() {

        File posterFolder = new File(ARCHIVE_PATH + "/poster");
        if (!posterFolder.exists())
            posterFolder.mkdir();

        return posterFolder;

    }

}
