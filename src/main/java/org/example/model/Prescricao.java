package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Prescricao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    private Atendimento atendimento;

    private String medicamento;
    private String dosagem;
    private String frequencia;
    private String duracao;
    private String orientacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getOrientacoes() {
        return orientacoes;
    }

    public void setOrientacoes(String orientacoes) {
        this.orientacoes = orientacoes;
    }

    @Override
    public String toString() {
        return "Id da prescriçao: " + id +
                ", Medicamento: " + medicamento +
                ", Dosagem: " + dosagem +
                ", Frequencia: " + frequencia +
                ", Duracao: " + duracao +
                ", Orientaçoes: '" + orientacoes +
                ", Id do atendimento: " + (atendimento != null ? atendimento.getId() : null);
    }

}
