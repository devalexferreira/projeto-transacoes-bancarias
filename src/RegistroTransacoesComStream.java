import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RegistroTransacoesComStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        int quantidadeTransacoes = scanner.nextInt();
        List<Transacao> transacoes = new ArrayList<>();

        for (int i = 1; i <= quantidadeTransacoes; i++) {
            char tipoTransacao = scanner.next().charAt(0);


            double valorTransacao = scanner.nextDouble();

            Transacao transacao = new Transacao(tipoTransacao, valorTransacao);
            transacoes.add(transacao);
            // Aqui é atualizado o saldo da conta com base no tipo de transação
            if (transacao.getTipo() == 'D' || transacao.getTipo() == 'd') {
                saldo += valorTransacao;
            } else if (transacao.getTipo() == 'S' || transacao.getTipo() == 's') {
                saldo -= valorTransacao;
            }
        }

        // Exibe o saldo final e a lista de transações ao final do processo usando Stream API
        System.out.println("\nSaldo : " + saldo);
        System.out.println("\nTransacoes:");
        // TODO: Crie um fluxo (stream) a partir da lista de transações:
        List<String> transacaoList = transacoes.stream().map(
               s -> s.getTipo() + " de " +s.getValor()
        ).toList();

        transacaoList.forEach(System.out::println);

        // TODO: Mapeie cada transação para uma string formatada:

        // TODO: Colete os elementos do fluxo em uma lista:

        // TODO: Para cada elemento da lista, imprime no console:


        scanner.close();
    }
}

class Transacao {
    private char tipo;
    private double valor;

    public Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}