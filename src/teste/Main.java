package teste;

import dominio.integrantes.Cliente;
import dominio.produtos.Camisa;
import servico.ServicosLoja;

public class Main {
    public static void main(String[] args) throws Exception {
        ServicosLoja.addRoupa(new Camisa("Tommy", "cinza", 'M', 45, false, true));
        ServicosLoja.printRoupas();

        Cliente eu = new Cliente("moises", "123", "mouiisesrubens");
        eu.comprar("Tommy", 1);

        ServicosLoja.printRoupas();
        eu.verRoupas();
    }
}