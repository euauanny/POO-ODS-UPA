package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Medico;

import java.util.List;

public class MedicoDao extends GenericDao<Medico> {
    public MedicoDao(EntityManager em) {
        super(em, Medico.class);
    }

}
