package com.saint.anthony.ryanairspringweb.repository;

import com.saint.anthony.ryanairspringweb.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
