package Gerenciador;

import java.util.ArrayList;
import java.util.List;

import Menu.ItemMenu;

public class GerenciadorMenu {
    private List<ItemMenu> menu;

    public GerenciadorMenu() {
        this.menu = new ArrayList<>();
    }

    public boolean adicionarItem(ItemMenu item) {
        for (ItemMenu i : menu) {
            if (i.getCodigo().equals(item.getCodigo())) {
                return false;  
            }
        }
        menu.add(item);
        return true;
    }

    public List<ItemMenu> listarItens() {
        return new ArrayList<>(menu);
    }

    public ItemMenu getItemPorCodigo(String codigo) {
        for (ItemMenu item : menu) {
            if (item.getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null;
    }

    public ItemMenu getItemPorIndice(int indice) {
        if (indice >= 0 && indice < menu.size()) {
            return menu.get(indice);
        }
        return null;
    }

    public boolean atualizarItem(String codigo, String novaDescricao, double novoPreco, boolean novoStatus) {
        ItemMenu item = getItemPorCodigo(codigo);
        if (item != null) {
            item.setDescricao(novaDescricao);
            item.setPreco(novoPreco);
            item.setStatus(novoStatus);
            return true;
        }
        return false;
    }

    public boolean itemExiste(String codigo) {
        for (ItemMenu item : menu) {
            if (item.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean removerItem(String codigo) {
        ItemMenu item = getItemPorCodigo(codigo);
        if (item != null) {
            menu.remove(item);
            return true;
        }
        return false;
    }

    public boolean atualizarStatusItem(String codigo, boolean novoStatus) {
        ItemMenu item = getItemPorCodigo(codigo);
        if (item != null) {
            item.setStatus(novoStatus);
            return true;
        }
        return false;
    }
}
