package com.ourteam.pcd.Persistence.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.Entity.Enseignant;


@Repository("enseignantDao")
public interface EnseignantRepository extends JpaRepository<Enseignant, String>  {

}