package teste;


import dominio.integrantes.Cliente;
import dominio.integrantes.Funcionario;
import dominio.integrantes.Pessoa;
import dominio.produtos.Calca;
import dominio.produtos.Camisa;
import servico.ServicosLoja;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        ServicosLoja.addRoupa(new Camisa("a", "l", 'M', 45D, false, true));
        ServicosLoja.addDesconto(0.10, "a", LocalDate.of(2025, 4, 3));
        ServicosLoja.getRoupas();
        ServicosLoja.getDescontos();

        ServicosLoja.removeDesconto("a");
        ServicosLoja.getRoupas();
        ServicosLoja.getDescontos();

    }
}