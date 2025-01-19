package com.mcommandes.mapper;

import com.mcommandes.dao.CommandesDao;
import com.mcommandes.model.Commande;
import com.mcommandes.services.ICommandeServices;
import com.mcommandes.web.exceptions.CommandeNotFoundException;
import com.mcommandes.web.exceptions.ImpossibleAjouterCommandeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RefreshScope
public class CommandeServiceImpl implements ICommandeServices {

    @Autowired
    private CommandesDao commandesDao;

    @Value("${mes-config-ms.commandes-last}")
    private int commandesLastDays;


    @Override
    public ResponseEntity<Commande> ajouterCommande(Commande commande) {

        Commande nouvelleCommande = commandesDao.save(commande);
        if (nouvelleCommande == null) {
            throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");
        }
        return new ResponseEntity<>(nouvelleCommande, HttpStatus.CREATED);
    }

    @Override
    public List<Commande> getLastCommandes() {
        System.out.println("commandesLastDays: " + commandesLastDays);
        LocalDate dateBefore = LocalDate.now().minusDays(commandesLastDays);
        return commandesDao.findByDateAfter(dateBefore);
    }

    @Override
    public List<Commande> recupererToutesLesCommandes() {
        return commandesDao.findAll();
    }

    @Override
    public Optional<Commande> recupererUneCommande(int id) {
        Optional<Commande> commande = commandesDao.findById(id);
        if (!commande.isPresent()) {
            throw new CommandeNotFoundException("Cette commande n'existe pas");
        }
        return commande;
    }

    @Override
    public void updateCommande(Commande commande) {
        commandesDao.save(commande);
    }

    @Override
    public void deleteCommande(int id) {
        commandesDao.deleteById(id);
    }
}
