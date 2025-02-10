package dominio;

public abstract class Roupa {
    protected String modelo;
    protected int tamanho;
    protected double valor;

    public Roupa(String modelo, int tamanho, double valor) {
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.valor = valor;
    }

}
