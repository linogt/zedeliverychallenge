package org.example.controller;

import org.bson.types.ObjectId;
import org.example.model.Pdv;
import org.example.service.PdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.repository.PdvRepository;

import java.util.Optional;

@RestController
public class PdvController {
    @Autowired
    PdvService pdvService;

    @Autowired
    PdvRepository pdvRepository;

    @GetMapping("/checkCoordinates")
    public Pdv checkCoordinates(@RequestParam double longParam, @RequestParam double latParam) {
        return pdvService.checkCoordinates(longParam, latParam);
    }

    @GetMapping("/id/{id}")
    public Pdv getById(@PathVariable String id) {
        return pdvService.findByIdCustom(id);
    }
}
