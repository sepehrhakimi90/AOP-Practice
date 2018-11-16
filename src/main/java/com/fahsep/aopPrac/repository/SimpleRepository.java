package com.fahsep.aopPrac.repository;

import com.fahsep.aopPrac.domain.DomainObject;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleRepository {

    public DomainObject findDomainObject() {
        return new DomainObject();
    }
}
