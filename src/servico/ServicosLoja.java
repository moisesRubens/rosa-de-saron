package servico;

import dominio.integrantes.Cliente;
import dominio.produtos.Calca;
import dominio.produtos.Camisa;
import dominio.produtos.Roupa;
import java.io.*;
import java.nio.file.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServicosLoja {
    public enum Produtos {
        CAMISA,
        CALCA;
    }

    public static ArrayList<Roupa> estoque = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static Map<String, Desconto> descontos = new HashMap<>();

    public static Camisa criarCamisa(String nome, String cor, char tamanho, double valor, boolean gola, boolean manga) {
        return new Camisa(nome, cor, tamanho, valor, gola, manga);
    }

    public static ArrayList<Roupa> criarCamisa(String nome, String cor, char tamanho, double valor, boolean gola, boolean manga, int quantidade) {
        ArrayList<Roupa> camisas = new ArrayList<>();

        for(int i=0; i<quantidade; i++) {
            camisas.add(ServicosLoja.criarCamisa(nome, cor, tamanho, valor, gola, manga));
        }
        return camisas;
    }

    public static Calca criarCalca(String nome, String cor, int tamanho, double valor, String peCalca) {
        return new Calca(nome, cor, tamanho, valor, peCalca);
    }

    public static ArrayList<Roupa> criarCalca(String nome, String cor, int tamanho, double valor, String peCalca, int quantidade) {
        ArrayList<Roupa> calcas = new ArrayList<>();

        for(int i=0; i<quantidade; i++) {
            calcas.add(ServicosLoja.criarCalca(nome, cor, tamanho, valor, peCalca));
        }
        return calcas;
    }

    public static void addRoupa(ArrayList<Roupa> roupas) throws IOException{
        try(BufferedWriter bufferedWriterCamisas = new BufferedWriter(new FileWriter("camisas.txt", true));
            BufferedWriter bufferedWriterCalcas = new BufferedWriter(new FileWriter("calcas.txt", true))) {
            for (Roupa roupa : roupas) {
                if (roupa instanceof Camisa camisa) {
                    bufferedWriterCamisas.write(camisa.getNome()+","+camisa.getValor()+","+camisa.getCor()+
                            ","+camisa.getTamanho()+","+camisa.isManga()+","+camisa.isGola());
                    bufferedWriterCamisas.newLine();
                } else {
                    Calca calca = (Calca) roupa;
                    bufferedWriterCalcas.write(calca.getNome()+","+calca.getValor()+","+calca.getCor()+
                            ","+calca.getTamanho()+","+calca.getPeCalca());
                    bufferedWriterCalcas.newLine();
                }
            }
        }
    }

    public static ArrayList<Roupa> venderRoupas(Produtos tipo, String nome, int quantidade) throws IOException {
        ArrayList<Roupa> roupas = new ArrayList<>();
        File compra = getArquivoCompra(tipo, nome.toUpperCase(), quantidade);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(compra))) {
            String linha;
            String[] atributos;
            String nomeObj;
            double valorObj;
            String corObj;

            if(tipo.equals(Produtos.CAMISA)) {
                char tamanhoObj;
                boolean hasGolaObj;
                boolean hasMangaObj;

                while((linha = bufferedReader.readLine()) != null) {
                    atributos = linha.split(",");
                    nomeObj = atributos[0];
                    valorObj = Double.parseDouble(atributos[1]);
                    corObj = atributos[2];
                    tamanhoObj = atributos[3].charAt(0);
                    hasMangaObj = Boolean.parseBoolean(atributos[4]);
                    hasGolaObj = Boolean.parseBoolean(atributos[5]);
                    roupas.add(criarCamisa(nomeObj, corObj, tamanhoObj, valorObj, hasGolaObj, hasMangaObj));
                }
            } else {
                int tamanhoObj;
                String peCalcaObj;

                while((linha = bufferedReader.readLine()) != null) {
                    atributos = linha.split(",");
                    nomeObj = atributos[0];
                    valorObj = Double.parseDouble(atributos[1]);
                    corObj = atributos[2];
                    tamanhoObj = Integer.parseInt(atributos[3]);
                    peCalcaObj = atributos[4];
                    roupas.add(criarCalca(nomeObj, corObj, tamanhoObj, valorObj, peCalcaObj));
                }
            }
        }
        compra.delete();
        return roupas;
    }

    public static File getArquivoCompra(Produtos produto, String nome, int quantidade) throws IOException {
        String nomeArquivo = (produto.equals(Produtos.CAMISA)) ?"camisas.txt" :"calcas.txt";
        File original = new File(nomeArquivo);
        File temp = new File("temp.txt");
        File compra = new File("compra.txt");
        Scanner scanner = new Scanner(System.in);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(original));
        BufferedWriter bufferedWriterCompra = new BufferedWriter(new FileWriter(compra));
        BufferedWriter bufferedWriterTemp = new BufferedWriter(new FileWriter(temp))) {
            String linha;
            int quant = 0;

            if(produto.equals(Produtos.CAMISA)) {
                char tamanhoCamisa = scanner.next().charAt(0);

                while ((linha = bufferedReader.readLine()) != null) {
                    if(linha.contains(nome) && linha.contains(String.valueOf(tamanhoCamisa)) && quant<quantidade) {
                        bufferedWriterCompra.write(linha);
                        bufferedWriterCompra.newLine();
                        quant++;
                    } else {
                        bufferedWriterTemp.write(linha);
                        bufferedWriterTemp.newLine();
                    }
                }
            } else {
                int tamanhoCalca = Integer.parseInt(scanner.next());

                while((linha = bufferedReader.readLine()) != null) {
                    if(linha.contains(nome) && linha.contains(String.valueOf(tamanhoCalca)) && quant<quantidade) {
                        bufferedWriterCompra.write(linha);
                        bufferedWriterCompra.newLine();
                        quant++;
                    } else {
                        bufferedWriterTemp.write(linha);
                        bufferedWriterTemp.newLine();
                    }
                }
            }
            scanner.close();
        }

        if(!original.delete()) {
            System.out.println("Erro ao deletar original");
            return null;
        }
        if(!temp.renameTo(original)) {
            System.out.println("Erro ao renomar temp para original");
            return null;
        }

        return compra;
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
