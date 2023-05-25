package Gerenciador;

import java.util.List;
import javax.swing.JOptionPane;
import Menu.Ingrediente;
import Menu.Prato;

public class GerenciadorMenuGUI {
    private GerenciadorMenu gerenciadorMenu;
    private boolean menuFechado;
    private boolean pratosCadastrados;

    public GerenciadorMenuGUI() {
        this.gerenciadorMenu = new GerenciadorMenu();
        this.menuFechado = false;
        this.pratosCadastrados = false;
    }

    public void displayPrincipal() {
        while (true) {
            String tipoAcesso = JOptionPane.showInputDialog(null,
                    "Selecione o tipo de acesso:\n"
                    + "1: Administrador\n"
                    + "2: Cliente\n"
                    + "3: Sair\n",
                    "Acesso",
                    JOptionPane.PLAIN_MESSAGE);

            if (tipoAcesso.equals("1")) {
                displayAdministrador();
            } else if (tipoAcesso.equals("2")) {
                displayCliente();
            } else if (tipoAcesso.equals("3")) {
                JOptionPane.showMessageDialog(null, "Saindo...");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha 1 para Administrador, 2 para Cliente ou 3 para Sair.");
            }
        }
    }

    private void displayAdministrador() {
        while (true) {
            String escolha = JOptionPane.showInputDialog(null,
                    "Selecione uma opção:\n"
                    + "1: Adicionar Prato\n"
                    + "2: Listar Pratos\n"
                    + "3: Atualizar Prato\n"
                    + "4: Remover Prato\n"
                    + "5: Atualizar Status de um Prato\n"
                    + "6: Atualizar Ingrediente\n"
                    + "7: Fechar Menu\n"
                    + "8: Voltar para Tela Principal\n",
                    "MENU",
                    JOptionPane.PLAIN_MESSAGE);

            switch (escolha) {
                case "1": // Adicionar Prato
                    String codigo = JOptionPane.showInputDialog("Informe o código do prato");
                    if (!gerenciadorMenu.pratoExiste(codigo)) {
                        String nome = JOptionPane.showInputDialog("Informe o nome do prato");
                        String descricao = JOptionPane.showInputDialog("Informe a descrição do prato");
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do prato"));
                        boolean status = JOptionPane.showConfirmDialog(null, "O prato está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

                        Prato prato = new Prato(codigo, nome, descricao, preco, status);

                        int qtdIngredientes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de ingredientes necessários para este prato"));

                        for (int i = 0; i < qtdIngredientes; i++) {
                            JOptionPane.showMessageDialog(null, "DADOS DO INGREDIENTE " + (i + 1));
                            JOptionPane.showMessageDialog(null, "A seguir, informe em ordem: Nome > Qtd. usada > Medida ");

                            String nomeIngrediente = JOptionPane.showInputDialog("Nome do ingrediente");
                            double quantidade = Double.parseDouble(JOptionPane.showInputDialog("Quantidade do ingrediente"));
                            String medida = JOptionPane.showInputDialog("Unidade de medida do ingrediente (ex: mL, g, Kg, etc.)");
                            Ingrediente ingrediente = new Ingrediente(nomeIngrediente, quantidade, medida);
                            prato.adicionarIngrediente(ingrediente);
                        }

                        gerenciadorMenu.adicionarPrato(prato);
                        pratosCadastrados = true; // Marcando que há pratos cadastrados
                        JOptionPane.showMessageDialog(null, "Prato adicionado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Código já existente! Tente novamente com um código diferente.");
                    }
                    break;

                case "2": // Listar Pratos
                    StringBuilder pratosList = new StringBuilder();
                    List<Prato> listaPratos = gerenciadorMenu.listarPratos();
                    for (Prato prato : listaPratos) {
                        pratosList.append("Código: ").append(prato.getCodigo()).append("\n")
                                .append(prato.toString()).append("\n")
                                .append("Ingredientes:\n");
                        List<Ingrediente> ingredientes = prato.getIngredientes();
                        if (!ingredientes.isEmpty()) {
                            for (Ingrediente ingrediente : ingredientes) {
                                pratosList.append("- ").append(ingrediente.getQuantidade()).append(" ")
                                        .append(ingrediente.getMedida()).append(" de ").append(ingrediente.getNome()).append("\n");
                            }
                        } else {
                            pratosList.append("- Nenhum ingrediente cadastrado\n");
                        }
                        pratosList.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, pratosList.toString());
                    break;

                        case "3": // Atualizar Prato
                            String codigoAtualizar = JOptionPane.showInputDialog("Informe o código do prato que você deseja atualizar");
                            if (gerenciadorMenu.pratoExiste(codigoAtualizar)) {
                                String novaDescricao = JOptionPane.showInputDialog("Informe a nova descrição do prato");
                                double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo preço do prato"));
                                boolean novoStatus = JOptionPane.showConfirmDialog(null, "O prato está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                                gerenciadorMenu.atualizarPrato(codigoAtualizar, novaDescricao, novoPreco, novoStatus);
                                JOptionPane.showMessageDialog(null, "Prato atualizado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Código não encontrado! Tente novamente com um código existente.");
                            }
                            break;

                        case "4": // Remover Prato
                            String codigoRemover = JOptionPane.showInputDialog("Informe o código do prato que você deseja remover");
                            if (gerenciadorMenu.pratoExiste(codigoRemover)) {
                                gerenciadorMenu.removerPrato(codigoRemover);
                                JOptionPane.showMessageDialog(null, "Prato removido com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Código não encontrado! Tente novamente com um código existente.");
                            }
                            break;

                        case "5": // Atualizar Status de um Prato
                            String codigoStatus = JOptionPane.showInputDialog("Informe o código do prato cujo status você deseja atualizar");
                            if (gerenciadorMenu.pratoExiste(codigoStatus)) {
                                boolean statusAtualizar = JOptionPane.showConfirmDialog(null, "O prato está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                                gerenciadorMenu.atualizarStatusPrato(codigoStatus, statusAtualizar);
                                JOptionPane.showMessageDialog(null, "Status do prato atualizado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Código não encontrado! Tente novamente com um código existente.");
                            }
                            break;

                        case "6": // Atualizar Ingrediente
                            StringBuilder pratosGUI = new StringBuilder();
                            List<Prato> listaPratosGUI = gerenciadorMenu.listarPratos();
                            for (int i = 0; i < listaPratosGUI.size(); i++) {
                                pratosGUI.append((i + 1)).append(": ").append(listaPratosGUI.get(i).getNome()).append("\n");
                            }
                            int indexPrato = Integer.parseInt(JOptionPane.showInputDialog("Selecione um prato pelo número:\n" + pratosGUI)) - 1;
                            Prato prato = gerenciadorMenu.getPratoPorIndice(indexPrato);
                            if (prato != null) {
                                StringBuilder ingredientes = new StringBuilder();
                                List<Ingrediente> listaIngredientes = prato.getIngredientes();
                                for (int i = 0; i < listaIngredientes.size(); i++) {
                                    ingredientes.append((i + 1)).append(": ").append(listaIngredientes.get(i).getNome()).append("\n");
                                }
                                int indexIngrediente = Integer.parseInt(JOptionPane.showInputDialog("Selecione um ingrediente pelo número:\n" + ingredientes)) - 1;
                                String novoNome = JOptionPane.showInputDialog("Informe o novo nome do ingrediente");
                                double novaQuantidade = Double.parseDouble(JOptionPane.showInputDialog("Informe a nova quantidade do ingrediente"));
                                String novaMedida = JOptionPane.showInputDialog("Informe a nova unidade de medida do ingrediente");
                                prato.atualizarIngrediente(indexIngrediente, novoNome, novaQuantidade, novaMedida);
                                JOptionPane.showMessageDialog(null, "Ingrediente atualizado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Índice de prato inválido! Tente novamente com um índice válido.");
                            }
                            break;

                            case "7": // Fechar Menu
                            menuFechado = true;
                            JOptionPane.showMessageDialog(null, "Menu fechado com sucesso.");
                            break;
        
                        case "8": // Voltar para Tela Principal
                            JOptionPane.showMessageDialog(null, "Voltando para a tela principal.");
                            return;
        
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha um número entre 1 e 8.");
                            break;
                    
                    }
                }
            }
        
            
            private void displayCliente() {
                while (true) {
                    if (menuFechado) {
                        JOptionPane.showMessageDialog(null, "Cardápio fechado.");
                    } else if (pratosCadastrados) {
                        StringBuilder pratosCliente = new StringBuilder();
                        List<Prato> listaPratos = gerenciadorMenu.listarPratos();
                        if (!listaPratos.isEmpty()) {
                            pratosCliente.append("Pratos Disponíveis:\n");
                            for (Prato prato : listaPratos) {
                                pratosCliente.append("- ").append(prato.getNome()).append(" - Preço: ").append(prato.getPreco()).append("\n");
                            }
                        } else {
                            pratosCliente.append("Nenhum prato cadastrado.\n");
                        }
                        JOptionPane.showMessageDialog(null, pratosCliente.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum prato cadastrado.");
                    }
        
                    String escolhaCliente = JOptionPane.showInputDialog(null,
                            "Selecione uma opção:\n"
                            + "1: Voltar para Tela Principal\n"
                            + "2: Fazer Pedido\n",
                            "Menu Cliente",
                            JOptionPane.PLAIN_MESSAGE);
        
                    if (escolhaCliente.equals("1")) {
                        JOptionPane.showMessageDialog(null, "Voltando para a tela principal.");
                        return;
                    } else if (escolhaCliente.equals("2")) {
                       
                    }
                }
            }
        }
            