# Projeto Final de POO - Sistema de Gestão de UPAs

Este projeto é um sistema de gestão para Unidades de Pronto Atendimento (UPA), desenvolvido como trabalho final da disciplina de Programação Orientada a Objetos (POO) em Java.

## Funcionalidades
- Cadastro, consulta e gerenciamento de pacientes, médicos, atendimentos, prescrições, triagens, convênios e especialidades.
- Backup e restauração de dados dos pacientes.
- Relatórios de estatísticas, como média de atendimentos por dia e medicamentos mais prescritos.
- Persistência de dados utilizando JPA (Java Persistence API).

## Estrutura do Projeto
```
src/main/java/org/example/
  Main.java                # Classe principal
  backup/                  # Backup de pacientes
  config/                  # Configuração da UPA
  controller/              # Controladores (MVC)
  dao/                     # Data Access Objects (DAO)
  model/                   # Modelos de domínio (Entidades)
  service/                 # Serviços de negócio
  util/                    # Utilitários (JPAUtil)
  view/                    # Camada de visualização (MVC)
  vo/                      # Objetos de valor para relatórios
```

## Conceitos de POO Utilizados
O projeto explora diversos conceitos fundamentais de Programação Orientada a Objetos em Java:

- **Classes e Objetos:**
  - Entidades como `Paciente`, `Medico`, `Atendimento`, etc.
- **Encapsulamento:**
  - Uso de modificadores de acesso (`private`, `public`) e métodos getters/setters.
- **Herança:**
  - Possível extensão de classes utilitárias ou entidades (verifique a hierarquia em `model/`).
- **Polimorfismo:**
  - Métodos sobrescritos e sobrecarregados, especialmente em DAOs e Services.
- **Abstração:**
  - Interfaces e classes abstratas para DAOs genéricos (`GenericDao`).
- **Associação, Agregação e Composição:**
  - Relacionamentos entre entidades (ex: um `Atendimento` possui um `Paciente` e um `Medico`).
- **Pacotes:**
  - Organização do código em pacotes lógicos.
- **MVC (Model-View-Controller):**
  - Separação das camadas de modelo, visão e controle.
- **Persistência com JPA:**
  - Uso de anotações JPA para mapeamento objeto-relacional.

## Como Executar
1. Certifique-se de ter o Java 11+ e Maven instalados.
2. Configure o banco de dados e as propriedades em `upa-config.properties`.
3. Execute o projeto via Maven:
   ```bash
   mvn clean install
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

## Créditos
Desenvolvido por Auanny para a disciplina de Programaçao Orientada a Objetos na UTFPR - Campus Pato Branco.

---

