package com.maciejkomorowski.allegro.sniper.controllers;

import com.maciejkomorowski.allegro.sniper.controllers.dto.AllegroCredentials;
import com.maciejkomorowski.allegro.sniper.services.AuthService;
import com.maciejkomorowski.allegro.sniper.services.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/allegro/auth")
public class AllegroAuthController {

    private final AuthService authService;

    @PostMapping
    @ResponseBody
    public AuthResponse authAllegroUser(@RequestBody AllegroCredentials allegroCredentials){
        return authService.authUser(allegroCredentials.getUsername(), allegroCredentials.getPassword());
    }
}