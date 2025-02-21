package com.fatec.projeto.projetofatec2025.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioController {
    
    @GetMapping("")
    public String HelloWorld(){
        return "<h1"+" style ="+"color:red"+">Hello, World?</h1><h2>Oque é a vida?</h2>";
    }
}
