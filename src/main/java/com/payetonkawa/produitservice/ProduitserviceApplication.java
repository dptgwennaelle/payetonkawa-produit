package com.payetonkawa.produitservice;

import com.payetonkawa.produitservice.repository.ProduitRepository;
import com.payetonkawa.produitservice.util.CsvLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProduitserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitserviceApplication.class, args);
	}

	CommandLineRunner run(ProduitRepository repository){
		return args -> {
			var produits = CsvLoader.loadProduitFromCsv();
			repository.saveAll(produits);
		};
	}
}
