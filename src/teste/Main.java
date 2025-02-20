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
        ServicosLoja.addRoupa(new Camisa("Polo", "Preta", 'M', 70D, true, true));
        ServicosLoja.addRoupa(new Camisa("Polo", "Preta", 'M', 70D, true, true));
        ServicosLoja.addRoupa(new Camisa("Polo", "Preta", 'M', 70D, true, true));

        Cliente eu = new Cliente("moises", "12", "moisesrubens");
        eu.comprarRoupas("POLO", 1);

        ServicosLoja.printRoupas();

        System.out.println("COMPRA DO CLIENTE");
        ArrayList<Roupa> roupas2 = eu.getCompras();
        System.out.println(roupas2);
    }
}