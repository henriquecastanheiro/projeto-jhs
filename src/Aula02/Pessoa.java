package Aula02;
import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private String profissao;

    public Pessoa(String nome, LocalDate dataNascimento, String profissao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
    }

    public int calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }

    public int calcularIdadeAnoBissexto() {
        int idade = calcularIdade();
        int anoBissexto = 0;

        for (int i = dataNascimento.getYear(); i <= LocalDate.now().getYear(); i++) {
            if (verificarAnoBissexto(i)) {
                anoBissexto++;
            }
        }

        return anoBissexto;
    }

    private boolean verificarAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Profissão: " + profissao);
        System.out.println("Idade: " + calcularIdade() + " anos");
        System.out.println("Idade em anos bissextos: " + calcularIdadeAnoBissexto() + " anos bissextos");
    }

    public static void main(String[] args) {
        LocalDate dataNascimento = LocalDate.of(2003, 2, 14);
        Pessoa pessoa = new Pessoa("Henrique Castanheiro", dataNascimento, "Desenvolvedor de Bugs");

        pessoa.exibirInformacoes();
    }
}
