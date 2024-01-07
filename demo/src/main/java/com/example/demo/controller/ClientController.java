package com.example.demo.controller;

import com.example.demo.model.ClientModel;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/cliente")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(path = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getData(@RequestParam(name = "documentType") String documentType,
                                                @RequestParam(name = "cedula") String cedula){
        //Metodo para objetos json (lo que recibe para la peticion es un json el @RequestParam)
        return service.getData(documentType, cedula);
    }

    @GetMapping(path = "/findById/{_id}")
    public Optional<ClientModel> getClientById (@PathVariable Long _id){
        return service.getClientById(_id);
    }

    @GetMapping(path = "/findAllClientes/")
    public ResponseEntity<?>getClientes(){
        return service.getClientes();
    }

    @GetMapping(path = "/findByCedula/{_id}")
    public Optional<ClientModel> getClientByCliente (@PathVariable Long _id){
        return service.getClientById(_id);
    }

    @PostMapping(path = "/guardarCliente/")
    public ResponseEntity<?> saveCliente(@RequestBody ClientModel cliente){
        return service.saveCliente(cliente);
    }
}
