package dominio;

public class Calca extends Roupa {
    protected String peCalca;
    protected char tamanho;

    public Calca(String nome, String cor, char tamanho, double valor, String peCalca) {
        super(nome, cor, valor);
        this.peCalca = peCalca;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Calca{" +
                "peCalca='" + peCalca + '\'' +
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

    public String getPeCalca() {
        return peCalca;
    }

    public void setPeCalca(String peCalca) {
        this.peCalca = peCalca;
    }
}
