package servico;

import dominio.Calca;
import dominio.Camisa;
import dominio.Roupa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ServicosLoja {
    static ArrayList<Roupa> estoque = new ArrayList<>();

    public static void addRoupa(Roupa roupa) {
        estoque.add(roupa);
    }

    public static void venderRoupa(String nomeProduto, int quantidade) {
        Iterator<Roupa> iterator = estoque.iterator();
        int quant = 0;

        while(iterator.hasNext()) {
            Roupa roupa = iterator.next();
            if(roupa.getNome().equals(nomeProduto)) {
                iterator.remove();
                quant++;
            }
            if(quantidade == quant) { break; }
        }
    }

    public static void print() {
        if (estoque.isEmpty()) {
            System.out.println("NAO HA ROUPAS");
        }

        for (Roupa roupa : estoque) {
            if (roupa instanceof Camisa camisa) {
                System.out.println("CAMISA: " + camisa.getNome());
                System.out.println("TAMANHO: " + camisa.getTamanho());
                System.out.println("PRECO: " + camisa.getValor());
            } else {
                Calca calca = (Calca) roupa;
                System.out.println("CALCA: " + calca.getNome());
                System.out.println("TAMANHO: " + calca.getTamanho());
                System.out.println("PRECO: " + calca.getValor());
            }
            System.out.println();
        }
    }

    public static void gerarBoleto() throws IOException{
        File file = new File("boleto-compras\\compra.txt");
        System.out.println("FILE CREATED: "+file.createNewFile());
    }
}
