package Gerenciador;
import java.util.ArrayList;
import java.util.List;

import Menu.ItemMenu;

public class GerenciadorMenu {
    private List<ItemMenu> menu;

    public GerenciadorMenu() {
        this.menu = new ArrayList<>();
    }

    public void adicionarItem(ItemMenu item) {
        menu.add(item);
    }

    public List<ItemMenu> listarItens() {
        return new ArrayList<>(menu);
    }

    public boolean atualizarItem(String nome, String novaDescricao, double novoPreco, boolean novoStatus) {
        for (ItemMenu item : menu) {
            if (item.getNome().equals(nome)) {
                item.setDescricao(novaDescricao);
                item.setPreco(novoPreco);
                item.setStatus(novoStatus);
                return true;  // atualização bem sucedida
            }
        }
        return false;  // não foi encontrado nenhum item com esse nome
    }

    public boolean removerItem(String nome) {
        return menu.removeIf(item -> item.getNome().equals(nome));
    }

    public boolean atualizarStatusItem(String nomeItem, boolean novoStatus) {
        for (ItemMenu item : menu) {
            if (item.getNome().equals(nomeItem)) {
                item.setStatus(novoStatus);
                return true;  // item encontrado e status atualizado
            }
        }
        return false;  // item não encontrado
    }
}
