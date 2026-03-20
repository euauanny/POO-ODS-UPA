package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Triagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    private LocalDateTime dataHora;
    private String pressaoArterial;
    private Double temperatura;
    private Integer frequenciaCardiaca;
    private Integer saturacaoO2;
    private Double peso;
    private Double altura;
    private String prioridade; // BAIXA, MEDIA, ALTA, URGENTE
    private String queixaPrincipal;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(Integer frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public Integer getSaturacaoO2() {
        return saturacaoO2;
    }

    public void setSaturacaoO2(Integer saturacaoO2) {
        this.saturacaoO2 = saturacaoO2;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    public void setQueixaPrincipal(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    @Override
    public String toString() {
        return
                " Data e hora: " + dataHora +
                ", Pressao Arterial: '" + pressaoArterial +
                ", Temperatura: " + temperatura + " °C" +
                ", Frequencia Cardiaca: " + frequenciaCardiaca +
                ", Saturacao: " + saturacaoO2 +
                ", Peso: " + peso +
                ", Altura: " + altura +
                ", Prioridade: " + prioridade +
                ", Queixa principal: " + queixaPrincipal;

    }
}
