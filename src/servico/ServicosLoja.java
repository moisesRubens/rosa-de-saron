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

    public static ArrayList<Roupa> venderRoupa(String nomeProduto, int quantidade) {
        if(getQuantidadeRoupaX(nomeProduto) < quantidade) {
            System.out.println("NAO HA ROUPAS DESTE MODELO SUFICIENTE PARA VENDER");
            return null;
        }

        ArrayList<Roupa> roupas = new ArrayList<>();
        Iterator<Roupa> iterator = estoque.iterator();
        while(iterator.hasNext()) {
            Roupa roupa = iterator.next();
            if(roupa.getNome().equals(nomeProduto) && roupas.size()<quantidade) {
                roupas.add(roupa);
                iterator.remove();
            }
        }
        gerarComprovante();
        return roupas;
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

    public static void addDesconto(double descontoPorcentagem, String nomeRoupa) {
        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nomeRoupa)) {
                double novoValor = roupa.getValor()-descontoPorcentagem*roupa.getValor();
                roupa.setDescontoValor(descontoPorcentagem*roupa.getValor());
                roupa.setValor(novoValor);
            }
        }
    }

    public static void removeDesconto(String nomeRoupa) {
        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nomeRoupa) && roupa.getDescontoValor() != 0) {
                double valor = roupa.getValor()+roupa.getDescontoValor();
                roupa.setValor(valor);
                roupa.setDescontoValor(0);
            }
        }
    }


}
