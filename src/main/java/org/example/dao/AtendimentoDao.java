package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Atendimento;
import org.example.vo.MediaAtendimentosPorDiaVo;

import java.time.LocalDate;
import java.util.List;

public class AtendimentoDao extends GenericDao<Atendimento>{
    public AtendimentoDao(EntityManager em) {
        super(em, Atendimento.class);
    }


    public List<Object[]> relatorioAtendimentosPorDia(LocalDate dataIni, LocalDate dataFim) {
        String jpql =
                "SELECT FUNCTION('date', a.dataHoraEntrada), COUNT(a.id) " +
                        "FROM Atendimento a " +
                        "WHERE a.dataHoraEntrada BETWEEN :dataIni AND :dataFim " +
                        "GROUP BY FUNCTION('date', a.dataHoraEntrada) " +
                        "ORDER BY FUNCTION('date', a.dataHoraEntrada)";

        return em.createQuery(jpql, Object[].class)
                .setParameter("dataIni", dataIni.atStartOfDay())
                .setParameter("dataFim", dataFim.atTime(23, 59, 59))
                .getResultList();
    }



}
