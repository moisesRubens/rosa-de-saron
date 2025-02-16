package dominio.integrantes;

import dominio.produtos.Roupa;
import servico.ServicosLoja;

public class Cliente extends Pessoa {
    boolean adimplencia;

    public Cliente(String name, String cpf, String email) {
        super(name, cpf, email);
        adimplencia = true;
    }

    public void comprar(String nomeRoupa, int quantidade) {
        ServicosLoja.venderRoupa(nomeRoupa, quantidade);
    }
}
