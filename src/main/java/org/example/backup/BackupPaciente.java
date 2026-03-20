package org.example.backup;

import org.example.model.Paciente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BackupPaciente {

    private static final String ARQUIVO_BACKUP = "pacientes-backup.ser";

    public void salvarListaPacientes(List<Paciente> pacientes) throws IOException {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(ARQUIVO_BACKUP))) {
            oos.writeObject(pacientes);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Paciente> carregarListaPacientes() throws IOException, ClassNotFoundException {
        File file = new File(ARQUIVO_BACKUP);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(ARQUIVO_BACKUP))) {
            return (List<Paciente>) ois.readObject();
        }
    }
}
