package Gerenciador;

import javax.swing.*;

import Menu.ItemMenu;


public class GerenciadorMenuGUI {
    private GerenciadorMenu gerenciadorMenu;

    public GerenciadorMenuGUI() {
        this.gerenciadorMenu = new GerenciadorMenu();
    }

    public void display() {
        while (true) {
            String escolha = JOptionPane.showInputDialog(null,
                "Selecione uma opção:\n"
                + "1: Adicionar Item\n"
                + "2: Listar Itens\n"
                + "3: Atualizar Item\n"
                + "4: Remover Item\n"
                + "5: Atualizar Status de um Item\n"
                + "6: Sair\n",
                "MENU",
                JOptionPane.PLAIN_MESSAGE);

            switch (escolha) {
            case "1": //Adicionar Item
            	
                    String codigo = JOptionPane.showInputDialog("Informe o código do item");
                    if (!gerenciadorMenu.itemExiste(codigo)) {
                        String nome = JOptionPane.showInputDialog("Informe o nome do item");
                        String descricao = JOptionPane.showInputDialog("Informe a descrição do item");
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do item"));
                        boolean status = JOptionPane.showConfirmDialog(null, "O item está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                        ItemMenu item = new ItemMenu(codigo, nome, descricao, preco, status);
                        gerenciadorMenu.adicionarItem(item);
                        JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Código já existente! Tente novamente com um código diferente.");
                    }
                    break;
                
            case "2": // Listar Itens
                String itens = "";
                for (ItemMenu i : gerenciadorMenu.listarItens()) {
                    itens += "Código: " + i.getCodigo() + "\n" + i.toString() + "\n\n";
                }
                JOptionPane.showMessageDialog(null, itens);
                break;
                
                case "3": // Atualizar Item
                    String codigoAtualizar = JOptionPane.showInputDialog("Informe o código do item que você deseja atualizar");
                    if (gerenciadorMenu.itemExiste(codigoAtualizar)) {
                        String novaDescricao = JOptionPane.showInputDialog("Informe a nova descrição do item");
                        double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo preço do item"));
                        boolean novoStatus = JOptionPane.showConfirmDialog(null, "O item está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                        gerenciadorMenu.atualizarItem(codigoAtualizar, novaDescricao, novoPreco, novoStatus);
                        JOptionPane.showMessageDialog(null, "Item atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Código não encontrado! Tente novamente com um código existente.");
                    }
                    break;
                
                case "4": // Remover Item
                    String codigoRemover = JOptionPane.showInputDialog("Informe o código do item que você deseja remover");
                    if (gerenciadorMenu.itemExiste(codigoRemover)) {
                        gerenciadorMenu.removerItem(codigoRemover);
                        JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Código não encontrado! Tente novamente com um código existente.");
                    }
                    break;
                
                case "5": // Atualizar Status de um Item
                    String codigoStatus = JOptionPane.showInputDialog("Informe o código do item cujo status você deseja atualizar");
                    if (gerenciadorMenu.itemExiste(codigoStatus)) {
                        boolean statusAtualizar = JOptionPane.showConfirmDialog(null, "O item está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                        gerenciadorMenu.atualizarStatusItem(codigoStatus, statusAtualizar);
                        JOptionPane.showMessageDialog(null, "Status do item atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Código não encontrado! Tente novamente com um código existente.");
                    }
                    break;
                
                case "6": // Sair
                    JOptionPane.showMessageDialog(null, "Menu fechado com sucesso.");
                    System.exit(0);
                    break;
                 default:
                     JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha um número entre 1 e 6.");
                     break;
             }
         
        }
    }
}