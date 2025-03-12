package servico;

import java.time.LocalDate;

public class Desconto {
    Double valorDesconto;
    LocalDate validade;
    String nomeRoupa;

    public Desconto(Double valorDesconto, LocalDate validade, String nomeRoupa) {
        this.valorDesconto = valorDesconto;
        this.validade = validade;
        this.nomeRoupa = nomeRoupa;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public String getNomeRoupa() {
        return nomeRoupa;
    }

    @Override
    public String toString() {
        return "Desconto{" +
                "valorDesconto=" + valorDesconto +
                ", validade=" + validade +
                ", nomeRoupa='" + nomeRoupa + '\'' +
                '}';
    }
}
