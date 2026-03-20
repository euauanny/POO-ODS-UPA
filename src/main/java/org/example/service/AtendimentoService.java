package org.example.service;

import org.example.dao.AtendimentoDao;
import org.example.model.Atendimento;
import org.example.vo.MediaAtendimentosPorDiaVo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoService {
    private AtendimentoDao atendimentoDao;

    public AtendimentoService(AtendimentoDao atendimentoDao) {
        this.atendimentoDao = atendimentoDao;
    }

    public void cadastrarAtendimento(Atendimento a) {
        atendimentoDao.cadastrar(a);
    }

    public void atualizarAtendimento(Atendimento a) {
        atendimentoDao.atualizar(a);
    }

    public void removerAtendimento(Atendimento a) {
        atendimentoDao.remover(a);
    }

    public Atendimento buscarPorId(Long id){
        return atendimentoDao.buscarPorId(id);
    }

    public List<Atendimento> buscarTodos(){
        return atendimentoDao.buscarTodos();
    }

    public List<MediaAtendimentosPorDiaVo> retornaRelatorioAtendimentosPorDia(LocalDate dataIni, LocalDate dataFim) {
        List<Object[]> linhas = atendimentoDao.relatorioAtendimentosPorDia(dataIni, dataFim);
        List<MediaAtendimentosPorDiaVo> lista = new ArrayList<>();

        for (Object[] l : linhas) {
            LocalDate data;
            if (l[0] instanceof java.sql.Date sqlDate) {
                data = sqlDate.toLocalDate();
            } else if (l[0] instanceof java.time.LocalDate ld) {
                data = ld;
            } else if (l[0] instanceof java.time.LocalDateTime ldt) {
                data = ldt.toLocalDate();
            } else {
                continue;
            }

            Long qtd = (Long) l[1];
            lista.add(new MediaAtendimentosPorDiaVo(data, qtd));
        }

        return lista;
    }



}
