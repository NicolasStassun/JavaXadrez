import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Tabuleiro tabuleiro = new Tabuleiro();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Jogador j1 = new Jogador("jorge", "Senh@123");
        Jogador j2 = new Jogador("Wilson", "wilson");

        j1.setCor("Branco", tabuleiro);
        j2.setCor("Preto",tabuleiro);

        do {

            // Jogador 1

            geraTabuleiro();

            System.out.println(j1.mostraPecas(j1.getPecas()));
            Peca pecaJ1 = null;
            int escolhaPecaj1 = sc.nextInt();
            pecaJ1 = j1.getPecas().get(escolhaPecaj1);

            ArrayList <Posicao> posicoesJ1 = pecaJ1.possiveisMovimentos(tabuleiro);
            for (Posicao posicao:posicoesJ1) {
                System.out.println(posicoesJ1.indexOf(posicao));

            }
            int escolhaPosicaoj1 = sc.nextInt();
            Posicao posicaoj1 = posicoesJ1.get(escolhaPosicaoj1);

            j1.moverPeca(pecaJ1,posicaoj1,tabuleiro,j2);
            System.out.println(validarVitoria(j2));

            // Jogador 2

            geraTabuleiro();

            System.out.println(j2.mostraPecas(j2.getPecas()));
            Peca pecaJ2 = null;

            int escolhaPecaj2 = sc.nextInt();
            pecaJ2 = j2.getPecas().get(escolhaPecaj2);

            ArrayList <Posicao> posicoesJ2 = pecaJ2.possiveisMovimentos(tabuleiro);
            for (Posicao posicao:posicoesJ2) {
                System.out.println(posicoesJ2.indexOf(posicao));

            }
            int escolhaPosicaoJ2 = sc.nextInt();
            Posicao posicaoJ2 = posicoesJ2.get(escolhaPosicaoJ2);

            j1.moverPeca(pecaJ2,posicaoJ2,tabuleiro,j1);
            System.out.println(validarVitoria(j1));


        }while(!validarVitoria(j1) && !validarVitoria(j2));


    }

    private static void geraTabuleiro(){
        ArrayList<Posicao> posicaoNoTabuleiro = tabuleiro.getPosicoes();
        for (Posicao posicao : tabuleiro.getPosicoes()) {
            if (posicao.getPeca() != null) {
                System.out.print("["+posicao.getPeca().icone + "]");
            }
            else{
                System.out.print("[ ]");
            }
            if ((tabuleiro.getPosicoes().indexOf(posicao)+1)%8 == 0){
                System.out.print("\n");
            }

        }
    }

    private static boolean validarVitoria(Jogador adversario){
        for (Peca peca: adversario.getPecas()) {
            if (peca instanceof Rei){
                return false;
            }
        }
        return true;
    }
}