package org.example;

import org.example.backup.BackupPaciente;
import org.example.config.ConfiguracaoUpa;
import org.example.dao.*;
import org.example.model.*;
import org.example.service.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.vo.MediaAtendimentosPorDiaVo;
import org.example.vo.MedicamentoMaisPrescritoVo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static EntityManager em;

    public static void main(String[] args) {

        ConfiguracaoUpa config = new ConfiguracaoUpa();
        try {
            config.carregar();
            System.out.println("Configuracao carregada. UPA: " + config.getNomeUpa()
                    + " - Cidade: " + config.getCidade()
                    + " - Tempo max espera: " + config.getTempoMaxEsperaMinutos() + " min");
        } catch (IOException e) {
            System.out.println("Nao foi possivel carregar configuracao. Usando padrao.");
        }

        BackupPaciente backupPaciente = new BackupPaciente();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UpaPU");
        em = emf.createEntityManager();

        PacienteDao pacienteDao = new PacienteDao(em);
        PacienteService pacienteService = new PacienteService(pacienteDao);

        MedicoDao medicoDao = new MedicoDao(em);
        MedicoService medicoService = new MedicoService(medicoDao);

        ConvenioDao convenioDao = new ConvenioDao(em);
        ConvenioService convenioService = new ConvenioService(convenioDao);

        AtendimentoDao atendimentoDao = new AtendimentoDao(em);
        AtendimentoService atendimentoService = new AtendimentoService(atendimentoDao);

        EspecialidadeDao especialidadeDao = new EspecialidadeDao(em);
        EspecialidadeService especialidadeService = new EspecialidadeService(especialidadeDao);

        PrescricaoDao prescricaodao = new PrescricaoDao(em);
        PrescricaoService prescricaoService = new PrescricaoService(prescricaodao);

        TriagemDao triagemDao = new TriagemDao(em);
        TriagemService triagemService = new TriagemService(triagemDao);


        boolean continuar = true;
        while (continuar) {
            System.out.println("--- MENU ---");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Consultar Paciente por ID");
            System.out.println("5. Listar todos os Pacientes");
            System.out.println("6. Cadastrar Médico");
            System.out.println("7. Listar Médicos");
            System.out.println("8. Alterar Médico");
            System.out.println("9. Excluir Médico");
            System.out.println("10. Consultar Médico por ID");
            System.out.println("11. Cadastrar Convenio");
            System.out.println("12. Alterar Convenio");
            System.out.println("13. Excluir Convenio");
            System.out.println("14 Consultar Convenio");
            System.out.println("15. Listar convenios");
            System.out.println("16. Cadastrar triagem");
            System.out.println("17. Alterar triagem");
            System.out.println("18. Excluir triagem");
            System.out.println("19. Consultar triagem");
            System.out.println("20. Listar triagens");
            System.out.println("21. Cadastrar um atendimento");
            System.out.println("22. Alterar um atendimento");
            System.out.println("23. Excluir um atendimento");
            System.out.println("24. Consultar um atendimento pelo ID");
            System.out.println("25. Listar todos os atendimentos");
            System.out.println("26. Cadastrar especialidade");
            System.out.println("27. Alterar especialidade");
            System.out.println("28. Excluir especialidade");
            System.out.println("29. Consultar especialidade");
            System.out.println("30. Listar especialidades");
            System.out.println("31. Cadastrar prescricoes");
            System.out.println("32. Alterar prescricoes");
            System.out.println("33. Excluir prescricoes");
            System.out.println("34. Consultar prescriçao");
            System.out.println("35. Listar prescricoes");
            System.out.println("36. Relatório de média de atendimentos por dia");
            System.out.println("37. Relatório dos medicamentos mais prescritos na última semana");
            System.out.println("38. Configurar UPA");
            System.out.println("39. Fazer backup de pacientes");
            System.out.println("40. Restaurar pacientes do backup");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPaciente(pacienteService);
                case 2 -> alterarPaciente(pacienteService);
                case 3 -> excluirPaciente(pacienteService);
                case 4 -> consultarPacientePorId(pacienteService);
                case 5 -> listarPacientes(pacienteService);
                case 6 -> cadastrarMedico(medicoService, especialidadeService);
                case 7 -> listarMedicos(medicoService);
                case 8 -> alterarMedico(medicoService);
                case 9 -> excluirMedico(medicoService);
                case 10 -> consultarMedicoPorId(medicoService);
                case 11 -> cadastrarConvenio(convenioService);
                case 12 -> alterarConvenio(convenioService);
                case 13 -> excluirConvenio(convenioService);
                case 14 -> consultarConvenio(convenioService);
                case 15 -> listarConvenios(convenioService);
                case 16 -> cadastrarTriagem(triagemService, pacienteService);
                case 17-> alterarTriagem(triagemService);
                case 18-> excluirTriagem(triagemService);
                case 19-> consultarTriagem(triagemService);
                case 20 -> listarTriagens(triagemService);
                case 21 -> cadastrarAtendimento(atendimentoService, pacienteService, medicoService, triagemService);
                case 22 -> alterarAtendimento(atendimentoService);
                case 23 -> excluirAtendimento(atendimentoService);
                case 24 -> consultarAtendimentoPorId(atendimentoService);
                case 25 -> listarAtendimentos(atendimentoService);
                case 26 -> cadastrarEspecialidade(especialidadeService);
                case 27 -> alterarEspecialidade(especialidadeService);
                case 28 -> excluirEspecialidade(especialidadeService);
                case 29 -> consultarEspecialidade(especialidadeService);
                case 30 -> listarEspecialidades(especialidadeService);
                case 31 -> cadastrarPrescricao(prescricaoService, atendimentoService);
                case 32 -> alterarPrescricao(prescricaoService);
                case 33 -> excluirPrescricao(prescricaoService);
                case 34 -> consultarPrescricao(prescricaoService);
                case 35 -> listarPrescricoes(prescricaoService);
                case 36 -> consultarRelatorioAtendimentosPorDia(atendimentoService);
                case 37 -> consultarMedicamentosMaisPrescritosNaUltimaSemana(prescricaoService);
                case 38 -> configurarUpa(config);
                case 39 -> fazerBackupPacientes(pacienteService, backupPaciente);
                case 40 -> restaurarPacientesDoBackup(pacienteService, backupPaciente);


                case 0 -> continuar = false;
                default -> System.out.println("Opção inválida!");
            }
        }

        em.close();
        emf.close();
        System.out.println("Sistema encerrado.");
    }

    //entidade paciente
    private static void cadastrarPaciente(PacienteService pacienteService) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data Nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();


        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setCpf(cpf);
        paciente.setDataNascimento(dataNascimento);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setEndereco(endereco);
        pacienteService.cadastrarPaciente(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void alterarPaciente(PacienteService pacienteService) {
        System.out.print("ID do paciente: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Paciente paciente = pacienteService.buscarPorId(id);
        if (paciente != null) {
            System.out.print("Novo telefone: ");
            paciente.setTelefone(scanner.nextLine());
            System.out.print("Novo email: ");
            paciente.setEmail(scanner.nextLine());
            pacienteService.atualizarPaciente(paciente);
            System.out.println("Paciente atualizado com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void excluirPaciente(PacienteService pacienteService) {
        System.out.print("ID do paciente: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Paciente paciente = pacienteService.buscarPorId(id);
        if (paciente != null) {
            pacienteService.removerPaciente(paciente);
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void consultarPacientePorId(PacienteService pacienteService) {
        System.out.print("ID do paciente: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Paciente paciente = pacienteService.buscarPorId(id);
        System.out.println(paciente != null ? paciente : "Paciente não encontrado.");
    }

    private static void listarPacientes(PacienteService pacienteService) {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            pacientes.forEach(System.out::println);
        }
    }

    //entidade medico
    private static void cadastrarMedico(MedicoService medicoService,
                                        EspecialidadeService especialidadeService) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Data de Admissão (AAAA-MM-DD): ");
        LocalDate dataAdmissao = LocalDate.parse(scanner.nextLine());

        System.out.print("ID da especialidade: ");
        Long especialidadeId = scanner.nextLong();
        scanner.nextLine();

        Especialidade especialidade = especialidadeService.buscarPorId(especialidadeId);
        if (especialidade == null) {
            System.out.println("Especialidade não encontrada. Cadastre antes de vincular ao médico.");
            return;
        }

        Medico medico = new Medico();
        medico.setNome(nome);
        medico.setCrm(crm);
        medico.setTelefone(telefone);
        medico.setEmail(email);
        medico.setDataAdmissao(dataAdmissao);
        medico.setEspecialidade(especialidade);

        medicoService.cadastrarMedico(medico);
        System.out.println("Médico cadastrado com sucesso!");
    }


    private static void alterarMedico(MedicoService medicoService) {
        System.out.print("ID do medico: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Medico medico = medicoService.buscarPorId(id);
        if (medico != null) {
            System.out.print("Novo telefone: ");
            medico.setTelefone(scanner.nextLine());
            System.out.print("Novo email: ");
            medico.setEmail(scanner.nextLine());
            medicoService.atualizarMedico(medico);
            System.out.println("Medico atualizado com sucesso!");
        } else {
            System.out.println("Medico não encontrado.");
        }
    }

    private static void excluirMedico(MedicoService medicoService) {
        System.out.print("ID do medico: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Medico medico = medicoService.buscarPorId(id);
        if (medico != null) {
            medicoService.removerMedico(medico);
            System.out.println("Medico removido com sucesso!");
        } else {
            System.out.println("Medico não encontrado.");
        }
    }

    private static void consultarMedicoPorId(MedicoService medicoService) {
        System.out.print("ID do medico: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Medico medico = medicoService.buscarPorId(id);
        System.out.println(medico != null ? medico : "Medico não encontrado.");
    }

    private static void listarMedicos(MedicoService medicoService) {
        List<Medico> medicos = medicoService.buscarTodos();
        if (medicos.isEmpty()) {
            System.out.println("Nenhum medico cadastrado.");
        } else {
            medicos.forEach(System.out::println);
        }
    }

    //entidade convenio
    private static void cadastrarConvenio(ConvenioService convenioService) {
        System.out.print("Nome do convênio: ");
        String nome = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Ativo? (s/n): ");
        boolean ativo = scanner.nextLine().equalsIgnoreCase("s");

        Convenio convenio = new Convenio();
        convenio.setNome(nome);
        convenio.setCnpj(cnpj);
        convenio.setTelefone(telefone);
        convenio.setAtivo(ativo);

        convenioService.cadastrarConvenio(convenio);
        System.out.println("Convênio cadastrado com sucesso!");
    }

    private static void alterarConvenio(ConvenioService convenioService) {
        System.out.print("ID do convênio: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Convenio convenio = convenioService.buscarPorId(id);
        if (convenio != null) {
            System.out.print("Novo telefone: ");
            convenio.setTelefone(scanner.nextLine());
            System.out.print("Novo status (ativo? s/n): ");
            boolean ativo = scanner.nextLine().equalsIgnoreCase("s");
            convenio.setAtivo(ativo);
            convenioService.atualizarConvenio(convenio);
            System.out.println("Convênio atualizado com sucesso!");
        } else {
            System.out.println("Convênio não encontrado.");
        }
    }

    private static void excluirConvenio(ConvenioService convenioService) {
        System.out.print("ID do convênio: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Convenio convenio = convenioService.buscarPorId(id);
        if (convenio != null) {
            convenioService.removerConvenio(convenio);
            System.out.println("Convênio removido com sucesso!");
        } else {
            System.out.println("Convênio não encontrado.");
        }
    }

    private static void consultarConvenio(ConvenioService convenioService) {
        System.out.print("ID do convênio: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Convenio convenio = convenioService.buscarPorId(id);
        System.out.println(convenio != null ? convenio : "Convênio não encontrado.");
    }

    private static void listarConvenios(ConvenioService convenioService) {
        List<Convenio> convenios = convenioService.buscarTodos();
        if (convenios.isEmpty()) {
            System.out.println("Nenhum convênio cadastrado.");
        } else {
            convenios.forEach(System.out::println);
        }
    }

    //entidade atendimento
    private static void cadastrarAtendimento(AtendimentoService atendimentoService,
                                             PacienteService pacienteService,
                                             MedicoService medicoService,
                                             TriagemService triagemService) {
        System.out.print("ID do paciente: ");
        Long pacienteId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("ID do médico: ");
        Long medicoId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("ID da triagem: ");
        Long triagemId = scanner.nextLong();
        scanner.nextLine();

        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        Medico medico = medicoService.buscarPorId(medicoId);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        Triagem triagem = triagemService.buscarPorId(triagemId);
        if (triagem == null) {
            System.out.println("Triagem não encontrada.");
            return;
        }

        System.out.print("Sintomas: ");
        String sintomas = scanner.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine();
        System.out.print("Observações: ");
        String observacoes = scanner.nextLine();
        System.out.print("Status (AGUARDANDO/EM_ATENDIMENTO/FINALIZADO): ");
        String status = scanner.nextLine();

        Atendimento atendimento = new Atendimento();
        atendimento.setPaciente(paciente);
        atendimento.setMedico(medico);
        atendimento.setTriagem(triagem);
        atendimento.setSintomas(sintomas);
        atendimento.setDiagnostico(diagnostico);
        atendimento.setObservacoes(observacoes);
        atendimento.setStatus(status);
        atendimento.setDataHoraEntrada(LocalDateTime.now());
        atendimento.setDataHoraSaida(LocalDateTime.now());

        atendimentoService.cadastrarAtendimento(atendimento);
        System.out.println("Atendimento cadastrado com sucesso!");
    }


    private static void alterarAtendimento(AtendimentoService atendimentoService) {
        System.out.print("ID do atendimento: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Atendimento atendimento = atendimentoService.buscarPorId(id);
        if (atendimento != null) {
            System.out.print("Novo diagnóstico: ");
            String diagnostico = scanner.nextLine();
            System.out.print("Novo status (AGUARDANDO/EM_ATENDIMENTO/FINALIZADO): ");
            String status = scanner.nextLine();

            atendimento.setDiagnostico(diagnostico);
            atendimento.setStatus(status);
            atendimentoService.atualizarAtendimento(atendimento);
            System.out.println("Atendimento atualizado com sucesso!");
        } else {
            System.out.println("Atendimento não encontrado.");
        }
    }

    private static void excluirAtendimento(AtendimentoService atendimentoService) {
        System.out.print("ID do atendimento: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Atendimento atendimento = atendimentoService.buscarPorId(id);
        if (atendimento != null) {
            atendimentoService.removerAtendimento(atendimento);
            System.out.println("Atendimento excluído com sucesso!");
        } else {
            System.out.println("Atendimento não encontrado.");
        }
    }

    private static void consultarAtendimentoPorId(AtendimentoService atendimentoService) {
        System.out.print("ID do atendimento: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Atendimento atendimento = atendimentoService.buscarPorId(id);
        if (atendimento != null) {
            System.out.println(atendimento);
        } else {
            System.out.println("Atendimento não encontrado.");
        }
    }

    private static void listarAtendimentos(AtendimentoService atendimentoService) {
        List<Atendimento> atendimentos = atendimentoService.buscarTodos();
        if (atendimentos.isEmpty()) {
            System.out.println("Nenhum atendimento cadastrado.");
        } else {
            atendimentos.forEach(System.out::println);
        }
    }

    //entidade triagem
    private static void cadastrarTriagem(TriagemService triagemService,
                                         PacienteService pacienteService) {
        System.out.print("ID do paciente: ");
        Long pacienteId = scanner.nextLong();
        scanner.nextLine();

        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.print("Pressão arterial: ");
        String pressao = scanner.nextLine();
        System.out.print("Temperatura: ");
        double temperatura = Double.parseDouble(scanner.nextLine());
        System.out.print("Frequência cardíaca: ");
        int freqCard = Integer.parseInt(scanner.nextLine());
        System.out.print("Saturação O2: ");
        int satO2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Peso (kg): ");
        double peso = Double.parseDouble(scanner.nextLine());
        System.out.print("Altura (m): ");
        double altura = Double.parseDouble(scanner.nextLine());
        System.out.print("Prioridade (BAIXA/MEDIA/ALTA/URGENTE): ");
        String prioridade = scanner.nextLine();
        System.out.print("Queixa principal: ");
        String queixa = scanner.nextLine();

        Triagem triagem = new Triagem();
        triagem.setDataHora(LocalDateTime.now());
        triagem.setPaciente(paciente);
        triagem.setPressaoArterial(pressao);
        triagem.setTemperatura(temperatura);
        triagem.setFrequenciaCardiaca(freqCard);
        triagem.setSaturacaoO2(satO2);
        triagem.setPeso(peso);
        triagem.setAltura(altura);
        triagem.setPrioridade(prioridade);
        triagem.setQueixaPrincipal(queixa);

        triagemService.cadastrarTriagem(triagem);
        System.out.println("Triagem cadastrada com sucesso! ID: " + triagem.getId());
    }


    private static void alterarTriagem(TriagemService triagemService) {
        System.out.print("ID da triagem: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Triagem triagem = triagemService.buscarPorId(id);
        if (triagem == null) {
            System.out.println("Triagem não encontrada.");
            return;
        }

        System.out.print("Nova prioridade (BAIXA/MEDIA/ALTA/URGENTE): ");
        triagem.setPrioridade(scanner.nextLine());
        System.out.print("Nova queixa principal: ");
        triagem.setQueixaPrincipal(scanner.nextLine());

        triagemService.atualizarTriagem(triagem);
        System.out.println("Triagem atualizada com sucesso!");
    }

    private static void excluirTriagem(TriagemService triagemService) {
        System.out.print("ID da triagem: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Triagem triagem = triagemService.buscarPorId(id);
        if (triagem == null) {
            System.out.println("Triagem não encontrada.");
            return;
        }

        triagemService.removerTriagem(triagem);
        System.out.println("Triagem excluída com sucesso!");
    }

    private static void consultarTriagem(TriagemService triagemService) {
        System.out.print("ID da triagem: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Triagem triagem = triagemService.buscarPorId(id);
        System.out.println(triagem != null ? triagem : "Triagem não encontrada.");
    }

    private static void listarTriagens(TriagemService triagemService) {
        List<Triagem> triagens = triagemService.buscarTodos();
        if (triagens.isEmpty()) {
            System.out.println("Nenhuma triagem cadastrada.");
        } else {
            triagens.forEach(System.out::println);
        }
    }

    //entidade especialidade

    private static void cadastrarEspecialidade(EspecialidadeService especialidadeService) {
        System.out.print("Nome da especialidade: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Especialidade esp = new Especialidade();
        esp.setNome(nome);
        esp.setDescricao(descricao);

        especialidadeService.cadastrarEspecialidade(esp);
        System.out.println("Especialidade cadastrada com sucesso! ID: " + esp.getId());
    }

    private static void alterarEspecialidade(EspecialidadeService especialidadeService) {
        System.out.print("ID da especialidade: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Especialidade esp = especialidadeService.buscarPorId(id);
        if (esp == null) {
            System.out.println("Especialidade não encontrada.");
            return;
        }

        System.out.print("Novo nome (enter para manter): ");
        String nome = scanner.nextLine();
        if (!nome.isBlank()) {
            esp.setNome(nome);
        }

        System.out.print("Nova descrição (enter para manter): ");
        String descricao = scanner.nextLine();
        if (!descricao.isBlank()) {
            esp.setDescricao(descricao);
        }

        especialidadeService.atualizarEspecialidade(esp);
        System.out.println("Especialidade atualizada com sucesso!");
    }

    private static void excluirEspecialidade(EspecialidadeService especialidadeService) {
        System.out.print("ID da especialidade: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Especialidade esp = especialidadeService.buscarPorId(id);
        if (esp == null) {
            System.out.println("Especialidade não encontrada.");
            return;
        }

        especialidadeService.removerEspecialidade(esp);
        System.out.println("Especialidade excluída com sucesso!");
    }

    private static void consultarEspecialidade(EspecialidadeService especialidadeService) {
        System.out.print("ID da especialidade: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Especialidade esp = especialidadeService.buscarPorId(id);
        System.out.println(esp != null ? esp : "Especialidade não encontrada.");
    }

    private static void listarEspecialidades(EspecialidadeService especialidadeService) {
        List<Especialidade> especialidades = especialidadeService.buscarTodos();
        if (especialidades.isEmpty()) {
            System.out.println("Nenhuma especialidade cadastrada.");
        } else {
            especialidades.forEach(System.out::println);
        }
    }


//entidade prescricoes

    private static void cadastrarPrescricao(PrescricaoService prescricaoService,
                                            AtendimentoService atendimentoService) {
        System.out.print("ID do atendimento: ");
        Long atendimentoId = scanner.nextLong();
        scanner.nextLine();

        Atendimento atendimento = atendimentoService.buscarPorId(atendimentoId);
        if (atendimento == null) {
            System.out.println("Atendimento não encontrado.");
            return;
        }

        System.out.print("Medicamento: ");
        String medicamento = scanner.nextLine();
        System.out.print("Dosagem: ");
        String dosagem = scanner.nextLine();
        System.out.print("Frequência: ");
        String frequencia = scanner.nextLine();
        System.out.print("Duração: ");
        String duracao = scanner.nextLine();
        System.out.print("Orientações: ");
        String orientacoes = scanner.nextLine();

        Prescricao prescricao = new Prescricao();
        prescricao.setAtendimento(atendimento);
        prescricao.setMedicamento(medicamento);
        prescricao.setDosagem(dosagem);
        prescricao.setFrequencia(frequencia);
        prescricao.setDuracao(duracao);
        prescricao.setOrientacoes(orientacoes);

        prescricaoService.cadastrarPrescricao(prescricao);

        System.out.println("Prescrição cadastrada com sucesso! ID: " + prescricao.getId());
    }


    private static void alterarPrescricao(PrescricaoService prescricaoService) {
        System.out.print("ID da prescrição: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Prescricao p = prescricaoService.buscarPorId(id);
        if (p == null) {
            System.out.println("Prescrição não encontrada.");
            return;
        }

        System.out.print("Novo medicamento (enter para manter): ");
        String medicamento = scanner.nextLine();
        if (!medicamento.isBlank()) p.setMedicamento(medicamento);

        System.out.print("Nova dosagem (enter para manter): ");
        String dosagem = scanner.nextLine();
        if (!dosagem.isBlank()) p.setDosagem(dosagem);

        System.out.print("Nova frequência (enter para manter): ");
        String frequencia = scanner.nextLine();
        if (!frequencia.isBlank()) p.setFrequencia(frequencia);

        System.out.print("Nova duração (enter para manter): ");
        String duracao = scanner.nextLine();
        if (!duracao.isBlank()) p.setDuracao(duracao);

        System.out.print("Novas orientações (enter para manter): ");
        String orientacoes = scanner.nextLine();
        if (!orientacoes.isBlank()) p.setOrientacoes(orientacoes);

        prescricaoService.atualizarPrescricao(p);
        System.out.println("Prescrição atualizada com sucesso!");
    }

    private static void excluirPrescricao(PrescricaoService prescricaoService) {
        System.out.print("ID da prescrição: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Prescricao p = prescricaoService.buscarPorId(id);
        if (p == null) {
            System.out.println("Prescrição não encontrada.");
            return;
        }

        prescricaoService.removerPrescricao(p);
        System.out.println("Prescrição excluída com sucesso!");
    }

    private static void consultarPrescricao(PrescricaoService prescricaoService) {
        System.out.print("ID da prescrição: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Prescricao p = prescricaoService.buscarPorId(id);
        System.out.println(p != null ? p : "Prescrição não encontrada.");
    }

    private static void listarPrescricoes(PrescricaoService prescricaoService) {
        List<Prescricao> prescricoes = prescricaoService.buscarTodos();
        if (prescricoes.isEmpty()) {
            System.out.println("Nenhuma prescrição cadastrada.");
        } else {
            prescricoes.forEach(System.out::println);
        }
    }

    // relatorios

    private static void consultarRelatorioAtendimentosPorDia(AtendimentoService atendimentoService) {
        System.out.print("Digite a data de início (yyyy-MM-dd): ");
        LocalDate dataInicio = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.print("Digite a data de fim (yyyy-MM-dd): ");
        LocalDate dataFim = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

        List<MediaAtendimentosPorDiaVo> relatorio =
                atendimentoService.retornaRelatorioAtendimentosPorDia(dataInicio, dataFim);

        System.out.println("Relatório de atendimentos por dia:");
        relatorio.forEach(System.out::println);
    }

    private static void consultarMedicamentosMaisPrescritosNaUltimaSemana(PrescricaoService prescricaoService) {
        List<MedicamentoMaisPrescritoVo> relatorio =
                prescricaoService.retornaMedicamentosMaisPrescritosNaUltimaSemana();

        System.out.println("Medicamentos mais prescritos na última semana:");
        if (relatorio.isEmpty()) {
            System.out.println("Nenhuma prescrição registrada na última semana.");
        } else {
            relatorio.forEach(System.out::println);
        }
    }

    // manipulacao de arquivos

    private static void configurarUpa(ConfiguracaoUpa config) {
        try {
            System.out.print("Novo nome da UPA: ");
            String nome = scanner.nextLine();
            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("Tempo maximo de espera (minutos): ");
            int minutos = Integer.parseInt(scanner.nextLine());

            config.setNomeUpa(nome);
            config.setCidade(cidade);
            config.setTempoMaxEsperaMinutos(minutos);
            config.salvar();

            System.out.println("Configuracoes salvas em upa-config.properties.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar configuracoes: " + e.getMessage());
        }
    }
//serializacao de arquivos
private static void fazerBackupPacientes(PacienteService pacienteService,
                                         BackupPaciente backupPaciente) {
    try {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        backupPaciente.salvarListaPacientes(pacientes);
        System.out.println("Backup de pacientes salvo em pacientes-backup.ser");
    } catch (IOException e) {
        System.out.println("Erro ao fazer backup: " + e.getMessage());
    }
}

    private static void restaurarPacientesDoBackup(PacienteService pacienteService,
                                                   BackupPaciente backupPaciente) {
        try {
            List<Paciente> pacientes = backupPaciente.carregarListaPacientes();
            if (pacientes.isEmpty()) {
                System.out.println("Nenhum paciente encontrado no backup.");
                return;
            }

            System.out.println("Pacientes carregados do backup:");
            pacientes.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao restaurar backup: " + e.getMessage());
        }
    }


}
