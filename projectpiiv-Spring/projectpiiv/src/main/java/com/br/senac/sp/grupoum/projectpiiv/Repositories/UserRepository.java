package com.br.senac.sp.grupoum.projectpiiv.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.senac.sp.grupoum.projectpiiv.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(int id);
}
