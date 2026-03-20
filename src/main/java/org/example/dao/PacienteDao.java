package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Paciente;

public class PacienteDao extends GenericDao<Paciente> {
    public PacienteDao(EntityManager em) {
        super(em, Paciente.class);
    }

}
