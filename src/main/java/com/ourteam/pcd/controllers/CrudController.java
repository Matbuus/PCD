package com.ourteam.pcd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ourteam.pcd.Services.CompteService;
import com.ourteam.pcd.entities.Compte;

/**
 * 
 * @author houcem BC
 *
 */
@RestController
@RequestMapping("/crud")
public class CrudController {
	@Autowired
	private CompteService compteService;

	@RequestMapping(value = "/createCompte", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Compte addCompte(@RequestBody final Compte compte) throws Exception {
		System.out.println("POST");
		return compteService.saveAndFlush(compte);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public java.util.List<Compte> findEsmeByName() throws Exception {
		System.out.println("SALUT");
		return compteService.findAll();
	}

}
