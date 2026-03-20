package org.example.vo;

import java.time.LocalDate;

public class MediaAtendimentosPorDiaVo {
    private LocalDate data;
    private Long quantidadeAtendimentos;

    public MediaAtendimentosPorDiaVo(LocalDate data, Long quantidadeAtendimentos) {
        this.data = data;
        this.quantidadeAtendimentos = quantidadeAtendimentos;
    }

    public LocalDate getData() { return data; }
    public Long getQuantidadeAtendimentos() { return quantidadeAtendimentos; }

    @Override
    public String toString() {
        return "Data: " + data +
                ", Quantidade média de atendimentos: " + quantidadeAtendimentos;
    }
}
