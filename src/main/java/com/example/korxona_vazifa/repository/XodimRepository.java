package com.example.korxona_vazifa.repository;

import com.example.korxona_vazifa.entity.Xodim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface XodimRepository extends JpaRepository<Xodim,Long> {

    Optional<Xodim> findById(Long id);



    @Override
    List<Xodim> findAll();
}
