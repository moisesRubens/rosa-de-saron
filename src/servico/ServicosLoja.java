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
            if(roupa.getNome().equals(nomeProduto) && quant<quantidade) {
                iterator.remove();
                quant++;
            }
        }
    }

    public static void printRoupas() {
        if(estoque.isEmpty()) {
            System.out.println("SEM ROUPAS");
            return;
        }
        for (Roupa roupa : estoque) {
            System.out.println("NOME: " + roupa.getNome());
            System.out.println();
        }
    }

    public static void gerarBoleto() throws IOException{
        File file = new File("boleto-compras\\compra.txt");
        System.out.println("FILE CREATED: "+file.createNewFile());
    }
}
