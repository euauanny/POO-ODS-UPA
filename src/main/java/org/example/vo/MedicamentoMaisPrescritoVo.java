package org.example.vo;

public class MedicamentoMaisPrescritoVo {
    private String medicamento;
    private Long quantidadePrescricoes;

    public MedicamentoMaisPrescritoVo(String medicamento, Long quantidadePrescricoes) {
        this.medicamento = medicamento;
        this.quantidadePrescricoes = quantidadePrescricoes;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public Long getQuantidadePrescricoes() {
        return quantidadePrescricoes;
    }

    @Override
    public String toString() {
        return "Medicamento: " + medicamento +
                ", Quantidade de prescricoes: " + quantidadePrescricoes;
    }
}
