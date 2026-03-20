package org.example.service;

import org.example.dao.MedicoDao;
import org.example.model.Medico;
import java.util.List;

public class MedicoService {
    private MedicoDao medicoDao;

    public MedicoService(MedicoDao medicoDao) {
        this.medicoDao = medicoDao;
    }

    public void cadastrarMedico(Medico m) {
        medicoDao.cadastrar(m);
    }

    public void atualizarMedico(Medico m) {
        medicoDao.atualizar(m);
    }

    public void removerMedico(Medico m) {
        medicoDao.remover(m);
    }

    public Medico buscarPorId(Long id) {
        return medicoDao.buscarPorId(id);
    }

    public List<Medico> buscarTodos() {
        return medicoDao.buscarTodos();
    }
}
