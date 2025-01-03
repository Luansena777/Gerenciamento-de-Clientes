package dominio;

import exception.ClienteException;
import exception.CpfException;
import util.OrdenaPorNome;

import java.util.HashMap;
import java.util.Map;

public class SistemaDeClientes {
    private Map<String, Cliente> clienteMap;

    public SistemaDeClientes() {
        this.clienteMap = new HashMap<>();
    }

    public void adicionarClientes(Cliente cliente) {
        if (clienteMap.containsKey(cliente.getCpf())) {
            throw new CpfException("Já existe um cliente com este CPF.");
        }

        clienteMap.put(cliente.getCpf(), cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    public void buscarCliente(String cpf) {
        Cliente cliente = clienteMap.get(cpf);
        if (cliente == null) {
            throw new ClienteException("Cliente não encontrado.");
        }

        cliente.exibirDetalhes();
    }

    public void removerCliente(String cpf) {
        if (clienteMap.remove(cpf) == null) {
            throw new IllegalArgumentException("Cliente com CPF " + cpf + " não encontrado.");
        }

        System.out.println("Cliente removido com sucesso!");
    }


    public void listarClientes() {
        if (clienteMap.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Lista de Clientes:");
        clienteMap.values().stream()
                .sorted(new OrdenaPorNome()) // Ordena antes de listar
                .forEach(Cliente::exibirDetalhes);
    }

    public void atualizarCliente(String cpf, String newDataNascimento, String newEmail) {
        if (clienteMap.containsKey(cpf)) {
            Cliente cliente = clienteMap.get(cpf);

            // Atualiza os dados do cliente
            cliente.setDataNascimento(newDataNascimento);
            cliente.setEmail(newEmail);

            // Coloca o cliente atualizado de volta no mapa
            clienteMap.put(cpf, cliente);

            System.out.println("Informações do cliente atualizadas com sucesso!");
            return;
        }

        // Se chegou aqui, significa que o cliente não foi encontrado.
        throw new ClienteException("Cliente não encontrado.");

    }
}

