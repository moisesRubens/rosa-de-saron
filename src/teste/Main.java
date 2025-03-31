package teste;
import dominio.integrantes.Cliente;
import dominio.produtos.Roupa;
import servico.ServicosLoja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Roupa> minhasCamisas;
//        ServicosLoja.addRoupa(ServicosLoja.criarCalca("a", "amarelo", 38, 89, "folgado", 6));
        minhasCamisas = ServicosLoja.venderRoupas(ServicosLoja.Produtos.CALCA, "a", 2);
        System.out.println(minhasCamisas);
        /*minhasCamisas = ServicosLoja.venderRoupas(ServicosLoja.Produtos.CALCA, "a", 3);
        System.out.println(minhasCamisas);*/
        /*File file = ServicosLoja.getArquivoCompra(ServicosLoja.Produtos.CAMISA, "NIKE", 1);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String l="";
        while((l= br.readLine()) != null) {
            System.out.println(l);
        }*/
    }
}