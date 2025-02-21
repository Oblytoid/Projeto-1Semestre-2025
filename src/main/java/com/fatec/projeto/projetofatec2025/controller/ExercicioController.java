package com.fatec.projeto.projetofatec2025.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioController {
    
    @GetMapping("{nome}")
    public String HelloWorld(@PathVariable String nome){
        return "<h1"+" style ="+"color:red"+">Hello, World?</h1><h2>"+nome+"</h2>";
    }
}
