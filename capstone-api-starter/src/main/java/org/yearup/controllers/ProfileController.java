package org.yearup.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yearup.models.Profile;
import org.yearup.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("profiles")
@CrossOrigin
public class ProfileController {
    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAll(){
        List<Profile> profiles = profileService.getAll();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
}
