package com.ourteam.pcd.Persistence.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.Entity.Etudiant;

@Repository("etudiantDao")
public interface EtudiantRepository extends JpaRepository<Etudiant, String>  {
		
}
