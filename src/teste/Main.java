package teste;

import dominio.integrantes.Cliente;
import dominio.integrantes.Funcionario;
import dominio.produtos.Calca;
import dominio.produtos.Camisa;
import servico.ServicosLoja;

public class Main {
    public static void main(String[] args) throws Exception {
        ServicosLoja.addRoupa(new Camisa("Tommy", "cinza", 'M', 45, false, true));
        ServicosLoja.addRoupa(new Camisa("Tommy", "cinza", 'M', 45, false, true));
        ServicosLoja.addRoupa(new Calca("Tommy", "cinza", 'M', 45,  "larga"));

        Funcionario eu = new Funcionario("", "","");
        eu.verEstoque();
    }
}