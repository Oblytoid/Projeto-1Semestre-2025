package com.fatec.projeto.fatec2025.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExercicioController {
    
    boolean IsNumber(String src){
        try{
           Float.parseFloat(src); 
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @GetMapping("")
    public String HelloWorld(){
        return "<h1"+" style ="+"color:red"+">Hello, World</h1>";
    }

    @GetMapping("/nome={nome}")
    public String HelloWorld(@PathVariable String nome){
        return "<h1"+" style ="+"color:red"+">Hello, World?</h1><h2>"+nome+"</h2>";
    }
    
    @GetMapping("/age={age}")
    public String getMethodName(@PathVariable String age) {
        int currentAge = Integer.parseInt(age);

        if(currentAge > 120){
            return "<iframe src=\"https://gifer.com/embed/Af6V\" width=480 height=433.116 frameBorder=\"0\" allowFullScreen></iframe>"+
            "<style> iframe{ display:flex; margin: 0 auto; border: 10px solid yellow}</style>";
            
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

    @GetMapping("/imc")
    public String IMCCalculator(@RequestParam String height, @RequestParam String weight) {
        
        if(!IsNumber(height) || !IsNumber(weight)){
            return "Apenas numeros";
        }

        float imc;
        float height2, weight2;
            
        height2 = Float.parseFloat(height);
        weight2 = Float.parseFloat(weight);
        
        if(height2 <= 0 || weight2 <= 0){
           return "Operação invalida";
        }

        imc = weight2/(height2 * height2);
        

        System.out.println(imc);
        if (imc < 18.5) {
            return "Abaixo do peso";
        }
        if (imc < 24.9) {
            return "Peso normal";
        }
        if (imc < 29.9) {
            return "Sobrepeso";
        }
        if (imc < 34.9) {
            return "Obesidade grau 1";
        }
        if (imc < 39.9) {
            return "Obesidade grau 2";
        }
        return "Obesidade grau 3";    
    }

    @GetMapping("/verificaNumeros")
    public String NumberVerify(@RequestParam String number) {
        if (!IsNumber(number)) {
            return "Apenas numneros";
        }
        if (Integer.parseInt(number) < 0) {
            return "Numnero negativo";

        }
        if(Integer.parseInt(number) % 2 == 0){
            return "O numero: "+ number +" é par.";
        }
        return "O numero: "+ number +" é ímpar.";
    }
    
    
}
