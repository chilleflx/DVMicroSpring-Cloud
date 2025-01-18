package com.mcommandes.web.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actuator")
public class ActuatorController {

    @PostMapping("/refresh")
    public void refresh() {
    }
    @GetMapping("/health")
    public void health() {
    }
    @GetMapping("/env/mes-config-ms.commandes-last")
    public void info() {
    }
}
