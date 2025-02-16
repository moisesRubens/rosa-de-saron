package teste;

import dominio.integrantes.Cliente;
import dominio.produtos.Camisa;
import servico.ServicosLoja;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        ServicosLoja.addRoupa(new Camisa("Tommy", "cinza", 'M', 45, false, true));
        ServicosLoja.addRoupa(new Camisa("Blue Shark", "cinza", 'M', 45, false, true));
        ServicosLoja.addRoupa(new Camisa("Blue Shark", "cinza", 'M', 45, false, true));
        ServicosLoja.addRoupa(new Camisa("Blue Shark", "cinza", 'M', 45, false, true));
        ServicosLoja.printRoupas();


        Cliente eu = new Cliente("moises", "123", "mouiisesrubens");
        eu.comprar("Tommy", 1);

        ServicosLoja.printRoupas();
    }
}