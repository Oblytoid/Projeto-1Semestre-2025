package com.fatec.projeto.projetofatec2025.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ExercicioController {
    
    @GetMapping("{nome}")
    public String HelloWorld(@PathVariable String nome){
        return "<h1"+" style ="+"color:red"+">Hello, World?</h1><h2>"+nome+"</h2>";
    }

    @GetMapping("age")
    public String getMethodName(@RequestParam String age) {

        int currentAge = Integer.parseInt(age);

        if (currentAge > 60) {
            return "Idoso";
        }
        if (currentAge > 19) {
            return "Adulto";
        }
        if (currentAge > 12) {
            return "Adolecente";
        }
        return "Criança";
    }
    
}
