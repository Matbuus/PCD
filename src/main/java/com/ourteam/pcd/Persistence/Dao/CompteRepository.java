package com.ourteam.pcd.Persistence.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.Entity.Compte;


@Repository("compteDao")
public interface CompteRepository extends JpaRepository<Compte, String>  {

}