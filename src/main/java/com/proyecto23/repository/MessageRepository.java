package com.proyecto23.repository;

import com.proyecto23.model.Box;
import com.proyecto23.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,Integer> {
}
