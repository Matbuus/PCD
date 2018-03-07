package com.ourteam.pcd.Persistence.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.Entity.Classe;


@Repository("classeDao")
public interface ClasseRepository extends JpaRepository<Classe, String>  {
	
	

}