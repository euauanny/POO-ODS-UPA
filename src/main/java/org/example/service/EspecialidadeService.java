package org.example.service;

import org.example.dao.EspecialidadeDao;
import org.example.model.Especialidade;

import java.util.List;

public class EspecialidadeService {
    private EspecialidadeDao especialidadeDao;

    public EspecialidadeService(EspecialidadeDao especialidadeDao) {
        this.especialidadeDao = especialidadeDao;
    }

    public void cadastrarEspecialidade(Especialidade e) {
        this.especialidadeDao.cadastrar(e);
    }

    public void atualizarEspecialidade(Especialidade e) {
        this.especialidadeDao.atualizar(e);
    }

    public void removerEspecialidade(Especialidade e) {
        this.especialidadeDao.remover(e);
    }

    public Especialidade buscarPorId(Long id){
        return especialidadeDao.buscarPorId(id);
    }

    public List<Especialidade> buscarTodos(){
        return especialidadeDao.buscarTodos();
    }
}
