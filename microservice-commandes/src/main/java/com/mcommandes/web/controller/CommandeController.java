package com.mcommandes.web.controller;

import com.mcommandes.model.Commande;
import com.mcommandes.services.ICommandeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
    @Autowired
    private ICommandeServices commandeServiceImpl;

    @PostMapping
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande) {
        return commandeServiceImpl.ajouterCommande(commande);
    }

    @GetMapping("/last")
    public List<Commande> getLastCommandes() {
        return commandeServiceImpl.getLastCommandes();
    }

    @GetMapping
    public List<Commande> recupererToutesLesCommandes() {
        return commandeServiceImpl.recupererToutesLesCommandes();
    }

    @GetMapping("/{id}")
    public Optional<Commande> recupererUneCommande(@PathVariable int id) {
        return commandeServiceImpl.recupererUneCommande(id);
    }

    @PutMapping("/update")
    public void updateCommande(@RequestBody Commande commande) {
        commandeServiceImpl.updateCommande(commande);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable int id) {
        commandeServiceImpl.deleteCommande(id);
    }
}

