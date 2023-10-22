package com.example.korxona_vazifa.controller;

import com.example.korxona_vazifa.dto.XodimDto;
import com.example.korxona_vazifa.entity.Xodim;
import com.example.korxona_vazifa.service.XodimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class XodimController {

    @Autowired
    XodimService xodimService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody XodimDto xodimDto) {
        Xodim xodim = xodimService.create(xodimDto);
        if (xodim != null) {
            return ResponseEntity.ok(xodim);

        }else {
            return ResponseEntity.badRequest().body("Bunday passport ma'lumotli xodim mavjud!");
        }
    }


    @GetMapping("/get-xodim/{id}")
    public ResponseEntity getOneXodim(@PathVariable Long id){
        Xodim xodim = xodimService.getXodim(id);
        if (xodim != null){
            return ResponseEntity.ok(xodim);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        List<Xodim> xodims = xodimService.listXodim();
        if (xodims!=null){
            return ResponseEntity.ok(xodims);
        }
        return ResponseEntity.badRequest().body("Hozircha xodimlar topilmadi!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateXodim(@PathVariable Long id,
                                      @RequestBody XodimDto xodimDto){
        Xodim xodim = xodimService.updateXodim(id, xodimDto);
        return ResponseEntity.ok(xodim);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteXodim(@PathVariable Long id){
        Xodim xodim = xodimService.deleteXodim(id);
        if (xodim != null) {

            return ResponseEntity.ok("Xodim muvaffaqqiyatli o'chirildi!");

        }
        return ResponseEntity.ok("Xodim topilmadi!");
    }

}
