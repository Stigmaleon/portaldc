package com.portaldc.api.service.profile;

import com.portaldc.api.dto.profile.ProfileDTO;

public interface ProfileService {

    public ProfileDTO getUserProfile(Long userId);
}
