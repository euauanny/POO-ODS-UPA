package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Convenio;

public class ConvenioDao extends GenericDao<Convenio>{
    public ConvenioDao(EntityManager em) {
        super(em, Convenio.class);
    }
}
