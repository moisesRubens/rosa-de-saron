package dominio.integrantes;

import dominio.produtos.Roupa;
import servico.ServicosLoja;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    boolean adimplencia;
    ArrayList<Roupa> compras = new ArrayList<>();

    public Cliente(String name, String cpf, String email) {
        super(name, cpf, email);
        adimplencia = true;
    }

    public void comprarRoupas(String nomeRoupa, int quantidade) {
        if(compras.addAll(ServicosLoja.venderRoupa(nomeRoupa, quantidade))) {
            System.out.println("COMPRA BEM SUCEDIDA");
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
