package org.example.service;

import org.example.dao.TriagemDao;
import org.example.model.Triagem;

import java.util.List;

public class TriagemService {
    private TriagemDao triagemDao;

    public TriagemService(TriagemDao triagemDao){
        this.triagemDao = triagemDao;
    }

    public void cadastrarTriagem(Triagem t){
        triagemDao.cadastrar(t);
    }

    public void atualizarTriagem(Triagem t){
        triagemDao.atualizar(t);
    }

    public void removerTriagem(Triagem t){
        triagemDao.remover(t);
    }

    public Triagem buscarPorId(Long id){
        return triagemDao.buscarPorId(id);
    }

    public List<Triagem> buscarTodos(){
        return triagemDao.buscarTodos();
    }
}
