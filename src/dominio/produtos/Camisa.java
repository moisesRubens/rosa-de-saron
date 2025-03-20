package dominio.produtos;

public class Camisa extends Roupa {
    private boolean gola;
    private boolean manga;
    private char tamanho;

    public Camisa() {

    }

    public Camisa(String nome, String cor, char tamanho, double valor, boolean gola, boolean manga) {
        super(nome, cor, valor);
        this.gola = gola;
        this.manga = manga;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Camisa{" +
                "gola=" + gola +
                ", manga=" + manga +
                ", tamanho=" + tamanho +
                ", nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", valor=" + valor +
                '}';
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isGola() {
        return gola;
    }

    public void setGola(boolean gola) {
        this.gola = gola;
    }

    public boolean isManga() {
        return manga;
    }

    public void setManga(boolean manga) {
        this.manga = manga;
    }
}
