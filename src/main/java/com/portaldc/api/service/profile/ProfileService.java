package com.portaldc.api.service.profile;

import com.portaldc.api.dto.profile.ProfileDTO;

public interface ProfileService {

    ProfileDTO getUserProfile(Long userId);
}
