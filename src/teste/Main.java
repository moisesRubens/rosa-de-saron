package teste;

import dominio.Camisa;
import servico.ServicosLoja;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ServicosLoja.addRoupa(new Camisa("Listrada", "Azul e verde", 'M', 50, false, true));
        ServicosLoja.addRoupa(new Camisa("Listrada", "Azul e verde", 'M', 50, false, true));
        ServicosLoja.print();

        ServicosLoja.vender("Listrada", 1);
        ServicosLoja.print();
    }
}