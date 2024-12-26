package com.mcommandes.services;

import com.mcommandes.model.Commande;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICommandeServices {
    ResponseEntity<Commande> ajouterCommande(Commande commande);
    List<Commande> recupererToutesLesCommandes();
    List<Commande> getLastCommandes();
    Optional<Commande> recupererUneCommande(int id);
    void updateCommande(Commande commande);
}
