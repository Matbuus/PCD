package com.ourteam.pcd.Configurations;
 
import java.io.File;
import java.util.EnumSet;
 
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import com.ourteam.pcd.Entity.Compte;
import com.ourteam.pcd.Entity.Etudiant;
import com.ourteam.pcd.Persistance.CompteHome;
import com.ourteam.pcd.Persistance.EtudiantHome;
 
// Hibernate 5.
public class GenerateurDeTables {
 
   public static final String SCRIPT_FILE = "exportScript.sql"; // Ecrit les requetes executées dans un fichier sql
   
   public GenerateurDeTables() {
       String configFileName = "hibernate-mysql.cfg.xml";
       ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
               .configure(configFileName).build();
       Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
       SchemaExport export = getSchemaExport();
       System.out.println("Drop Database...");
       dropDataBase(export, metadata);
       System.out.println("Create Database...");
       createDataBase(export, metadata);
   }
   private static SchemaExport getSchemaExport() {
 
       SchemaExport export = new SchemaExport();
       // Script file.
       File outputFile = new File(SCRIPT_FILE);
       String outputFilePath = outputFile.getAbsolutePath();
 
       System.out.println("Export file: " + outputFilePath);
 
       export.setDelimiter(";");
       export.setOutputFile(outputFilePath);
        
       // No Stop if Error
       export.setHaltOnError(false);
       //
       return export;
   }
 
   public static void dropDataBase(SchemaExport export, Metadata metadata) {
       EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);
       export.drop(targetTypes, metadata);
   }
 
   public static void createDataBase(SchemaExport export, Metadata metadata) {
       EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);
     
       SchemaExport.Action action = SchemaExport.Action.CREATE;
       export.execute(targetTypes, action, metadata);
       System.out.println("Export OK");
 
   }
 
   public static void main(String[] args) {
	   System.out.println("Salut");
	   System.out.println("Salut");
	   EtudiantHome gestEtudiant = new EtudiantHome();
	   CompteHome gestCompte= new CompteHome();
	   Etudiant amine= new Etudiant();
	   Compte c = new Compte();
	   c.setEmail("amine2@gmail.com");
	   c.setPassword("whi3te");
	   gestCompte.persist(c);
	   amine.setCompte(c);
	   amine.setNom("Ben Rejeb");
	   amine.setPrenom("Amine");
	   amine.setNumInscription("II100000");
	   amine.setTelephone("14345678");
	   gestEtudiant.persist(amine);
   }
    
}