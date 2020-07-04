package org.muellners.bounties.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.muellners.bounties.domain.Profile;
import org.muellners.bounties.service.dto.ProfileDTO;
import org.springframework.stereotype.Service;

/**
 * Mapper for the entity {@link Profile} and its DTO called {@link ProfileDTO}.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as
 * MapStruct support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class ProfileMapper {
    
    public List<ProfileDTO> profilesToProfilesDTOs(final List<Profile> profiles) {
        return profiles.stream()
            .filter(Objects::nonNull)
            .map(this::profileToProfileDTO)
            .collect(Collectors.toList());
    }

    public ProfileDTO profileToProfileDTO(final Profile profile) {
        return new ProfileDTO(profile);
    }

    public  List<Profile> profileDTOsToProfiles(final List<ProfileDTO> profileDTOs) {
        return profileDTOs.stream()
            .filter(Objects::nonNull)
            .map(this::profileDTOToProfile)
            .collect(Collectors.toList());
    }

    public Profile profileDTOToProfile(final ProfileDTO profileDTO) {
        if (profileDTO == null) {
            return null;
        } else {
            Profile profile = new Profile();
            profile.setId(profileDTO.getId());
            profile.setVotes(profileDTO.getVotes());
            profile.setProfilelink(profileDTO.getProfilelink());
            profile.setAbout(profileDTO.getAbout());
            profile.setWalletaddress(profileDTO.getWalletaddress());
            profile.setGithubEmail(profileDTO.getGithubEmail());
            profile.setGithubOrgName(profileDTO.getGithubOrgName());
            return profile;
        }
    }
}