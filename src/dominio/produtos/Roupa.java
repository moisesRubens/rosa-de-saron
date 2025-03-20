package dominio.produtos;

public abstract class Roupa {
    String nome;
    String cor;
    double valor;

    public Roupa() {

    }

    public Roupa(String nome, String cor, double valor) {
        this.nome = nome.toUpperCase();
        this.cor = cor.toUpperCase();
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Roupa{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", valor=" + valor+
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome.toUpperCase(); }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) { this.cor = cor.toUpperCase(); }

    public Double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
