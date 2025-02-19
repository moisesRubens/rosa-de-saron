package servico;

import dominio.produtos.Roupa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ServicosLoja {
    public static ArrayList<Roupa> estoque = new ArrayList<>();

    public static void addRoupa(Roupa roupa) {
        estoque.add(roupa);
    }

    public static boolean venderRoupa(String nomeProduto, int quantidade) {
        if(getQuantidadeRoupaX(nomeProduto) < quantidade) {
            System.out.println("NAO HA ROUPAS DESTE MODELO SUFICIENTE PARA VENDER");
            return false;
        }

        Iterator<Roupa> iterator = estoque.iterator();
        int quant = 0;
        while(iterator.hasNext()) {
            Roupa roupa = iterator.next();
            if(roupa.getNome().equals(nomeProduto) && quant<quantidade) {
                iterator.remove();
                quant++;
            }
        }
        gerarComprovante();
        return true;
    }

    public static void printRoupas() {
        if(estoque.isEmpty()) {
            System.out.println("SEM ROUPAS");
            return;
        }
        for (Roupa roupa : estoque) {
            System.out.println("NOME: " + roupa.getNome());
            System.out.println("VALOR: " + roupa.getValor());
            System.out.println();
        }
    }

    private static int getQuantidadeRoupaX(String nome) {
        int quantidade = 0;
        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nome)) {
                quantidade++;
            }
        }
        return quantidade;
    }

    private static void gerarComprovante() {
        File file = new File("comprovantes\\compra.txt");
        try {
            file.createNewFile();
        } catch(IOException e) {
            System.out.println("Excecao de createNewFile sendo tratada");
        }
        System.out.println("Finalizando arquivo compra.txt");
    }

    public static void addDesconto(Double descontoPorcentagem, String nomeRoupa) {
        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nomeRoupa)) {
                roupa.setDesconto(descontoPorcentagem);
                Double novoValor = roupa.getValor()-descontoPorcentagem*roupa.getValor();
                roupa.setValor(novoValor);
            }
        }
    }


}
