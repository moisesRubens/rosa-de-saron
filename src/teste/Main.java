package teste;
import dominio.integrantes.Cliente;
import dominio.produtos.Roupa;
import servico.ServicosLoja;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Roupa> minhasCamisas = ServicosLoja.venderRoupas(ServicosLoja.Produtos.CAMISA, "nike", 2);
        System.out.println(minhasCamisas);
    }
}