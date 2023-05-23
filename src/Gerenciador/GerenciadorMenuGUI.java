package Gerenciador;

import java.util.List;
import javax.swing.JOptionPane;
import Menu.Ingrediente;
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
                + "6: Atualizar Ingrediente\n"
                + "7: Sair\n",
                "MENU",
                JOptionPane.PLAIN_MESSAGE);

            switch (escolha) {
                case "1": // Adicionar Item
                    String codigo = JOptionPane.showInputDialog("Informe o código do item");
                    if (!gerenciadorMenu.itemExiste(codigo)) {
                        String nome = JOptionPane.showInputDialog("Informe o nome do item");
                        String descricao = JOptionPane.showInputDialog("Informe a descrição do item");
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do item"));
                        boolean status = JOptionPane.showConfirmDialog(null, "O item está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

                        ItemMenu item = new ItemMenu(codigo, nome, descricao, preco, status);

                        int qtdIngredientes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de ingredientes necessários para este item"));

                        for (int i = 0; i < qtdIngredientes; i++) {
                            JOptionPane.showMessageDialog(null, "DADOS DO INGREDIENTE " + (i + 1));
                            JOptionPane.showMessageDialog(null, "A seguir, informe em ordem: Nome > Qtd. usada > Medida ");

                            String nomeIngrediente = JOptionPane.showInputDialog("Nome do ingrediente");
                            double quantidade = Double.parseDouble(JOptionPane.showInputDialog("Quantidade do ingrediente"));
                            String medida = JOptionPane.showInputDialog("Unidade de medida do ingrediente (ex: mL, g, Kg, etc.)");
                            Ingrediente ingrediente = new Ingrediente(nomeIngrediente, quantidade, medida);
                            item.adicionarIngrediente(ingrediente);
                        }

                        gerenciadorMenu.adicionarItem(item);
                        JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Código já existente! Tente novamente com um código diferente.");
                    }
                    break;
                    
                case "2": // Listar Itens
                    StringBuilder itens = new StringBuilder();
                    List<ItemMenu> listaItens = gerenciadorMenu.listarItens();
                    for (ItemMenu item : listaItens) {
                        itens.append("Código: ").append(item.getCodigo()).append("\n")
                             .append(item.toString()).append("\n")
                             .append("Ingredientes:\n");
                        List<Ingrediente> ingredientes = item.getIngredientes();
                        if (!ingredientes.isEmpty()) {
                            for (Ingrediente ingrediente : ingredientes) {
                                itens.append("- ").append(ingrediente.getQuantidade()).append(" ")
                                     .append(ingrediente.getMedida()).append(" de ").append(ingrediente.getNome()).append("\n");
                            }
                        } else {
                            itens.append("- Nenhum ingrediente cadastrado\n");
                        }
                        itens.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, itens.toString());
                    break;

                // Restante das opções do switch statement

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

                case "6": // Atualizar Ingrediente
                    StringBuilder items = new StringBuilder();
                    List<ItemMenu> listItem = gerenciadorMenu.listarItens();
                    for (int i = 0; i < listItem.size(); i++) {
                        items.append((i + 1)).append(": ").append(listItem.get(i).getNome()).append("\n");
                    }
                    int indexItem = Integer.parseInt(JOptionPane.showInputDialog("Selecione um item pelo número:\n" + items)) - 1;
                    ItemMenu item = gerenciadorMenu.getItemPorIndice(indexItem);
                    if (item != null) {
                        StringBuilder ingredients = new StringBuilder();
                        List<Ingrediente> listIngredients = item.getIngredientes();
                        for (int i = 0; i < listIngredients.size(); i++) {
                            ingredients.append((i + 1)).append(": ").append(listIngredients.get(i).getNome()).append("\n");
                        }
                        int indexIngredient = Integer.parseInt(JOptionPane.showInputDialog("Selecione um ingrediente pelo número:\n" + ingredients)) - 1;
                        String newName = JOptionPane.showInputDialog("Informe o novo nome do ingrediente");
                        double newQuantity = Double.parseDouble(JOptionPane.showInputDialog("Informe a nova quantidade do ingrediente"));
                        String newMeasure = JOptionPane.showInputDialog("Informe a nova unidade de medida do ingrediente");
                        item.atualizarIngrediente(indexIngredient, newName, newQuantity, newMeasure);
                        JOptionPane.showMessageDialog(null, "Ingrediente atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Índice de item inválido! Tente novamente com um índice válido.");
                    }
                    break;

                case "7": // Sair
                    JOptionPane.showMessageDialog(null, "Menu fechado com sucesso.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha um número entre 1 e 7.");
                    break;
            }
        }
    }
}
