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
        System.out.println(ServicosLoja.cadastrarCliente("Moises", "moisesrubens", "123"));
    }
}