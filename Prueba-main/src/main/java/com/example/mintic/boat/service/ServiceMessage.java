package com.example.mintic.boat.service;

import java.util.List;
import java.util.Optional;

import com.example.mintic.boat.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.boat.model.Message;
import com.example.mintic.boat.repository.RepositoryMessage;

@Service
public class ServiceMessage {

    @Autowired
    private RepositoryMessage repositoryMessage;

    
    public List<Message> getAll() {
        return repositoryMessage.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return repositoryMessage.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return repositoryMessage.save(message);
        } else {
            Optional<Message> message1 = repositoryMessage.getMessage(message.getIdMessage());
            if (message1.isEmpty()) {
                return repositoryMessage.save(message);
            } else {
                return message;
            }
        }
    }
    public boolean delete(int id) {
        return repositoryMessage.delete(id);
    }


    public Message update(Message message) {
        return repositoryMessage.save(message);
    }

}
