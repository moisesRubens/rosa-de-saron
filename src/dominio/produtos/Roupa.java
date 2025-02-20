package dominio.produtos;

public abstract class Roupa {
    String nome;
    String cor;
    double valor;
    double descontoValor;

    public Roupa(String nome, String cor, double valor) {
        this.nome = nome.toUpperCase();
        this.cor = cor;
        this.valor = valor;
    }

    public double getDescontoValor() {
        return descontoValor;
    }

    public void setDescontoValor(double descontoValor) {
        this.descontoValor = descontoValor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome.toUpperCase(); }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) { this.cor = cor.toUpperCase(); }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
