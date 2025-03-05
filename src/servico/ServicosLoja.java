package servico;

import dominio.integrantes.Cliente;
import dominio.produtos.Roupa;
import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ServicosLoja {
    public static ArrayList<Roupa> estoque = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void addRoupa(Roupa roupa) throws IOException {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("componentes\\roupas.txt", true))) {
            bufferedWriter.write(roupa.getNome()+"\n");
            bufferedWriter.write(roupa.getCor()+"\n");
            bufferedWriter.write(roupa.getValor().toString()+"\n\n");
        }
    }

    public static ArrayList<Roupa> venderRoupa(String nomeProduto, int quantidade) {
        if(getRoupasSuficientes(nomeProduto, quantidade)) {
            ArrayList<Roupa> roupas = new ArrayList<>();
            Iterator<Roupa> iterator = estoque.iterator();
            while(iterator.hasNext()) {
                Roupa roupa = iterator.next();
                if(roupa.getNome().equals(nomeProduto) && roupas.size()<quantidade) {
                    roupas.add(roupa);
                    iterator.remove();
                }
            }
            return roupas;
        }

        System.out.println("NAO HÁ ROUPAS DESTE MODELO SUFICIENTE PARA VENDER");
        return null;
    }

    public static void printRoupas() {
        if(estoque.isEmpty()) {
            System.out.println("ESTOQUE DE ROUPAS VAZIO");
            return;
        }
        for (Roupa roupa : estoque) {
            System.out.println("NOME: " + roupa.getNome());
            System.out.println("VALOR: " + roupa.getValor());
            System.out.println();
        }
    }

    private static boolean getRoupasSuficientes(String nome, int quantidade) {
        boolean contem = true;
        int quantidadeEstoque = 0;

        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nome)) {
                quantidadeEstoque++;
            }
        }
        if(quantidadeEstoque < quantidade) contem = false;
        return contem;
    }

    public static void gerarComprovante(ArrayList<Roupa> compra) {
        try(BufferedWriter file = new BufferedWriter(new FileWriter("comprovantes\\compra.txt"))) {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
            file.write(dateFormat.format(new Date())+"\n");
            file.write("\nDADOS DA COMPRA:\n");
            file.write("-----------------");
            for(Roupa roupa: compra) {
                file.write("\nNOME: "+roupa.getNome());
                file.write("\nCOR: "+roupa.getCor());
                file.write("\nVALOR: "+roupa.getValor()+"\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("COMPROVANTE DA COMPRA EMITIDO");
        }
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

    public static boolean cadastrarCliente(String nome, String email, String cpf) {
        int ordem = clientes.size();
        Cliente cliente = new Cliente (nome, cpf, email, ordem);
        return clientes.add(cliente);
    }

    public static void verClientes() {
        if(clientes.isEmpty()) System.out.println("LISTA DE CLIENTES VAZIA");

        for(Cliente cliente: clientes) {
            String situacao = "ADIMPLENTE";
            if(!cliente.isAdimplencia()) situacao = "INADIMPLENTE";

            System.out.println(cliente.getId()+" - "+situacao);
            System.out.println("NOME: "+cliente.getNome());
        }
    }
}
