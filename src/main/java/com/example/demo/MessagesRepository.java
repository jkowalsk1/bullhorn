package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by oracle on 8/16/17.
 */
public interface MessagesRepository extends CrudRepository<Messages, Long> {
}
