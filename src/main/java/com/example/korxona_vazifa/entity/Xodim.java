package com.example.korxona_vazifa.entity;

import com.example.korxona_vazifa.lavozimlar.Lavozimlar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Xodim {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String ismi;
    private String familiyasi;
    private String sharifi;
    private Integer yoshi;
    @OneToOne
    private Passport passport_malumotlari;
    private Double ish_haqqi;
    private String yashash_manzili;
    private String bolimi;
    private String lavozimi;

}
