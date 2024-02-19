package com.backend.gamerservice.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class GamerDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String level;
    private String game;
    private String geography;
}
