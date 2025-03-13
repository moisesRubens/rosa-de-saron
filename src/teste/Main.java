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
        ServicosLoja.addRoupa(new Camisa("abc", "l", 'M', 45D, false, true));
        ServicosLoja.addDesconto(0.12, "abC", LocalDate.of(2025, 4, 12));
        Cliente eu = new Cliente("moises", "123", "moisesrubens");
        eu.comprarRoupas("Abc", 1);

    }
}