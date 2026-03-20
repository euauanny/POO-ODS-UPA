package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Prescricao;
import org.example.vo.MedicamentoMaisPrescritoVo;

import java.time.LocalDate;
import java.util.List;

public class PrescricaoDao extends GenericDao<Prescricao>{
    public PrescricaoDao(EntityManager em) {
        super(em, Prescricao.class);
    }


    public List<MedicamentoMaisPrescritoVo> medicamentosMaisPrescritosNaUltimaSemana() {
        LocalDate hoje = LocalDate.now();
        LocalDate seteDiasAtras = hoje.minusDays(7);

        String jpql = "SELECT new org.example.vo.MedicamentoMaisPrescritoVo(" +
                "p.medicamento, COUNT(p)) " +
                "FROM Prescricao p " +
                "WHERE p.atendimento.dataHoraEntrada BETWEEN :dataIni AND :dataFim " +
                "GROUP BY p.medicamento " +
                "ORDER BY COUNT(p) DESC";

        return em.createQuery(jpql, MedicamentoMaisPrescritoVo.class)
                .setParameter("dataIni", seteDiasAtras.atStartOfDay())
                .setParameter("dataFim", hoje.atTime(23, 59, 59))
                .getResultList();
    }

}

