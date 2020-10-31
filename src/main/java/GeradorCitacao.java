import java.util.Scanner;

public class GeradorCitacao {
    public static void main(String[] args) {
        String[] nomes;
        int indexArray = 0;
        int contador = 0;
        String substring;

        String nome = welcomeMessage();

        int qtdEspacos = nome.length() - nome.replace(" ", "").length();
        nomes = new String[qtdEspacos + 1];

        extraiPalavrasParaArray(nome, nomes, indexArray);

        imprimeCitacao(nomes);

    }

    private static void imprimeCitacao(String[] nomes) {
        String primeiroNome = nomes[0];
        String ultimoNome = nomes[nomes.length - 1];
        System.out.print("SUA CITAÇÃO É: " + ultimoNome.toUpperCase() +
                ", ");
        for (int i = 0; i < (nomes.length) - 1; i++) {
            System.out.print(nomes[i].substring(0, 1).toUpperCase() + ". ");
        }
        //System.out.print(primeiroNome.substring(0, 1).toUpperCase());
    }

    private static String welcomeMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("###############################################################");
        System.out.println("###############################################################");
        System.out.println("#####################GERADOR DE CITAÇÃO########################");
        System.out.println("###############################################################");
        System.out.println("###############################################################");
        System.out.println("");
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        return nome;
    }

    private static void extraiPalavrasParaArray(String nome, String[] nomes, int indexArray) {
        int contador;
        String substring;
        while ((contador = nome.indexOf(" ")) != -1) {
            substring = nome.substring(0, contador);
            nomes[indexArray] = substring;
            nome = nome.substring(contador + 1, nome.length());
            indexArray++;
        }
        nomes[indexArray] = nome.substring(0, nome.length());
    }

    private static void reverseArray(String[] nomes) {
        for (int i = 0; i < nomes.length / 2; i++) {
            String temp = nomes[i];
            nomes[i] = nomes[nomes.length - 1 - i];
            nomes[nomes.length - 1 - i] = temp;
        }
    }
}
