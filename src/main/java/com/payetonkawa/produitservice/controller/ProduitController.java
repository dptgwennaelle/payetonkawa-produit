package com.payetonkawa.produitservice.controller;

import com.payetonkawa.produitservice.model.Produit;
import com.payetonkawa.produitservice.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService service;


    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produit> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getById (@PathVariable Long id){
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produit create(@RequestBody Produit produit){
        return service.save(produit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> update(@PathVariable Long id, @RequestBody Produit produit){
        return service.getById(id)
                .map(existing ->{
                    produit.setId(id);
                    return ResponseEntity.ok(service.save(produit));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (service.getById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
