package teste;

import dominio.integrantes.Cliente;
import dominio.integrantes.Funcionario;
import dominio.produtos.Calca;
import dominio.produtos.Camisa;
import servico.ServicosLoja;

public class Main {
    public static void main(String[] args) throws Exception {
        ServicosLoja.addRoupa(new Camisa("Tommy", "cinza", 'M', 45, false, true));
        System.out.println("ANTES DO DESCONTO");
        ServicosLoja.printRoupas();

        ServicosLoja.addDesconto(0.1, "Tommy");
        System.out.println("DEPOIS DO DESCONTO");
        ServicosLoja.printRoupas();

    }
}