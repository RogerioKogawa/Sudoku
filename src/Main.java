import java.util.*;

public class Main {
    public static void main(String[] args) {
        // exemplo de criação de blocos vazios
        Bloco b1 = new Bloco(1, new HashMap<>());
        Bloco b2 = new Bloco(2, new HashMap<>());
        Bloco b3 = new Bloco(3, new HashMap<>());
        Bloco b4 = new Bloco(4, new HashMap<>());
        Bloco b5 = new Bloco(5, new HashMap<>());
        Bloco b6 = new Bloco(6, new HashMap<>());
        Bloco b7 = new Bloco(7, new HashMap<>());
        Bloco b8 = new Bloco(8, new HashMap<>());
        Bloco b9 = new Bloco(9, new HashMap<>());

        Sudoku sudoku = new Sudoku(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        SudokuStatus status = new SudokuStatus(sudoku);
        VisualizarSudoku view = new VisualizarSudoku(sudoku);

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Status do Sudoku: " + status.Status());
            if (status.Status().equals("Jogo completo")) {
                System.out.println("Parabéns! Sudoku completo.");
                break;
            }

            try {
                System.out.println("Digite o bloco (1-9) ou 0 para sair:");
                int idBloco = scanner.nextInt();
                if (idBloco == 0) break;

                System.out.println("Digite o número a inserir (1-9):");
                int numero = scanner.nextInt();

                System.out.println("Digite a posição dentro do bloco (1-9):");
                int posicao = scanner.nextInt();

                boolean sucesso = sudoku.adicionarNumero(idBloco, numero, posicao);
                if (sucesso) {
                    System.out.println("Número inserido com sucesso!");
                } else {
                    System.out.println("Falha ao inserir o número. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Reinicie o passo: " + e.getMessage());
                scanner.nextLine(); // Limpa buffer caso tenha lido algo inválido
            }

            view.exibir(); // Mostra o Sudoku atualizado
            System.out.println("\n".repeat(5));
        }

        System.out.println("Encerrando o jogo.");
        scanner.close();
        /* Exemplo de sudoku completo
        sudoku.adicionarNumero(1, 8, 1);
        sudoku.adicionarNumero(1, 3, 2);
        sudoku.adicionarNumero(1, 5, 3);
        sudoku.adicionarNumero(1, 2, 4);
        sudoku.adicionarNumero(1, 9, 5);
        sudoku.adicionarNumero(1, 6, 6);
        sudoku.adicionarNumero(1, 4, 7);
        sudoku.adicionarNumero(1, 1, 8);
        sudoku.adicionarNumero(1, 7, 9);
        sudoku.adicionarNumero(2, 4, 1);
        sudoku.adicionarNumero(2, 1, 2);
        sudoku.adicionarNumero(2, 6, 3);
        sudoku.adicionarNumero(2, 8, 4);
        sudoku.adicionarNumero(2, 5, 5);
        sudoku.adicionarNumero(2, 7, 6);
        sudoku.adicionarNumero(2, 2, 7);
        sudoku.adicionarNumero(2, 9, 8);
        sudoku.adicionarNumero(2, 3, 9);
        sudoku.adicionarNumero(3, 9, 1);
        sudoku.adicionarNumero(3, 2, 2);
        sudoku.adicionarNumero(3, 7, 3);
        sudoku.adicionarNumero(3, 4, 4);
        sudoku.adicionarNumero(3, 3, 5);
        sudoku.adicionarNumero(3, 1, 6);
        sudoku.adicionarNumero(3, 6, 7);
        sudoku.adicionarNumero(3, 5, 8);
        sudoku.adicionarNumero(3, 8, 9);
        sudoku.adicionarNumero(4, 5, 1);
        sudoku.adicionarNumero(4, 6, 2);
        sudoku.adicionarNumero(4, 9, 3);
        sudoku.adicionarNumero(4, 1, 4);
        sudoku.adicionarNumero(4, 2, 5);
        sudoku.adicionarNumero(4, 3, 6);
        sudoku.adicionarNumero(4, 7, 7);
        sudoku.adicionarNumero(4, 4, 8);
        sudoku.adicionarNumero(4, 8, 9);
        sudoku.adicionarNumero(5, 1, 1);
        sudoku.adicionarNumero(5, 3, 2);
        sudoku.adicionarNumero(5, 4, 3);
        sudoku.adicionarNumero(5, 6, 4);
        sudoku.adicionarNumero(5, 7, 5);
        sudoku.adicionarNumero(5, 8, 6);
        sudoku.adicionarNumero(5, 5, 7);
        sudoku.adicionarNumero(5, 2, 8);
        sudoku.adicionarNumero(5, 9, 9);
        sudoku.adicionarNumero(6, 7, 1);
        sudoku.adicionarNumero(6, 8, 2);
        sudoku.adicionarNumero(6, 2, 3);
        sudoku.adicionarNumero(6, 5, 4);
        sudoku.adicionarNumero(6, 4, 5);
        sudoku.adicionarNumero(6, 9, 6);
        sudoku.adicionarNumero(6, 1, 7);
        sudoku.adicionarNumero(6, 6, 8);
        sudoku.adicionarNumero(6, 3, 9);
        sudoku.adicionarNumero(7, 6, 1);
        sudoku.adicionarNumero(7, 5, 2);
        sudoku.adicionarNumero(7, 2, 3);
        sudoku.adicionarNumero(7, 9, 4);
        sudoku.adicionarNumero(7, 8, 5);
        sudoku.adicionarNumero(7, 1, 6);
        sudoku.adicionarNumero(7, 3, 7);
        sudoku.adicionarNumero(7, 7, 8);
        sudoku.adicionarNumero(7, 4, 9);
        sudoku.adicionarNumero(8, 7, 1);
        sudoku.adicionarNumero(8, 8, 2);
        sudoku.adicionarNumero(8, 1, 3);
        sudoku.adicionarNumero(8, 3, 4);
        sudoku.adicionarNumero(8, 4, 5);
        sudoku.adicionarNumero(8, 5, 6);
        sudoku.adicionarNumero(8, 9, 7);
        sudoku.adicionarNumero(8, 6, 8);
        sudoku.adicionarNumero(8, 2, 9);
        sudoku.adicionarNumero(9, 3, 1);
        sudoku.adicionarNumero(9, 9, 2);
        sudoku.adicionarNumero(9, 4, 3);
        sudoku.adicionarNumero(9, 2, 4);
        sudoku.adicionarNumero(9, 10, 10);
        sudoku.adicionarNumero(9, 6, 6);
        sudoku.adicionarNumero(9, 8, 7);
        sudoku.adicionarNumero(9, 1, 8);
        sudoku.adicionarNumero(9, 5, 9);
        */
    }
}
