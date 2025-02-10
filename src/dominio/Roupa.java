package dominio;

public abstract class Roupa {
    protected String modelo;
    protected String cor;
    protected int tamanho;
    protected double valor;

    public Roupa(String modelo, String cor, int tamanho, double valor) {
        this.modelo = modelo;
        this.cor = cor;
        this.tamanho = tamanho;
        this.valor = valor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
