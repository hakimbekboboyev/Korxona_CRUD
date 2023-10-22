package com.example.korxona_vazifa.dto;

import com.example.korxona_vazifa.entity.Passport;
import com.example.korxona_vazifa.lavozimlar.Lavozimlar;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class XodimDto {

    private String ismi;
    private String familiyasi;
    private String sharifi;
    private Integer yoshi;
    private String pass_seriyasi;
    private String pass_raqami;
    private String pass_jshshir;
    private String pass_millati;;
    private Double ish_haqqi;
    private String yashash_manzili;
    private String bolimi;
    private String lavozimi;

}
