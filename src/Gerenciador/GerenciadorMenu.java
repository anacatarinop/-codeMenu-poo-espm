package Gerenciador;

import java.util.ArrayList;
import java.util.List;

import Menu.Prato;

public class GerenciadorMenu {
    private List<Prato> menu;

    public GerenciadorMenu() {
        this.menu = new ArrayList<>();
    }

    public boolean adicionarPrato(Prato prato) {
        for (Prato p : menu) {
            if (p.getCodigo().equals(prato.getCodigo())) {
                return false;  
            }
        }
        menu.add(prato);
        return true;
    }

    public List<Prato> listarPratos() {
        return new ArrayList<>(menu);
    }

    public Prato getPratoPorCodigo(String codigo) {
        for (Prato prato : menu) {
            if (prato.getCodigo().equals(codigo)) {
                return prato;
            }
        }
        return null;
    }

    public Prato getPratoPorIndice(int indice) {
        if (indice >= 0 && indice < menu.size()) {
            return menu.get(indice);
        }
        return null;
    }

    public boolean atualizarPrato(String codigo, String novaDescricao, double novoPreco, boolean novoStatus) {
        Prato prato = getPratoPorCodigo(codigo);
        if (prato != null) {
            prato.setDescricao(novaDescricao);
            prato.setPreco(novoPreco);
            prato.setStatus(novoStatus);
            return true;
        }
        return false;
    }

    public boolean pratoExiste(String codigo) {
        for (Prato prato : menu) {
            if (prato.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean removerPrato(String codigo) {
        Prato prato = getPratoPorCodigo(codigo);
        if (prato != null) {
            menu.remove(prato);
            return true;
        }
        return false;
    }

    public boolean atualizarStatusPrato(String codigo, boolean novoStatus) {
        Prato prato = getPratoPorCodigo(codigo);
        if (prato != null) {
            prato.setStatus(novoStatus);
            return true;
        }
        return false;
    }
}
