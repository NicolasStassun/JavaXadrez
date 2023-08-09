import java.util.ArrayList;
import java.util.Scanner;

public class Peao extends Peca {


    private boolean primMov = true;

    public Peao(String cor, Posicao posicao){
        super(cor, posicao);
        this.icone = gerarIcone();
    }

    public char gerarIcone() {
        if (this.getCor().equals("Branco")) {
            return '♙';
        }
        return '♟';
    }



    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);

        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicoes();


            if (this.getCor().equals("Preto")) {
                if(posicaoNoTabuleiro <=55) {

                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 8));

                        if (this.primMov) {
                            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));

                            }
                        }
                    }

                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca() != null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                            possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));

                        }
                    }
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca() != null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro)) {
                            possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));

                        }
                    }
                }
            } else {
                if (posicaoNoTabuleiro >=8) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 8));


                        if (this.primMov) {
                            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null)
                                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));

                        }
                    }
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca() != null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro)) {
                            possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 9));

                        }
                    }
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca() != null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                            possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 7));

                        }
                    }
                }
            }

        return possiveisMovimentos;
    }

    public boolean isPrimMov() {
        return primMov;
    }

    public void setPrimMov(boolean primMov) {
        this.primMov = primMov;
    }
}