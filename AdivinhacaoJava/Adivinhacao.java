import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {

    private static final int MAXTENTATIVAS = 5;
    private static final int MINIMO = 0;
    private static final int MAXIMO = 100;

    public static void main(String[] args) {
        try (Scanner leitor = new Scanner(System.in)) {
            int numeroGerado = new Random().nextInt(MAXIMO + 1);
            int tentativas = 0;

            while (tentativas < MAXTENTATIVAS) {
                System.out.print("Digite um número entre " + MINIMO + " e " + MAXIMO + ": ");
                int numeroDigitado = 0;
                try {
                    numeroDigitado = leitor.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido. Tente novamente! :3 ");
                    leitor.nextLine();
                    continue;
                }
                if (numeroDigitado < MINIMO || numeroDigitado > MAXIMO) {
                    System.out.println("Número fora do intervalo permitido. Tente novamente.");
                    continue;
                }
                tentativas++;
                if (numeroDigitado == numeroGerado) {
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("Parabéns, você acertou o número em " + tentativas + " tentativas! ^-^ ");
                    System.out.println("--------------------------------------------------------------------");
                    return;
                } else if (numeroDigitado < numeroGerado) {
                    System.out.println("O número digitado é menor que o número gerado. :C ");
                } else {
                    System.out.println("O número digitado é maior que o número gerado. :C ");
                }
            }

            System.out.println("Você não conseguiu adivinhar o número em " + MAXTENTATIVAS + " tentativas. O número era " + numeroGerado);
        }
    }
}