package com.mcommandes.config;

import com.mcommandes.dao.CommandesDao;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CommandesHealthIndicator implements HealthIndicator {

    @Autowired
    private CommandesDao commandeRepository;

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
            return commandeRepository.count(); // Use the repository's count method
        } catch (Exception e) {
            // In case of an error (e.g., database connection issue)
            return 0;
        }
    }
}