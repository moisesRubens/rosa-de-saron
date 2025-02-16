package teste;

import dominio.Calca;
import dominio.Camisa;
import servico.ServicosLoja;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        ServicosLoja.addRoupa(new Camisa("Tommy", "cinza", 'M', 45, false, true));
        ServicosLoja.addRoupa(new Camisa("Blue Shark", "cinza", 'M', 45, false, true));
        ServicosLoja.addRoupa(new Camisa("Blue Shark", "cinza", 'M', 45, false, true));
        ServicosLoja.addRoupa(new Camisa("Blue Shark", "cinza", 'M', 45, false, true));
        ServicosLoja.printRoupas();

        ServicosLoja.venderRoupa("Blue Shark", 2);
        ServicosLoja.printRoupas();
    }
}