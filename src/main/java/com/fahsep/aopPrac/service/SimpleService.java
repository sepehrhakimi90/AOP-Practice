package com.fahsep.aopPrac.service;

import com.fahsep.aopPrac.domain.DomainObject;
import com.fahsep.aopPrac.repository.SimpleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    Logger logger = LoggerFactory.getLogger(SimpleService.class);

    @Autowired
    SimpleRepository repository;

    public DomainObject service() {
        return repository.findDomainObject();
    }

    public void doSomthing() {
        logger.trace("doSmthing called");
    }

    public void doSomethingElse(int dummy) {
        logger.trace("doSomethingElse called");
    }

    public void throwsRuntimeException() {
        throw new RuntimeException();
    }

    public void throwsException() throws Exception {
        throw new Exception();
    }

    public int returnsInt() {
        return 42;
    }

    public String returnsString() {
        return "You are one the Best";
    }
}
