# Gerenciamento de Clientes

Este projeto é um sistema simples para gerenciamento de clientes. Ele permite adicionar, buscar, atualizar, remover e listar clientes com informações como nome, CPF, data de nascimento e e-mail.

## Funcionalidades

- **Adicionar Cliente**: Permite cadastrar um novo cliente com CPF, nome, data de nascimento e e-mail.
- **Buscar Cliente**: Permite buscar um cliente pelo CPF e exibir seus detalhes.
- **Atualizar Cliente**: Permite atualizar a data de nascimento e o e-mail de um cliente existente.
- **Remover Cliente**: Permite remover um cliente com base no CPF.
- **Listar Clientes**: Exibe todos os clientes cadastrados, ordenados alfabeticamente pelo nome.

## Classes Adicionais
- **OrdenaPorNome**: Responsável por ordenar a lista de clientes de forma alfabética com base no nome.
- **Validador**: 
  - **validarCpf(String cpf)**: Valida se o CPF fornecido tem o formato correto e é um número válido.
  - **ValidarDataNascimento(String dataNascimento)**: Verifica se a data de nascimento fornecida está no formato correto (dd/MM/yyyy).

Esses métodos são utilizados para garantir a integridade dos dados antes de realizar operações como adicionar ou atualizar clientes.

## Tecnologias Utilizadas

- Java
- Collections
- HashMap


### Pré-requisitos

- JDK 8 ou superior instalado.
