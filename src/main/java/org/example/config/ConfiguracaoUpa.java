package org.example.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfiguracaoUpa {

    private static final String ARQUIVO_CONFIG = "upa-config.properties";

    private Properties props = new Properties();

    public void carregar() throws IOException {
        Path path = Path.of(ARQUIVO_CONFIG);
        if (Files.exists(path)) {
            try (FileInputStream fis = new FileInputStream(ARQUIVO_CONFIG)) {
                props.load(fis);
            }
        }
    }

    public void salvar() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(ARQUIVO_CONFIG)) {
            props.store(fos, "Configuracoes da UPA");
        }
    }

    public String getNomeUpa() {
        return props.getProperty("upa.nome", "UPA Sem Nome");
    }

    public void setNomeUpa(String nome) {
        props.setProperty("upa.nome", nome);
    }

    public int getTempoMaxEsperaMinutos() {
        return Integer.parseInt(props.getProperty("upa.tempoMaxEsperaMinutos", "120"));
    }

    public void setTempoMaxEsperaMinutos(int minutos) {
        props.setProperty("upa.tempoMaxEsperaMinutos", String.valueOf(minutos));
    }

    public String getCidade() {
        return props.getProperty("upa.cidade", "Cidade Desconhecida");
    }

    public void setCidade(String cidade) {
        props.setProperty("upa.cidade", cidade);
    }
}

