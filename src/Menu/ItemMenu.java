package Menu;
public class ItemMenu {
    private String nome;
    private String descricao;
    private double preco;
    private boolean status;  // true se o item est� dispon�vel, false se n�o est�

    

    public ItemMenu(String nome, String descricao, double preco, boolean status) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
    }
    

    // getters
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

    // setters
    public void setNome(String nome) {
        this.nome = nome;
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

    // Para facilitar a impress�o
    @Override
    public String toString() {
        return "Nome: " + nome + ", Descricao: " + descricao + ", Preco: " + preco + ", Disponivel: " + (status ? "Sim" : "Nao");
    }
}