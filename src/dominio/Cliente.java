package dominio;


import exception.CpfException;
import util.Validador;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String dataNascimento, String email) {
        this.nome = nome;
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        this.email = email;
    }

    public void exibirDetalhes() {
        System.out.printf("%s, CPF: %s, Data de Nascimento: %s, Email: %s \n",
                this.nome, this.cpf, this.dataNascimento, this.email);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!Validador.validarCpf(cpf)) {
            throw new CpfException("O CPF " + cpf + " é inválido!");
        }
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        if (!Validador.validarData(dataNascimento)) {
            throw new IllegalArgumentException("Data de nascimento inválida. Use o formato dd/MM/yyyy e não insira uma data futura.");
        }
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
