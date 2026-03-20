package org.example.service;

import org.example.dao.ConvenioDao;
import org.example.model.Convenio;

import java.util.List;

public class ConvenioService {
    private ConvenioDao convenioDao;

    public ConvenioService(ConvenioDao convenioDao) {
        this.convenioDao = convenioDao;
    }

    public void cadastrarConvenio(Convenio c) {
        convenioDao.cadastrar(c);
    }

    public void atualizarConvenio(Convenio c) {
        convenioDao.atualizar(c);
    }

    public void removerConvenio(Convenio c) {
        convenioDao.remover(c);
    }

    public Convenio buscarPorId(Long id){
        return convenioDao.buscarPorId(id);
    }

    public List<Convenio> buscarTodos(){
        return convenioDao.buscarTodos();
    }

}
