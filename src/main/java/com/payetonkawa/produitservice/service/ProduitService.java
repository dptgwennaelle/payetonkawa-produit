package com.payetonkawa.produitservice.service;

import com.payetonkawa.produitservice.model.Produit;
import com.payetonkawa.produitservice.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository repository;


    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    public List<Produit> getAll(){
        return repository.findAll();
    }

    public Optional<Produit> getById(Long id){
        return repository.findById(id);
    }

    public Produit save(Produit produit){
        return repository.save(produit);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
