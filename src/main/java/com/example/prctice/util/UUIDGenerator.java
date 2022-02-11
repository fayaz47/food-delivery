package com.example.prctice.util;

import com.example.prctice.Entity.Identifiable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.io.Serializable;
import java.util.Objects;

public class UUIDGenerator extends org.hibernate.id.UUIDGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sessionContractImplementor, Object object) throws HibernateException {
        if(object instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) object;
            if(Objects.nonNull(identifiable.getId())) {
               return identifiable.getId();
            }
        }
        return  super.generate(sessionContractImplementor,object);
    }
}
