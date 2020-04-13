package com.br.senac.sp.grupoum.projectpiiv.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.senac.sp.grupoum.projectpiiv.Models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findById(int id);
}
