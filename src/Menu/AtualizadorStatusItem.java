package Menu;
import javax.swing.*;

import Gerenciador.GerenciadorMenu;

public class AtualizadorStatusItem {
    private GerenciadorMenu gerenciadorMenu;

    public AtualizadorStatusItem(GerenciadorMenu gerenciadorMenu) {
        this.gerenciadorMenu = gerenciadorMenu;
    }

    public void atualizarStatus() {
        String nomeDoItem = JOptionPane.showInputDialog("Digite o nome do item que deseja atualizar o status:");
        boolean novoStatus = JOptionPane.showConfirmDialog(null, "O item está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        if (!gerenciadorMenu.atualizarStatusItem(nomeDoItem, novoStatus)) {
            JOptionPane.showMessageDialog(null, "Item não encontrado. Tente novamente.");
        }
    }
}
