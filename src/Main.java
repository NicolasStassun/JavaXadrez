import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;

public class Main {
    static Tabuleiro tabuleiro = new Tabuleiro();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        Jogador j1 = new Jogador("Jogador 1", "j1");
        Jogador j2 = new Jogador("Jogador 2", "j2");


        j1.setCor("Branco", tabuleiro);
        j2.setCor("Preto",tabuleiro);

        do {

            // Jogador 1

            geraTabuleiro();

            System.out.println(j1.mostraPecas(j1.getPecas()));
            Peca pecaJ1;
            ArrayList <Posicao> posicoesJ1;
            do {
                int escolhaPecaj1 = 0;
                do {
                    System.out.println("Escolha sua peça");
                    escolhaPecaj1 = sc.nextInt();
                }while ((j1.getPecas().size()-1) < escolhaPecaj1);
                pecaJ1 = j1.getPecas().get(escolhaPecaj1);
                if (pecaJ1 instanceof Peao){
                    pecaJ1 = verificaTrocaPeao(tabuleiro.getPosicoes().indexOf(pecaJ1.getPosicao()),pecaJ1.getPosicao(),pecaJ1, j1);
                }
                posicoesJ1 = pecaJ1.possiveisMovimentos(tabuleiro);
                if (posicoesJ1.isEmpty()){
                    System.out.println("Peça não pussui movimentos possíveis");
                }
            }while(posicoesJ1.isEmpty());
            int escolhaPosicaoj1;
            do {
                System.out.println(posicoesJ1);
                System.out.println("Escolha a posição");
                escolhaPosicaoj1 = sc.nextInt();
            }while((posicoesJ1.size()-1) < escolhaPosicaoj1);
            Posicao posicaoj1 = posicoesJ1.get(escolhaPosicaoj1);
            j1.moverPeca(pecaJ1,posicaoj1,tabuleiro,j2);



            // Jogador 2

            geraTabuleiro();
            System.out.println(j2.mostraPecas(j2.getPecas()));
            Peca pecaJ2;
            ArrayList <Posicao> posicoesJ2;
            do {
                int escolhaPecaj2 = 0;
                do {
                    System.out.println("Escolha sua peça");
                    escolhaPecaj2 = sc.nextInt();
                }while((j2.getPecas().size()-1) < escolhaPecaj2);
                pecaJ2 = j2.getPecas().get(escolhaPecaj2);
                if (pecaJ2 instanceof Peao){
                    pecaJ2 = verificaTrocaPeao(tabuleiro.getPosicoes().indexOf(pecaJ2.getPosicao()),pecaJ2.getPosicao(),pecaJ2, j2);
                }
                posicoesJ2 = pecaJ2.possiveisMovimentos(tabuleiro);
                if (posicoesJ2.isEmpty()){
                    System.out.println("Peça não pussui movimentos possíveis");
                }
            }while(posicoesJ2.isEmpty());
            int escolhaPosicaoJ2;
            do {
                System.out.println(posicoesJ2);
                System.out.println("Escolha a posição");
                escolhaPosicaoJ2 = sc.nextInt();
            }while ((posicoesJ2.size()-1) < escolhaPosicaoJ2);

            Posicao posicaoJ2 = posicoesJ2.get(escolhaPosicaoJ2);
            j1.moverPeca(pecaJ2,posicaoJ2,tabuleiro,j1);



        }while(!validarVitoria(j1) && !validarVitoria(j2));


    }

    private static void geraTabuleiro(){
        ArrayList<Posicao> posicaoNoTabuleiro = tabuleiro.getPosicoes();
        Color c = Color.black;
        for (Posicao posicao : tabuleiro.getPosicoes()) {
            if (posicao.getPeca() != null) {
                System.out.print("["+posicao.getPeca().icone + "]");
            }
            else{
                if (posicaoNoTabuleiro.indexOf(posicao)>=0 && posicaoNoTabuleiro.indexOf(posicao)<=7) {
                    if (posicaoNoTabuleiro.indexOf(posicao) % 2 == 0) {
                        System.out.print("[❌]");
                    } else {
                        System.out.print("[\u3164]");
                    }
                }
                else if (posicaoNoTabuleiro.indexOf(posicao)>7 && posicaoNoTabuleiro.indexOf(posicao)<=15) {
                    if (posicaoNoTabuleiro.indexOf(posicao) % 2 != 0) {
                        System.out.print("[❌]");
                    } else {
                        System.out.print("[\u3164]");
                    }
                }
                else if (posicaoNoTabuleiro.indexOf(posicao)>15 && posicaoNoTabuleiro.indexOf(posicao)<=23) {
                    if (posicaoNoTabuleiro.indexOf(posicao) % 2 == 0) {
                        System.out.print("[❌]");
                    } else {
                        System.out.print("[\u3164]");
                    }
                }
                else if (posicaoNoTabuleiro.indexOf(posicao)>23 && posicaoNoTabuleiro.indexOf(posicao)<=31) {
                    if (posicaoNoTabuleiro.indexOf(posicao) % 2 != 0) {
                        System.out.print("[❌]");
                    } else {
                        System.out.print("[\u3164]");
                    }
                }
                else if (posicaoNoTabuleiro.indexOf(posicao)>31 && posicaoNoTabuleiro.indexOf(posicao)<=39) {
                    if (posicaoNoTabuleiro.indexOf(posicao) % 2 == 0) {
                        System.out.print("[❌]");
                    } else {
                        System.out.print("[\u3164]");
                    }
                }
                else if (posicaoNoTabuleiro.indexOf(posicao)>39 && posicaoNoTabuleiro.indexOf(posicao)<=47) {
                    if (posicaoNoTabuleiro.indexOf(posicao) % 2 != 0) {
                        System.out.print("[❌]");
                    } else {
                        System.out.print("[\u3164]");
                    }
                }
                else if (posicaoNoTabuleiro.indexOf(posicao)>47 && posicaoNoTabuleiro.indexOf(posicao)<=55) {
                    if (posicaoNoTabuleiro.indexOf(posicao) % 2 == 0) {
                        System.out.print("[❌]");
                    } else {
                        System.out.print("[\u3164]");
                    }
                }
                else if (posicaoNoTabuleiro.indexOf(posicao)>55 && posicaoNoTabuleiro.indexOf(posicao)<=63) {
                    if (posicaoNoTabuleiro.indexOf(posicao) % 2 != 0) {
                        System.out.print("[❌]");
                    } else {
                        System.out.print("[\u3164]");
                    }
                }
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
        System.exit(0);
        return true;
    }
    public static Peca verificaTrocaPeao(int posicaoNoTabuleiro, Posicao posicaoAtual, Peca peao, Jogador jogador) {
        System.out.println("a");
        Peca peca = peao;
        if (peao.getCor().equals("Preto")) {
            if (posicaoNoTabuleiro > 55) {
                int opcaoDeTrocaDoPeaoPreto = 0;
                do {
                    System.out.println("""
                            Informe a peça pela qual você deseja trocar seu peão
                            1 - Rainha
                            2 - Torre
                            3 - Bispo
                            4 - Cavalo
                            """);
                    opcaoDeTrocaDoPeaoPreto = sc.nextInt();
                } while (opcaoDeTrocaDoPeaoPreto < 0 || opcaoDeTrocaDoPeaoPreto >= 4);
                switch (opcaoDeTrocaDoPeaoPreto) {
                    case 1:
                        peca = new Rainha("Preto", posicaoAtual);
                        jogador.getPecas().add(peca);
                        break;
                    case 2:
                        peca = new Torre("Preto", posicaoAtual);
                        jogador.getPecas().add(peca);
                        break;
                    case 3:
                        peca = new Bispo("Preto", posicaoAtual);
                        jogador.getPecas().add(peca);
                        break;
                    case 4:
                        peca = new Cavalo("Preto", posicaoAtual);
                        jogador.getPecas().add(peca);
                        break;
                }
            }
        }
        else {
                if (posicaoNoTabuleiro < 8) {
                    int opcaoDeTrocaDoPeaoBranco = 0;
                    do {
                        System.out.println("""
                                Informe a peça pela qual você deseja trocar seu peão
                                1 - Rainha
                                2 - Torre
                                3 - Bispo
                                4 - Cavalo
                                """);
                        opcaoDeTrocaDoPeaoBranco = sc.nextInt();
                        switch (opcaoDeTrocaDoPeaoBranco) {
                            case 1:
                                peca = new Rainha("Branco", posicaoAtual);
                                jogador.getPecas().add(peca);
                                break;
                            case 2:
                                peca = new Torre("Branco", posicaoAtual);
                                jogador.getPecas().add(peca);
                                break;
                            case 3:
                                peca = new Bispo("Branco", posicaoAtual);
                                jogador.getPecas().add(peca);
                                break;
                            case 4:
                                peca = new Cavalo("Branco", posicaoAtual);
                                jogador.getPecas().add(peca);
                                break;
                        }
                    } while (opcaoDeTrocaDoPeaoBranco < 0 || opcaoDeTrocaDoPeaoBranco >= 4);
                }

            }
        return peca;
    }
}