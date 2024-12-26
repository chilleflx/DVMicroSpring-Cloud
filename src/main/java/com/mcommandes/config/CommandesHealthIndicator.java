package com.mcommandes.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Component
public class CommandesHealthIndicator implements HealthIndicator {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Health health() {
        long commandeCount = getCommandeCount();

        if (commandeCount > 0) {
            return Health.up()
                    .withDetail("Commande Count", commandeCount)
                    .build();
        } else {
            return Health.down()
                    .withDetail("Commande Count", commandeCount)
                    .build();
        }
    }

    private long getCommandeCount() {
        try {
            Query query = entityManager.createQuery("SELECT COUNT(c) FROM Commande c");
            return (long) query.getSingleResult();
        } catch (Exception e) {
            // En cas d'erreur (par exemple, problème de connexion à la base de données)
            return 0;
        }
    }
}
