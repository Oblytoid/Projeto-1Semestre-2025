package com.fatec.projeto.projetofatec2025.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.fatec.projeto.projetofatec2025.entities.Cliente;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    
    //Não esta funcionando:
    //http://localhost:8080/api/cliente/criar
    @PostMapping("/criar")
    public String criarCliente(@RequestBody Cliente entity) {
        //TODO: process POST request
        
        return entity.toString();
    }
    
}
