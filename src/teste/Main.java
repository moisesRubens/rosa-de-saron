package teste;


import dominio.integrantes.Cliente;
import dominio.integrantes.Funcionario;
import dominio.integrantes.Pessoa;
import dominio.produtos.Calca;
import dominio.produtos.Camisa;
import dominio.produtos.Roupa;
import servico.ServicosLoja;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ServicosLoja.addRoupa(new Camisa("a", "l", 'M', 45D, false, true));
        Cliente cliente = new Cliente("moises", "1", "moisesrunems", 0);
        cliente.comprarRoupas("a", 1);
    }
}