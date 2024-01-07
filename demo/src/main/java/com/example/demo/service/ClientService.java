package com.example.demo.service;

import com.example.demo.model.ClientModel;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public Optional<ClientModel> getClientById(Long id){
        return repository.findById(id);
    }

    public ResponseEntity<?> saveCliente(ClientModel cliente){
        if(cliente != null){
            if(cliente.getDocumentnumber() != null && cliente.getDocumentType() != null){
                return new ResponseEntity<>(repository.save(cliente), HttpStatus.OK);
            }return new ResponseEntity<>("Faltan Parametros", HttpStatus.INTERNAL_SERVER_ERROR);
        }else return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<?> getData(String documentType, String document){

        String mensaje = "";
        ClientModel cliente_ = new ClientModel();
        if("C".equals(documentType) || "P".equals(documentType)) {
            if ("12345678".equals(document)) {
                //cliente_ = repository.getByIdentificacion(document);
                cliente_.setId(-1L);
                cliente_.setFirstname("Jhon");
                cliente_.setSecondname("Voyager");
                cliente_.setFirstlastname("Smith");
                cliente_.setSecondlastname("Titor");
                cliente_.setDocumentnumber("12345678");
                cliente_.setDocumentType("C");
                cliente_.setNumberPhone("0939386953");
                cliente_.setAddress("En algún lugar de un gran país");
            }else mensaje = "Identificacion Incorrecta";
        }else mensaje = "Tipo de Documento no permitido";
        if(cliente_ != null && cliente_.getId() != null) {
            return new ResponseEntity<>(cliente_, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?>getClientes(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}
