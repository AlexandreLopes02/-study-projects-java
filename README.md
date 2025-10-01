# 🚀 13 Exercícios/Projetos em Java

Este repositório contém uma coleção de exercícios e mini-projetos em **Java**, organizados por níveis de dificuldade.  
O objetivo é praticar **lógica de programação, POO, coleções, arquivos e persistência**.

---

## 📂 Estrutura do Projeto
- `level1` → Exercícios básicos de lógica.
- `level2` → Estruturas de dados simples (listas, strings).
- `level3` → POO inicial (classes e objetos).
- `level4` → CRUD simples com POO.
- `level5` → Persistência em arquivos e coleções mais avançadas.
- `level6` → CRUDs completos e sistemas simulados.

---

## 📌 Lista de Exercícios

### *Nível 1*
1. **Tabuada Dinâmica**
   - Ler um número do usuário e mostrar a tabuada de 1 a 10.
   - *Conceitos: laço for, entrada de dados (Scanner).*

2. **Números Primos até N**
   - O usuário digita um número N e o programa mostra todos os primos até N.
   - *Conceitos: laços aninhados, condição.*

3. **Calculadora Simples**
   - Usuário digita dois números e a operação (+, -, *, /).
   - Programa mostra o resultado.
   - *Conceitos: switch case, funções.*

---

### *Nível 2*
4. **Controle de Notas (Média e Situação)**
   - Ler várias notas de alunos (usar ArrayList).
   - Mostrar média da turma e alunos aprovados/reprovados.
   - *Conceitos: listas, loops, funções.*

5. **Contagem de Palavras**
   - Usuário digita uma frase.
   - Programa mostra quantas palavras e caracteres existem.
   - *Conceitos: manipulação de strings.*

---

### *Nível 3*
6. **Classe Conta Bancária**
   - Classe `Conta` com atributos titular e saldo.
   - Métodos: depositar(), sacar(), exibirSaldo().
   - Criar 2 contas e simular operações.
   - *Conceitos: encapsulamento, métodos.*

7. **Cadastro de Alunos**
   - Classe `Aluno` (nome, idade, nota).
   - Permitir adicionar vários alunos em uma lista.
   - Mostrar relatório final com aprovados (nota ≥ 7).
   - *Conceitos: POO + coleções.*

---

### *Nível 4*
8. **Sistema de Estoque**
   - Classe `Produto` (nome, quantidade, preço).
   - Usuário pode adicionar, remover e listar produtos.
   - Mostrar valor total do estoque.
   - *Conceitos: POO, listas, lógica de negócio.*

9. **Agenda de Contatos**
   - Classe `Contato` (nome, telefone, e-mail).
   - Usuário pode cadastrar, buscar e remover contatos.
   - *Conceitos: POO + CRUD básico.*

---

### *Nível 5*
10. **Biblioteca Virtual (mini CRUD com persistência em arquivo)**
   - Classe `Livro` (título, autor, ano).
   - Usuário pode: adicionar, listar, remover livros.
   - Dados salvos em `.txt` e carregados no início do programa.
   - *Conceitos: POO, listas, persistência simples (arquivos).*

11. **Sistema de Gerenciamento de Tarefas (To-Do List com Prioridade)**
   - Classe `Tarefa`: título, descrição, prioridade (1 a 5), status (pendente, concluída).
   - Classe `GerenciadorTarefas`: métodos para adicionar, listar (ordenado por prioridade), marcar concluída e remover.
   - *Conceitos: coleções, ordenação, enums, encapsulamento.*
   - Extra: salvar em arquivo `.txt`.

---

### *Nível 6*
12. **Agenda de Contatos Avançada (CRUD completo com persistência)**
   - Classe `Contato`: nome, telefone, email.
   - Classe `Agenda`: adicionar, listar, buscar (nome ou telefone), atualizar e remover.
   - Persistência em arquivo.
   - *Conceitos: CRUD completo, POO, persistência, boas práticas.*
   - Extra: ordenar contatos em ordem alfabética.

13. **Sistema de Vendas (Mini-estoque com Carrinho de Compras)**
   - Classe `Produto`: id, nome, preço, quantidade em estoque.
   - Classe `Venda`: lista de produtos vendidos, valor total.
   - Classe `Loja`: cadastrar produto, listar estoque, vender (removendo do estoque), exibir histórico.
   - *Conceitos: listas, relacionamento entre classes, CRUD parcial, encapsulamento.*
   - Extra: salvar estoque e vendas em arquivos separados.

---

👨‍💻 Desenvolvido por **[Alexandre Lopes](https://github.com/AlexandreLopes02)**  
