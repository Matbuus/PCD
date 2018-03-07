package com.ourteam.pcd.Persistence.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourteam.pcd.Entity.Matiere;

@Repository("matiereDao")
public interface MatiereRepository extends JpaRepository<Matiere,String> {

}
