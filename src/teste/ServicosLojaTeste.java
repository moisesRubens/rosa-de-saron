package teste;

import dominio.produtos.Camisa;
import dominio.produtos.Roupa;
import servico.ServicosLoja;

import java.io.IOException;

public class ServicosLojaTeste {
    public static void main(String[] args) throws IOException {

        ServicosLoja.addRoupa(new Camisa("tommy", "cinza", 'M', 50D, false, true));
        ServicosLoja.addRoupa(new Camisa("nike", "cinza", 'M', 50D, false, true));
        ServicosLoja.addRoupa(new Camisa("adidas", "cinza", 'M', 50D, false, true));
        ServicosLoja.venderRoupa("TOMMY");
    }
}
