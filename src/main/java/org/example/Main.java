package org.example;

import javax.swing.SwingUtilities;

public class Main { // O nome da classe deve começar com letra maiúscula

    public static class Ex { // Convenção de nome para classe
        public static int days = 0;
    }

    public static void main(String[] args) {
        // Inicia a interface gráfica na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            new Login(); // Chama o construtor da classe Login
        });

            //create(); // Descomente se você quiser criar o banco de dados na inicialização
    }
}
