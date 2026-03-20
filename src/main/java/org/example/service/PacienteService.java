package org.example.service;

import org.example.dao.PacienteDao;
import org.example.model.Paciente;

import java.util.List;

public class PacienteService {
    private PacienteDao pacienteDao;

    public PacienteService(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public void cadastrarPaciente(Paciente p) {
        pacienteDao.cadastrar(p);
    }

    public void atualizarPaciente(Paciente p) {
        pacienteDao.atualizar(p);
    }

    public void removerPaciente(Paciente p) {
        pacienteDao.remover(p);
    }

    public Paciente buscarPorId(Long id) {
        return pacienteDao.buscarPorId(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteDao.buscarTodos();
    }
}
