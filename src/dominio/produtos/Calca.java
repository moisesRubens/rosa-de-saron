package dominio.produtos;

public class Calca extends Roupa {
    protected String peCalca;
    protected int tamanho;

    public Calca(String nome, String cor, int tamanho, double valor, String peCalca) {
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

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getPeCalca() {
        return peCalca;
    }

    public void setPeCalca(String peCalca) {
        this.peCalca = peCalca;
    }
}
