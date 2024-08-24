package Aula02.InstituicaoFinanceira;

import java.util.ArrayList;
import java.util.List;

class InstituicaoFinanceira {
    private String nome;
    private List<Cliente> clientes;
    private List<Conta> contas;

    public InstituicaoFinanceira(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public Cliente cadastrarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cliente " + nome + " cadastrado com sucesso.");
        return cliente;
    }

    public Conta abrirConta(Cliente cliente) {
        Conta conta = new Conta(cliente);
        contas.add(conta);
        System.out.println("Conta " + conta.getNumero() + " aberta com sucesso para o cliente " + cliente.getNome() + ".");
        return conta;
    }

    public void realizarDeposito(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public void realizarSaque(Conta conta, double valor) {
        conta.sacar(valor);
    }

    public void realizarTransferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        contaOrigem.transferir(contaDestino, valor);
    }

    public void exibirInformacoesConta(Conta conta) {
        System.out.println("Número da Conta: " + conta.getNumero());
        System.out.println("Cliente: " + conta.getCliente().getNome());
        System.out.println("Saldo: R$ " + conta.getSaldo());
    }

    public static void main(String[] args) {
        InstituicaoFinanceira banco = new InstituicaoFinanceira("Banco XYZ");

        Cliente cliente1 = banco.cadastrarCliente("Henrique Castanheiro", "123.456.789-00");
        Cliente cliente2 = banco.cadastrarCliente("Maria Silva", "987.654.321-00");

        Conta conta1 = banco.abrirConta(cliente1);
        Conta conta2 = banco.abrirConta(cliente2);

        banco.realizarDeposito(conta1, 1000);
        banco.realizarSaque(conta1, 200);
        banco.realizarTransferencia(conta1, conta2, 300);

        banco.exibirInformacoesConta(conta1);
        banco.exibirInformacoesConta(conta2);
    }
}
