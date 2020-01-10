package com.maciejkomorowski.allegro.sniper.services;

import com.maciejkomorowski.allegro.sniper.services.dto.AuthResponse;

public interface AuthService {
    AuthResponse authUser(String username, String password);
}
