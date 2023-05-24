package Menu;

public class Ingrediente {
    private String nome;
    private double quantidade;
    private String medida;

    public Ingrediente(String nome, double quantidade, String medida) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.medida = medida;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public String getMedida() {
        return medida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    @Override
    public String toString() {
        return nome + ", " + quantidade + " " + medida;
    }
}
