package org.example.service;

import org.example.dao.PrescricaoDao;
import org.example.model.Prescricao;
import org.example.vo.MedicamentoMaisPrescritoVo;

import java.util.List;

public class PrescricaoService {
    private PrescricaoDao prescricaoDao;

    public PrescricaoService(PrescricaoDao prescricaoDao) {
        this.prescricaoDao = prescricaoDao;
    }

    public void cadastrarPrescricao(Prescricao p){
        prescricaoDao.cadastrar(p);
    }

    public void atualizarPrescricao(Prescricao p){
        prescricaoDao.atualizar(p);
    }

    public void removerPrescricao(Prescricao p){
        prescricaoDao.remover(p);
    }

    public Prescricao buscarPorId(Long id){
        return prescricaoDao.buscarPorId(id);
    }

    public List<Prescricao> buscarTodos(){
        return prescricaoDao.buscarTodos();
    }


    public List<MedicamentoMaisPrescritoVo> retornaMedicamentosMaisPrescritosNaUltimaSemana() {
        return this.prescricaoDao.medicamentosMaisPrescritosNaUltimaSemana();
    }

}
