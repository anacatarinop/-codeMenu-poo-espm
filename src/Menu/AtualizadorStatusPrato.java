package Menu;

import javax.swing.JOptionPane;

import Gerenciador.GerenciadorMenu;

public class AtualizadorStatusPrato {
    private GerenciadorMenu gerenciadorMenu;

    public AtualizadorStatusPrato(GerenciadorMenu gerenciadorMenu) {
        this.gerenciadorMenu = gerenciadorMenu;
    }

    public void atualizarStatus() {
        String nomeDoPrato = JOptionPane.showInputDialog("Digite o nome do prato que deseja atualizar o status:");
        boolean novoStatus = JOptionPane.showConfirmDialog(null, "O prato está disponível?", "Disponibilidade", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        if (!gerenciadorMenu.atualizarStatusPrato(nomeDoPrato, novoStatus)) {
            JOptionPane.showMessageDialog(null, "Prato não encontrado. Tente novamente.");
        }
    }
}
