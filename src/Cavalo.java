import java.util.ArrayList;

public class Cavalo extends Peca {

    public Cavalo(String cor, Posicao posicao) {
        super(cor, posicao);
        this.icone = gerarIcone();
    }

    public char gerarIcone() {
        if (this.getCor().equals("Branco")) {
            return '♘';
        }
        return '♞';
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);

        int[] movimentos = {-17, -15, -10, -6, 6, 10, 15, 17};

        for (int movimento : movimentos) {
            int destino = posicaoNoTabuleiro + movimento;
            if (destino >= 0 && destino < 64) { // Verifica se o destino está dentro dos limites do tabuleiro
                Posicao posicao = tabuleiro.getPosicoes().get(destino);
                // Verifica se a posição não possui uma peça da mesma cor ou não possui peça alguma
                if (posicao.getPeca() == null || !posicao.getPeca().getCor().equals(this.getCor())) {
                    possiveisMovimentos.add(posicao);
                }
            }
        }

        return possiveisMovimentos;
    }
}