package br.com.escola.estrelaguia.View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMenu() {
        System.out.println("Menu Principal");
        System.out.println("1. Alunos");
        System.out.println("2. Professores");
        System.out.println("3. Disciplinas");
        System.out.println("4. Turmas");
        System.out.println("5. Matrículas");
        System.out.println("6. Sair");
    }

    public int getOpcao() {
        int opcao = 0;
        try {
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Tente novamente.");
            scanner.nextLine(); // Consume invalid input
        }
        return opcao;
    }
}