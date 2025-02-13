package servico;

import dominio.Calca;
import dominio.Camisa;
import dominio.Roupa;

import java.util.ArrayList;
import java.util.Iterator;

public class ServicosLoja {
    static ArrayList<Roupa> estoque = new ArrayList<>();

    public static void addRoupa(Roupa roupa) {
        estoque.add(roupa);
    }

    public static void vender(String nomeProduto, int quantidade) {
        Iterator<Roupa> iterator = estoque.iterator();
        int quant = 0;

        while(iterator.hasNext()) {
            Roupa roupa = iterator.next();
            if(roupa.getNome().equals(nomeProduto)) {
                iterator.remove();
                quant++;
            }
            if(quantidade == quant) {
                break;
            }
        }
    }

    public static void print() {
        if(estoque.size() == 0) {
            System.out.println("NAO HA ROUPAS");
        }
        for(Roupa roupa: estoque) {
            if(roupa instanceof Camisa) {
                System.out.println("CAMISA: "+((Camisa)roupa).getNome());
                System.out.println("TAMANHO: "+((Camisa)roupa).getTamanho());
                System.out.println("PRECO: "+((Camisa)roupa).getValor());
            } else {
                System.out.println((Calca)roupa);
            }
            System.out.println();
        }
    }
}
