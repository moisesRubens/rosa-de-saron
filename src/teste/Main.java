package teste;

import dominio.integrantes.Cliente;
import dominio.integrantes.Funcionario;
import dominio.produtos.Calca;
import dominio.produtos.Camisa;
import servico.ServicosLoja;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("DURANTE A CRIACAO:");
        ServicosLoja.addRoupa(new Camisa("Polo", "Preta", 'M', 70D, true, true));
        ServicosLoja.printRoupas();

        System.out.println("COM DESCONTO:");
        ServicosLoja.addDesconto(0.15D, "Polo");
        ServicosLoja.printRoupas();

        System.out.println("SEM DESCONTO:");
        ServicosLoja.removeDesconto("Polo");
        ServicosLoja.printRoupas();

    }
}