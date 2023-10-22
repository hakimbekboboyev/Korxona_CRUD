package com.example.korxona_vazifa.service;

import com.example.korxona_vazifa.dto.XodimDto;
import com.example.korxona_vazifa.entity.Passport;
import com.example.korxona_vazifa.entity.Xodim;
import com.example.korxona_vazifa.lavozimlar.Lavozimlar;
import com.example.korxona_vazifa.repository.PassportRepository;
import com.example.korxona_vazifa.repository.XodimRepository;
import org.hibernate.NonUniqueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XodimService {
    @Autowired
    XodimRepository xodimRepository;

    @Autowired
    PassportRepository passportRepository;

    public Xodim create(XodimDto xodimDto){
        try {


            Passport passport = Passport.builder()
                    .seriyasi(xodimDto.getPass_seriyasi())
                    .raqami(xodimDto.getPass_raqami())
                    .jshshir(xodimDto.getPass_jshshir())
                    .millati(xodimDto.getPass_millati())
                    .build();
            Passport save_passport = passportRepository.save(passport);
            Xodim xodim = Xodim.builder()
                    .ismi(xodimDto.getIsmi())
                    .familiyasi(xodimDto.getFamiliyasi())
                    .sharifi(xodimDto.getSharifi())
                    .yoshi(xodimDto.getYoshi())
                    .passport_malumotlari(save_passport)
                    .ish_haqqi(xodimDto.getIsh_haqqi())
                    .yashash_manzili(xodimDto.getYashash_manzili())
                    .bolimi(xodimDto.getBolimi())
                    .lavozimi(xodimDto.getLavozimi())
                    .build();


            return xodimRepository.save(xodim);
        }
        catch (NonUniqueObjectException e){
            e.printStackTrace();
        }

        return null;


    }


    public List<Xodim> listXodim(){
        List<Xodim> xodimlar = xodimRepository.findAll();
        return xodimlar;
    }


    public Xodim getXodim(Long id) {
        Optional<Xodim> xodimOptional = xodimRepository.findById(id);
        return xodimOptional.orElse(null);
    }

    public Xodim deleteXodim(Long id) {
        Xodim xodim = getXodim(id);
        xodimRepository.deleteById(id);
        passportRepository.deleteById(id);
        return xodim;

    }

    public Xodim updateXodim(Long id, XodimDto xodimDto){
        Optional<Xodim> xodimOptional = xodimRepository.findById(id);

        Xodim xodim = xodimOptional.get();
        Passport passport = xodim.getPassport_malumotlari();



        passport.setJshshir(xodimDto.getPass_jshshir());
        passport.setRaqami(xodimDto.getPass_raqami());
        passport.setMillati(xodimDto.getPass_millati());
        passport.setSeriyasi(xodimDto.getPass_seriyasi());
        passportRepository.save(passport);


        xodim.setIsmi(xodimDto.getIsmi());
        xodim.setFamiliyasi(xodimDto.getFamiliyasi());
        xodim.setBolimi(xodimDto.getBolimi());
        xodim.setLavozimi(xodimDto.getLavozimi());
        xodim.setSharifi(xodimDto.getSharifi());
        xodim.setYoshi(xodimDto.getYoshi());
        xodim.setIsh_haqqi(xodimDto.getIsh_haqqi());
        xodim.setYashash_manzili(xodimDto.getYashash_manzili());
        xodim.setPassport_malumotlari(passport);
        return xodimRepository.save(xodim);


    }
}
