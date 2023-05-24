package Menu;

import java.util.ArrayList;
import java.util.List;

public class ItemMenu {
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private boolean status;
    private List<Ingrediente> ingredientes;

    public ItemMenu(String codigo, String nome, String descricao, double preco, boolean status) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
        this.ingredientes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public boolean getStatus() {
        return status;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }


    public void adicionarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void atualizarIngrediente(int indice, String nome, double quantidade, String medida) {
        if (indice >= 0 && indice < ingredientes.size()) {
            Ingrediente ingrediente = ingredientes.get(indice);
            ingrediente.setNome(nome);
            ingrediente.setQuantidade(quantidade);
            ingrediente.setMedida(medida);
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Descrição: " + descricao + ", Preço: " + preco + ", Disponível: " + (status ? "Sim" : "Não");
    }
}
