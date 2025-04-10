package com.fst.second;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fst.second.entities.Compte;

@SpringBootApplication
public class ThirdApplication {
	public static List<Compte> comptes= new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(ThirdApplication.class, args);
		Compte c1= new Compte(1,"Mariem",7500);
		Compte c2= new Compte(2,"Maram",5500);
		Compte c3= new Compte(3,"Arij",5500);
		comptes.add(c1);
		comptes.add(c2);
		comptes.add(c3);
	}

}
