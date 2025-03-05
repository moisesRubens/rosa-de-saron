package dominio.integrantes;

import dominio.produtos.Roupa;
import servico.ServicosLoja;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    Integer id;
    boolean adimplencia;
    ArrayList<Roupa> compras = new ArrayList<>();

    public Cliente(String name, String cpf, String email, int id) {
        super(name, cpf, email);
        this.id = id;
        this.adimplencia = true;
    }

    public Integer getId() {
        return id;
    }

    public boolean isAdimplencia() {
        return adimplencia;
    }

    public void comprarRoupas(String nomeRoupa, int quantidade) {
        ArrayList<Roupa> compra = ServicosLoja.venderRoupa(nomeRoupa.toUpperCase(), quantidade);
        if(compra != null) {
            System.out.println("COMPRA BEM SUCEDIDA");
            ServicosLoja.gerarComprovante(compra);
        } else {
            System.out.println("NAO FOI POSSIVEL REALIZAR A COMPRA");
        }
    }

    public void verRoupas() {
        ServicosLoja.printRoupas();
    }

    public ArrayList<Roupa> getCompras() {
        return compras;
    }
}
