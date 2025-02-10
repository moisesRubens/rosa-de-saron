package dominio;

import java.util.ArrayList;

public class Loja {
    ArrayList<Roupa> estoque = new ArrayList<Roupa>();

    public void addCamisa(Camisa camisa) {
        estoque.add(camisa);
    }

    public Roupa getCamisa(String modelo, int tamanho) {
        for(Roupa roupa: estoque) {
            if(roupa.modelo.equals(modelo) && roupa.tamanho == tamanho) {
                return roupa;
            }
        }
        return null;
    }
}
