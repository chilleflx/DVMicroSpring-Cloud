package com.mcommandes.dao;

import com.mcommandes.model.Commande;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommandesDao extends JpaRepository<Commande, Integer> {
    List<Commande> findByDateAfter(LocalDate dateAfter);

}

