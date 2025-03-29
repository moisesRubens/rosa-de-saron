package teste;


import dominio.integrantes.Cliente;
import dominio.integrantes.Funcionario;
import dominio.integrantes.Pessoa;
import dominio.produtos.Calca;
import dominio.produtos.Camisa;
import dominio.produtos.Roupa;
import servico.ServicosLoja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        ServicosLoja.addRoupa("rubens");
        System.out.println("fim");
    }
}