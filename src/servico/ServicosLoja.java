package servico;

import dominio.integrantes.Cliente;
import dominio.produtos.Roupa;
import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;

public class ServicosLoja {
    public static ArrayList<Roupa> estoque = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static Map<String, Double> descontos = new HashMap<>();
    public static Map<String, LocalDate> descontosValidade = new HashMap<>();

    public static void addRoupa(Roupa roupa) throws IOException {
        estoque.add(roupa);
    }

    public static ArrayList<Roupa> venderRoupa(String nomeProduto, int quantidade) {
        ArrayList<Roupa> roupas = new ArrayList<>();
        if (!getRoupasSuficientes(nomeProduto, quantidade)) {
            System.out.println("NAO HÁ ROUPAS DESTE MODELO SUFICIENTE PARA VENDER");
        } else {
            Iterator<Roupa> iterator = estoque.iterator();
            while (iterator.hasNext()) {
                Roupa roupa = iterator.next();
                if (roupa.getNome().equals(nomeProduto) && roupas.size() < quantidade) {
                    roupas.add(roupa);
                    iterator.remove();
                }
            }
        }
        return roupas;
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

    public static boolean getRoupasSuficientes(String nome, int quantidade) {
        int quantidadeEstoque = 0;

        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nome.toUpperCase()) && quantidadeEstoque<quantidade) {
                quantidadeEstoque++;
            }
        }
        return (quantidadeEstoque == quantidade);
    }

    public static void gerarComprovante(ArrayList<Roupa> compra) {
        try(BufferedWriter file = new BufferedWriter(new FileWriter("compra.txt"))) {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR"));
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

    public static void addDesconto(Double descontoPorcentagem, String nomeRoupa, LocalDate validade) {
        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nomeRoupa.toUpperCase())) {
                Double descontoValor = roupa.getValor()*descontoPorcentagem;
                double novoValor = roupa.getValor()-descontoValor;
                descontos.put(roupa.getNome(), descontoValor);
                roupa.setValor(novoValor);
                descontosValidade.put(roupa.getNome(), LocalDate.now());
            }
        }
    }

    public static void removeDesconto(String nomeRoupa) {
        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nomeRoupa.toUpperCase()) && descontos.containsKey(roupa.getNome())) {
                double valor = roupa.getValor()+ descontos.get(roupa.getNome());
                roupa.setValor(valor);
            }
        }
        descontos.remove(nomeRoupa.toUpperCase());
    }

    public static void printDescontos() {
        System.out.println(descontos);
    }

    public static void printDescontosValidade() {
        System.out.println(descontosValidade);
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
