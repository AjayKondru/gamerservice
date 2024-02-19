package com.backend.gamerservice.api.entity;

import jakarta.validation.constraints.NotNull;

public record GamerDetailsDTO(@NotNull(message = "Name should not be null") String name,
                              @NotNull(message = "level should not be null")
                              LEVEL level,
                              @NotNull(message = "game should not be null")
                              String game,
                              @NotNull(message = "geography should not be null")
                              String geography) {
}


