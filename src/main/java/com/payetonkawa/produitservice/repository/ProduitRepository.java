package com.payetonkawa.produitservice.repository;

import com.payetonkawa.produitservice.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
