import java.util.ArrayList;

public class Jogador {
    private ArrayList<Peca> pecas ;
    private String nome;
    private String cor;
    private double pontos;
    private String senha;

    public Jogador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.pecas = new ArrayList<>();
    }

    public boolean moverPeca(Peca peca, Posicao posicao, Tabuleiro tabuleiro, Jogador adversario) {

        Peca pecaAdversaria = posicao.getPeca();
        boolean valida = peca.mover(tabuleiro, posicao);
        if (pecaAdversaria != null && valida) {
            adversario.pecas.remove(pecaAdversaria);
        }

        if (peca instanceof Peao){
            ((Peao) peca).setPrimMov(false);
        }
        if (peca instanceof Rei){
            ((Rei) peca).setPrimMov(false);
        }
        if (peca instanceof Torre){
            ((Torre) peca).setPrimMov(false);
        }

        return valida;
    }


    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public ArrayList<String> mostraPecas(ArrayList<Peca> pecas){

        ArrayList<String> display = new ArrayList<>();

        for (Peca peca:
             pecas) {

            if (peca instanceof Bispo ){
                if (peca.getCor().equals("Branco")){
                    display.add(display.size()+"♗");
                }
                else {
                    display.add(display.size()+"♝");
                }
            }

            else if (peca instanceof Cavalo ){
                if (peca.getCor().equals("Branco")){
                    display.add(display.size()+"♘");
                }
                else {
                    display.add(display.size()+"♞");
                }
            }

            else if (peca instanceof Peao ){
                if (peca.getCor().equals("Branco")){
                    display.add(display.size()+"♙");
                }
                else {
                    display.add(display.size()+"♟");
                }
            }

            else if (peca instanceof Rainha ){
                if (peca.getCor().equals("Branco")){
                    display.add(display.size()+"♕");
                }
                else {
                    display.add(display.size()+"♛");
                }
            }

            else if(peca instanceof Rei ){
                if (peca.getCor().equals("Branco")){
                    display.add(display.size()+"♔");
                }
                else {
                    display.add(display.size()+"♚");
                }
            }

            else if (peca instanceof Torre ){
                if (peca.getCor().equals("Branco")){
                    display.add(display.size()+"♖");
                }
                else {
                    display.add(display.size()+"♜");
                }
            }

        }

        return display;
    }

    public boolean proporEmpate(Jogador jogador) {
        return true;
    }

    public void desistir() {

    }

    public void setCor(String cor, Tabuleiro tabuleiro) {
        this.cor = cor;
        for (Posicao posicao : tabuleiro.getPosicoes()) {
            if (posicao.getPeca() != null && posicao.getPeca().getCor().equals(this.cor)) {
                this.pecas.add(posicao.getPeca());
            }
        }
    }
}