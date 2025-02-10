package teste;

import dominio.Camisa;
import dominio.Loja;
import servico.Servicos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Camisa camisa = new Camisa("esportivo", "Azul", 38, 89, false, true);

        Loja loja = new Loja();
        loja.addCamisa(camisa);

        Servicos.divulgarRoupa(loja, "esportivo", 38);
    }
}