# gerenciamento-biblioteca
Prova Prática VA2 - Biblioteca Spring Boot (Model/Persistence)
Projeto: va2_MariaEduarda

🎯 Objetivo
Implementar as camadas de Domínio (Entidades) e Persistência (Repositories) de um sistema de biblioteca, aplicando conceitos de POO, Mapeamento JPA e Validações de Dados.

🛠️ Tecnologias e Dependências
Spring Boot

Spring Data JPA (Persistência)

MySQL Driver

Spring Validation (Validações)

Lombok (Encapsulamento)

✅ Checklist de Entrega (Concluído)
Todas as tarefas obrigatórias da VA2 foram implementadas nas respectivas classes:

Modelagem Básica e Encapsulamento: Completo.

Mapeamento de Associações (1:N e N:1):

Autor 1:N Livro

Livro N:1 Autor

Livro 1:N Empréstimo

Empréstimo N:1 Livro

Camada de Repositório: Interfaces criadas.

Validações Implementadas:

Autor: @NotNull e @Size(min=3) no campo nome.

Livro: @NotNull em titulo e @Column(unique=true) em isbn.

Empréstimo: @NotNull em dataEmprestimo e @FutureOrPresent em dataPrevistaDevolucao.
