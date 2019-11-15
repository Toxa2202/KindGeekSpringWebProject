package com.saint.anthony.ryanairspringweb.repository;


import com.saint.anthony.ryanairspringweb.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    List<Message> findByTag(String tag);

}
