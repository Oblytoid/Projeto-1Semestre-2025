package com.fatec.projeto.fatec2025.domain.cliente;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.projeto.fatec2025.controllers.ClienteController;
import com.fatec.projeto.fatec2025.entities.Cliente;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository _ClienteRepository;
    

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class.getName());

    private final List<Cliente> clientes = new ArrayList<>();
    private Long idCount = 1L;

    public List<Cliente> listarCliente(){
        return _ClienteRepository.findAll();
    }

    public void criarCliente(Cliente cliente){

    }

    public Boolean AtualizarCliente(Long id, Cliente _Cliente){
        
            for (Cliente c : clientes) {
            if(c.getId()== id){
                c.setNome(_Cliente.getNome().isEmpty()?c.getNome():_Cliente.getNome());
                c.setIdade(_Cliente.getIdade());
                c.setEndereco(_Cliente.getEndereco().isEmpty()?c.getEndereco():_Cliente.getEndereco());
                return true;
            }
        }
        return false;
    }

    public boolean DeletarCliente(){

        return true;
    }
}