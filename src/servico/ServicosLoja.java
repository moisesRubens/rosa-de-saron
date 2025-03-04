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
        if(getQuantidadeRoupaX(nomeProduto.toUpperCase()) < quantidade) {
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
        return roupas;
    }

    public static void venderRoupa(String nomeRoupa) throws IOException {
        File inputFile = new File("componentes\\roupas.txt");
        File tempFile = new File("componentes\\temp_roupas.txt");

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String linha;
            boolean deletado = false;

            while ((linha = bufferedReader.readLine()) != null) {
                if (nomeRoupa.equals(linha)) {
                    deletado = true;
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    continue;
                }
                bufferedWriter.write(linha + "\n");
            }
        }
        if(inputFile.delete() && tempFile.renameTo(inputFile)) {
            System.out.println("Delete sucedido");
        } else {
            System.out.println("Deu erro em algo");
        }
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
        Cliente cliente = Cliente.criarCliente(nome, cpf, email, ordem, new ServicosLoja());
        return clientes.add(cliente);
    }
}
