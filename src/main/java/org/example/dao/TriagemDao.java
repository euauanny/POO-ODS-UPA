package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Triagem;

public class TriagemDao extends GenericDao<Triagem>{
    public  TriagemDao(EntityManager em) {
        super(em, Triagem.class);
    }
}
