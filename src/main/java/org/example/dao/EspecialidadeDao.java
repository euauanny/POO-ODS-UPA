package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Especialidade;

public class EspecialidadeDao extends GenericDao<Especialidade> {
    public EspecialidadeDao(EntityManager em) {
        super(em, Especialidade.class);
    }
}
