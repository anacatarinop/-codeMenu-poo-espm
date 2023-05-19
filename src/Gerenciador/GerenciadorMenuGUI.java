package Gerenciador;
import javax.swing.*;

import Menu.AtualizadorStatusItem;
import Menu.ItemMenu;

import java.util.List;

public class GerenciadorMenuGUI {
    private GerenciadorMenu gerenciadorMenu;

    public GerenciadorMenuGUI() {
        gerenciadorMenu = new GerenciadorMenu();
    }

    public void iniciar() {
        while (true) {
            String escolha = JOptionPane.showInputDialog("Escolha uma opção:\n"
                    + "1. Adicionar Item\n"
                    + "2. Listar Itens\n"
                    + "3. Atualizar Item\n"
                    + "4. Remover Item\n"
                    + "5. Atualizar Status do Item\n"
                    + "Digite a opção:");

            if (escolha == null) {  // se o usuário clicar em cancelar ou fechar a janela
                break;
            }

            switch (escolha) {
           
            case "1":
                    String nome = JOptionPane.showInputDialog("Nome do Item:");
                    String descricao = JOptionPane.showInputDialog("Descrição do Item:");
                    double preco;
                    try {
                        preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do Item:"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Preço inválido. Insira um número válido.");
                        break;
                    }
                    boolean status = JOptionPane.showConfirmDialog(null, "Item está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

                    ItemMenu novoItem = new ItemMenu(nome, descricao, preco, status);
                    gerenciadorMenu.adicionarItem(novoItem);
                    break;
            
            case "2":
                    List<ItemMenu> itens = gerenciadorMenu.listarItens();
                    if (itens.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há itens para listar.");
                        break;
                    }
                    StringBuilder itensStr = new StringBuilder();
                    for (ItemMenu item : itens) {
                        itensStr.append(item.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, itensStr);
                    break;
      
            case "3":                    
            	String nomeParaAtualizar = JOptionPane.showInputDialog("Nome do Item para Atualizar:");
                    if (gerenciadorMenu.listarItens().stream().noneMatch(item -> item.getNome().equals(nomeParaAtualizar))) {
                        JOptionPane.showMessageDialog(null, "Item não encontrado. Tente novamente.");
                        break;
                    }
                    String novaDescricao = JOptionPane.showInputDialog("Nova Descrição do Item:");
                    double novoPreco;
                    try {
                        novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo Preço do Item:"));
                    } catch (NumberFormatException e) {
                    	JOptionPane.showMessageDialog(null, "Preço inválido. Insira um número válido.");
                        break;
                    }
                    boolean novoStatus = JOptionPane.showConfirmDialog(null, "Item está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

                    if (!gerenciadorMenu.atualizarItem(nomeParaAtualizar, novaDescricao, novoPreco, novoStatus)) {
                        JOptionPane.showMessageDialog(null, "Item não encontrado. Tente novamente.");
                    }
                    break;
            case "4":
                    String nomeParaRemover = JOptionPane.showInputDialog("Nome do Item para Remover:");
                    if (!gerenciadorMenu.removerItem(nomeParaRemover)) {
                        JOptionPane.showMessageDialog(null, "Item não encontrado. Tente novamente.");
                    }
            case "5":
                AtualizadorStatusItem atualizador = new AtualizadorStatusItem(gerenciadorMenu);
                atualizador.atualizarStatus();
                break;
                  
            }
            
        }
    }
}
