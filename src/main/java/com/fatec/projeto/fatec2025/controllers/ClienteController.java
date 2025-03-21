package com.fatec.projeto.fatec2025.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.projeto.fatec2025.entities.Cliente;
import com.fatec.projeto.fatec2025.domain.cliente.ClienteService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService _ClienteService;

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class.getName());

    private final List<Cliente> clientes = new ArrayList<>();
    private Long idCount = 1L;

    //http://localhost:8080/api/cliente/criarCliente => POST
    @PostMapping("/criarCliente")
    public ResponseEntity<String> CriarCliente(@RequestBody Cliente cliente) {
        cliente.setId(idCount++);
        clientes.add(cliente);
 
        logger.info("Recebido JSON: Nome={}, Idade={}", cliente.getNome(), cliente.getIdade());
        return new ResponseEntity<>("O Cliente "+cliente.getNome()+ " de idade "+cliente.getIdade()+" foi criado", HttpStatus.OK);
    }

    @GetMapping("/listarClientes")
    public ResponseEntity<List<Cliente>> ListarClientes() {
        return new ResponseEntity<>( _ClienteService.listarCliente(), HttpStatus.OK);
    }

    @GetMapping("/cliente")
    public ResponseEntity<Cliente> ListarCliente(@RequestParam long id) {

        Cliente retCliente = null;
        for (Cliente cliente : clientes) {
            if(cliente.getId()== id){
                retCliente = cliente;
                return new ResponseEntity<>(retCliente,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @PutMapping("/atualizarCliente")
    public ResponseEntity<String> AtualizarCliente(@RequestParam long id, @RequestBody Cliente cliente) {
        
        if(!_ClienteService.AtualizarCliente(idCount, cliente))
        return new ResponseEntity<>("Nenhum cliente correspondente", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>("Cliente: "+ cliente.getNome()+" foi atualizado com sucesso.",HttpStatus.OK);
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