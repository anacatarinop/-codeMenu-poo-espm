package Menu;

import javax.swing.JOptionPane;

import Gerenciador.GerenciadorMenuGUI;

public class Main {
    public static void main(String[] args) {
        int start = JOptionPane.showConfirmDialog(null, "Bem-vindo ao gerenciador do menu. Deseja iniciar?", "Bem-vindo", JOptionPane.YES_NO_OPTION);
        if (start == JOptionPane.YES_OPTION) {
            GerenciadorMenuGUI gerenciadorMenuGUI = new GerenciadorMenuGUI();
            gerenciadorMenuGUI.displayPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Cardápio fechado com sucesso!");
            System.exit(0);
        }
    }
}
