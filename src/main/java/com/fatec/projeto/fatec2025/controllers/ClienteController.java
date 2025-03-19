package com.fatec.projeto.fatec2025.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.projeto.fatec2025.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class.getName());

    private final List<Cliente> clientes = new ArrayList<>();
    private Long idCount = 1L;

    //http://localhost:8080/api/cliente/criarCliente => POST
    @PostMapping("/criarCliente")
    public String CriarCliente(@RequestBody Cliente cliente) {
        cliente.setId(idCount++);
        clientes.add(cliente);
 
        logger.info("Recebido JSON: Nome={}, Idade={}", cliente.getNome(), cliente.getIdade());
        return "O Cliente "+cliente.getNome()+ " de idade "+cliente.getIdade()+" foi criado";
    }

    @GetMapping("/listarClientes")
    public List<Cliente> ListarClientes() {
        return clientes;
    }

    @GetMapping("/cliente")
    public Cliente ListarCliente(@RequestParam long id) {

        Cliente retCliente = null;
        for (Cliente cliente : clientes) {
            if(cliente.getId()== id){
                retCliente = cliente;
            }
        }
        return retCliente;
    }

    @PutMapping("/atualizarCliente")
    public String AtualizarCliente(@RequestParam long id, @RequestBody Cliente cliente) {
            
        for (Cliente c : clientes) {
            if(c.getId()== id){
                c.setNome(cliente.getNome().isEmpty()?c.getNome():cliente.getNome());
                c.setIdade(cliente.getIdade());
                c.setEndereco(cliente.getEndereco().isEmpty()?c.getEndereco():cliente.getEndereco());
                return "Cliente: "+ c.getNome()+" foi atualizado com sucesso.";
            }
        }
        return "Nenhum cliente correspondente";
    }

    @DeleteMapping("/deletarCliente")
    public String DeletarCliente(@RequestParam int id){

        for (Cliente cliente : clientes) {
            if(cliente.getId()== id){
                clientes.remove(cliente);
                return "Cliente: "+ cliente.getNome()+" foi removido com sucesso.";
            }
        }
        return "Nenhum cliente correspondente";
    }
    
}