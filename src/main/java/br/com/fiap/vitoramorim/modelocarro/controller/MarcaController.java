package br.com.fiap.vitoramorim.modelocarro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MarcaController {

    @GetMapping ("/marcas")
    public String marca() {
        return "Marcas disponiveis: Chevrolet, Ford, Toyota";
    }

    @GetMapping ("/marcas/destaque")
    public String marcaDestaque() {
        return "Marca destaque do mês: Chevrolet";
    }
}