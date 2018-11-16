package com.fahsep.aopPrac.service;

import com.fahsep.aopPrac.domain.DomainObject;
import com.fahsep.aopPrac.repository.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    @Autowired
    SimpleRepository repository;

    public DomainObject service() {
        return repository.findDomainObject();
    }

    public void doSomthing() {}

    public void doSomethingElse(int dummy) {}
}
