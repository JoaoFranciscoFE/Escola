# Sistema de Gerenciamento Escolar

Este é um sistema de gerenciamento de alunos, professores, disciplinas e matrículas desenvolvido em Java. O sistema permite realizar o cadastro de alunos e professores, matricular alunos em disciplinas, avaliar disciplinas e consultar informações relacionadas.

## Funcionalidades

- **Cadastro de Alunos**: Permite o cadastro de novos alunos com informações como nome e CPF.
- **Cadastro de Professores**: Permite o cadastro de professores com informações como nome, CPF e departamento.
- **Cadastro de Disciplinas**: Permite o cadastro de disciplinas obrigatórias e eletivas.
- **Matrícula de Alunos**: Permite matricular alunos em disciplinas, com alteração de status de matrícula.
- **Avaliação de Disciplinas**: Professores podem atribuir notas às disciplinas.
- **Consulta de Notas**: Alunos podem consultar suas notas em determinadas disciplinas.
- **Remoção de Alunos e Disciplinas**: Permite a remoção de alunos e disciplinas do sistema.

## Arquitetura

O sistema é estruturado em classes que representam os principais elementos do sistema:

- **Pessoa**: Classe abstrata que define os atributos comuns a `Aluno` e `Professor`.
- **Aluno**: Extende `Pessoa` e implementa a interface `IMatriculavel` para gerenciar matrículas.
- **Professor**: Extende `Pessoa` e implementa a interface `ICadastrar` para permitir o cadastro e remoção de dados de professores.
- **Disciplina**: Classe abstrata com suas subclasses `DisciplinaObrigatoria` e `DisciplinaEletiva`, que representam tipos específicos de disciplinas.
- **Nota**: Classe que representa as notas de alunos em disciplinas, implementando a interface `IAvaliar` para calcular a nota final.

## Interfaces

- **IAvaliar**: Interface usada para calcular a nota final de uma disciplina.
- **ICadastrar**: Interface usada para cadastro e remoção de alunos e professores.
- **IConsultar**: Interface para consultar informações gerais.
- **IMatriculavel**: Interface usada para gerenciar matrículas de alunos.

## Como Usar

1. Compile o código com `javac`.
2. Execute o sistema com `java br.com.escola.estrelaguia.Main.Main`.
3. Utilize o menu interativo para adicionar/remover alunos, professores, disciplinas e realizar matrículas e avaliações.

## Requisitos

- JDK 8 ou superior.
- IDE de sua escolha (exemplo: IntelliJ IDEA, Eclipse, NetBeans).
- Sistema operacional: Windows, macOS ou Linux.

## Estrutura de Pacotes

- **br.com.escola.estrelaguia.Model**: Contém as classes que representam os elementos do sistema como Aluno, Professor, Disciplina, etc.
- **br.com.escola.estrelaguia.Enums**: Contém os enums para os tipos de pessoa, status de matrícula e tipo de nota.
- **br.com.escola.estrelaguia.Main**: Contém a classe principal que executa o sistema.
- **br.com.escola.estrelaguia.Interfaces**: Contém as interfaces utilizadas para definir funcionalidades como matrícula, cadastro e avaliação.

## Licença

Este projeto está sob a licença do Professor Erlon
