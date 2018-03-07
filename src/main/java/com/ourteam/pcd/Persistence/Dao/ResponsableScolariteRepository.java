package com.ourteam.pcd.Persistence.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.Entity.ResponsableScolarite;



@Repository("responsableScolariteDao")
public interface ResponsableScolariteRepository extends JpaRepository<ResponsableScolarite, String>  {

}