package test;

import gerenciamentodeclientes.dominio.Cliente;
import gerenciamentodeclientes.dominio.SistemaDeClientes;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaDeClientes sistemaDeClientes = new SistemaDeClientes();
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Buscar Cliente");
            System.out.println("5. Remover Cliente");
            System.out.println("0. Sair");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = scanner.nextLine().trim();

                    System.out.print("Email: ");
                    String email = scanner.nextLine().trim();

                    Cliente cliente = new Cliente(nome, cpf, dataNascimento, email);
                    sistemaDeClientes.adicionarClientes(cliente);
                    break;
                case 2:
                    sistemaDeClientes.listarClientes();
                    break;
                case 3:
                    System.out.println("CPF: ");
                    cpf = scanner.nextLine();
                    System.out.print("Nova Data de Nascimento: ");
                    String newDataNascimento = scanner.nextLine();
                    System.out.print("Novo Email: ");
                    String newEmail = scanner.nextLine();
                    sistemaDeClientes.atualizarCliente(cpf, newDataNascimento, newEmail);
                    break;
                case 4:
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    sistemaDeClientes.buscarCliente(cpf);
                    break;
                case 5:
                    System.out.println("CPF: ");
                    String cpfRemover = scanner.nextLine();
                    sistemaDeClientes.removerCliente(cpfRemover);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
