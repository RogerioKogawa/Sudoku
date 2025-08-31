public class VisualizarSudoku {

    private Sudoku sudoku;

    public VisualizarSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public void exibir() {
        for (int linha = 1; linha <= 9; linha++) {
            if (linha % 3 == 1 && linha != 1) {
                System.out.println("------+-------+------");
            }
            for (int coluna = 1; coluna <= 9; coluna++) {
                if (coluna % 3 == 1 && coluna != 1) {
                    System.out.print("| ");
                }

                int idBloco = getIdBloco(linha, coluna);
                int posicaoNoBloco = getPosicaoDentroBloco(linha, coluna);

                Integer valor = sudoku.getBloco(idBloco).getPosicaoNumeros().get(posicaoNoBloco);

                if (valor == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(valor + " ");
                }
            }
            System.out.println();
        }
    }

    private int getIdBloco(int linha, int coluna) {
        int blocoLinha = (linha - 1) / 3;
        int blocoColuna = (coluna - 1) / 3;
        return blocoLinha * 3 + blocoColuna + 1; // 1 a 9
    }

    private int getPosicaoDentroBloco(int linha, int coluna) {
        int linhaDentro = (linha - 1) % 3;
        int colunaDentro = (coluna - 1) % 3;
        return linhaDentro * 3 + colunaDentro + 1; // 1 a 9
    }
}

