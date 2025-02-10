package dominio;

public class Camisa extends Roupa {
    private boolean gola;
    private boolean manga;

    public Camisa(String modelo, String cor, int tamanho, double valor, boolean gola, boolean manga) {
        super(modelo, cor, tamanho, valor);
        this.gola = gola;
        this.manga = manga;
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
