package com.example.korxona_vazifa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seriyasi;
    @Column(unique = true)
    private String raqami;
    @Column(unique = true)
    private String jshshir;
    private String millati;

}
