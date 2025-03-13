package servico;

import dominio.integrantes.Cliente;
import dominio.produtos.Roupa;
import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ServicosLoja {
    public static ArrayList<Roupa> estoque = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static Map<String, Desconto> descontos = new HashMap<>();

    public static void addRoupa(Roupa roupa) throws IOException {
        estoque.add(roupa);
    }

    public static ArrayList<Roupa> venderRoupa(String nomeProduto, int quantidade) {
        ArrayList<Roupa> roupas = new ArrayList<>();
        if (!verificarRoupasSuficientes(nomeProduto, quantidade)) {
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

    public static void verRoupas() {
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

    public static boolean verificarRoupasSuficientes(String nome, int quantidade) {
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
            LocalDate now = LocalDate.now();
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
            file.write(now.format(formatDate)+"\n");
            file.write("\nDADOS DA COMPRA:\n");
            file.write("-----------------");
            for(Roupa roupa: compra) {
                file.write("\nNOME: "+roupa.getNome());
                file.write("\nCOR: "+roupa.getCor());
                file.write("\nVALOR: "+roupa.getValor()+"\n");
                System.out.println("COMPROVANTE DA COMPRA EMITIDO");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void addDesconto(Double descontoPorcentagem, String nomeRoupa, LocalDate validade) {
        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nomeRoupa.toUpperCase())) {
                Double descontoValor = roupa.getValor()*descontoPorcentagem;
                Double novoValor = roupa.getValor()-descontoValor;
                roupa.setValor(novoValor);
                descontos.put(roupa.getNome(), new Desconto(descontoValor, validade, roupa.getNome()));
            }
        }
    }

    public static void removerDesconto(String nomeRoupa) {
        if(!descontos.containsKey(nomeRoupa.toUpperCase())) {
            System.out.println("ESTA ROUPA NÃO TEM DESCONTO APLICADO");
            return;
        }
        for(Roupa roupa: estoque) {
            if(roupa.getNome().equals(nomeRoupa.toUpperCase())) {
                double valorDesconto = descontos.get(roupa.getNome()).getValorDesconto();
                double valor = roupa.getValor()+valorDesconto;
                roupa.setValor(valor);
            }
        }
        descontos.remove(nomeRoupa.toUpperCase());
    }

    public static void verDescontos() {
        System.out.println(descontos);
    }

    public static boolean cadastrarCliente(Cliente cliente) {
        cliente.setId(clientes.size());
        return clientes.add(cliente);
    }

    public static void verClientes() {
        if(clientes.isEmpty()) {
            System.out.println("LISTA DE CLIENTES VAZIA");
            return;
        }
        for(Cliente cliente: clientes) {
            String situacao = (cliente.isAdimplencia()) ?"ADIMPLENTE" :"INADIMPLENTE";
            System.out.println(cliente.getId()+" - "+situacao);
            System.out.println("NOME: "+cliente.getNome());
        }
    }
}
