package org.yearup.service;

import org.springframework.stereotype.Service;
import org.yearup.models.Profile;
import org.yearup.repository.ProfileRepository;

@Service
public class ProfileService
{
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository)
    {
        this.profileRepository = profileRepository;
    }
    //given
    public Profile create(Profile profile)
    {
        return profileRepository.save(profile);
    }
    //update
    public Profile update(int userId, Profile profile) {
        //update profile and return the updated profile
        Profile updating = profileRepository.findById(userId).orElseThrow();
        updating.setFirstName(profile.getFirstName());
        updating.setLastName(profile.getLastName());
        updating.setPhone(profile.getPhone());
        updating.setEmail(profile.getEmail());
        updating.setAddress(profile.getAddress());
        updating.setCity(profile.getCity());
        updating.setState(profile.getState());
        updating.setZip(profile.getZip());
        return profileRepository.save(updating);
    }
    //getById
    public Profile getById(int userId){
        //get category by id
        return profileRepository.findById(userId).orElse(null);
    }

}
