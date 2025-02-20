package dominio.integrantes;

public abstract class Pessoa {
    String nome;
    String cpf;
    String email;

    public Pessoa(String name, String cpf, String email) {
        this.nome = name.toUpperCase();
        this.cpf = cpf;
        this.email = email;
    }
}
