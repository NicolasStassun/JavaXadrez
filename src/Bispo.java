import java.util.ArrayList;

public class Bispo extends Peca {

    public Bispo(String cor){
        super(cor);
        this.icone = gerarIcone();
    }

    public char gerarIcone() {
        if (this.getCor().equals("Branco")) {
            return '♗';
        }
        return '♝';
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();

        int posicaoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);

        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (int i = (validaExtremidade(posicaoTabuleiro) ? 64 : posicaoTabuleiro + 7); i < tabuleiro.getPosicoes().size(); i += 7) {
            Posicao posicao = tabuleiro.getPosicoes().get(i);

            this.verificaPeca(posicao, possiveisMovimentos);

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro+1) ? 64 : posicaoTabuleiro - 7); i >= tabuleiro.getPosicoes().size(); i -= 7) {
            Posicao posicao = tabuleiro.getPosicoes().get(i);

            this.verificaPeca(posicao, possiveisMovimentos);

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i+1)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro+1)? 64 : posicaoTabuleiro + 9); i < tabuleiro.getPosicoes().size(); i += 9) {
            Posicao posicao = tabuleiro.getPosicoes().get(i);

            this.verificaPeca(posicao, possiveisMovimentos);

            if (tabuleiro.getPosicoes().get(i).getPeca() == null) {
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            }

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i+1)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro) ? 64 : posicaoTabuleiro - 9); i >= tabuleiro.getPosicoes().size(); i -= 9) {
            Posicao posicao = tabuleiro.getPosicoes().get(i);

            this.verificaPeca(posicao, possiveisMovimentos);

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }

        }

        return possiveisMovimentos;
    }

    @Override
    public String getCor() {
        return super.getCor();
    }
}