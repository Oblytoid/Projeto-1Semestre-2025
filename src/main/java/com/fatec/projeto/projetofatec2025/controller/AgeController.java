package com.fatec.projeto.projetofatec2025.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AgeController {

    @GetMapping("/age={age}")
    public String getMethodName(@PathVariable String age) {
        int currentAge = Integer.parseInt(age);

        if(currentAge > 120){
            return "<iframe src=\"https://gifer.com/embed/Af6V\" width=480 height=433.116 frameBorder=\"0\" allowFullScreen></iframe>";
            
        }
        if(currentAge > 60){
            return "Idoso";
        }
        if(currentAge > 18){
            return "Adulto";
        }
        if(currentAge > 12){
            return "Adolecente"; 
        }
        return "Criança";
        
    }

}
