package com.br.senac.sp.grupoum.projectpiiv.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.senac.sp.grupoum.projectpiiv.Models.Images;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long>{

}
