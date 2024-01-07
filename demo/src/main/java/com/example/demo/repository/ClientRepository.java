package com.example.demo.repository;

import com.example.demo.model.ClientModel;
import jakarta.websocket.ClientEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    @Query(value = "SELECT c FROM ClientModel c WHERE c.documentnumber = :ced ")
    public ClientModel getByIdentificacion(String ced);
}
