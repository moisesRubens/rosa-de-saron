package teste;

import dominio.integrantes.Cliente;
import dominio.integrantes.Funcionario;
import dominio.produtos.Calca;
import dominio.produtos.Camisa;
import dominio.produtos.Roupa;
import servico.ServicosLoja;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Cliente eu = new Cliente("Moises", "123", "moisesrubens");
        ServicosLoja.addRoupa(new Camisa("blue shark", "azul e preto", 'M', 67.99D, false, true));
        ServicosLoja.addRoupa(new Camisa("blue shark", "azul e preto", 'M', 67.99D, false, true));
        ServicosLoja.addRoupa(new Camisa("nike", "vermelho", 'M', 99.99D, false, true));
        ServicosLoja.addRoupa(new Camisa("Adidas", "Branco", 'M', 75.99D, true, true));
        ServicosLoja.printRoupas();

        eu.comprarRoupas("blue shark", 2);

        ServicosLoja.printRoupas();
    }
}