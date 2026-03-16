package br.com.fiap.vitoramorim.modelocarro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ModeloController {

    @GetMapping ("/modelos")
    public String modelos() {
        return "Modelos Disponiveis: Onix, Ka, Corolla";
    }
}