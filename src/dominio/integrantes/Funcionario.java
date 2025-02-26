package dominio.integrantes;

import dominio.produtos.Calca;
import dominio.produtos.Roupa;
import servico.ServicosLoja;

public class Funcionario extends Pessoa {
    public Funcionario(String name, String cpf, String email) {
        super(name, cpf, email);
    }

    public void adicionarRoupas(Roupa roupa) {
        //ServicosLoja.addRoupa(roupa);
    }

    public boolean getRoupa(String nomeRoupa) {
        for (Roupa roupa : ServicosLoja.estoque) {
            if(roupa.getNome().equals(nomeRoupa)) {
                return true;
            }
        }
        return false;
    }

    public void verEstoque() {
        ServicosLoja.printRoupas();
    }
}

