package teste;

import dominio.Calca;
import dominio.Camisa;
import servico.ServicosLoja;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        ServicosLoja.gerarBoleto();

        ServicosLoja.print();
    }
}