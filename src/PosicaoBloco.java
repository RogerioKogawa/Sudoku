public enum PosicaoBloco {
    // Bloco 1 (linhas 1–3, colunas 1–3)
    B1P1(1, 1, 1, 1),
    B1P2(1, 2, 1, 2),
    B1P3(1, 3, 1, 3),
    B1P4(1, 4, 2, 1),
    B1P5(1, 5, 2, 2),
    B1P6(1, 6, 2, 3),
    B1P7(1, 7, 3, 1),
    B1P8(1, 8, 3, 2),
    B1P9(1, 9, 3, 3),

    // Bloco 2 (linhas 1–3, colunas 4–6)
    B2P1(2, 1, 1, 4),
    B2P2(2, 2, 1, 5),
    B2P3(2, 3, 1, 6),
    B2P4(2, 4, 2, 4),
    B2P5(2, 5, 2, 5),
    B2P6(2, 6, 2, 6),
    B2P7(2, 7, 3, 4),
    B2P8(2, 8, 3, 5),
    B2P9(2, 9, 3, 6),

    // Bloco 3 (linhas 1–3, colunas 7–9)
    B3P1(3, 1, 1, 7),
    B3P2(3, 2, 1, 8),
    B3P3(3, 3, 1, 9),
    B3P4(3, 4, 2, 7),
    B3P5(3, 5, 2, 8),
    B3P6(3, 6, 2, 9),
    B3P7(3, 7, 3, 7),
    B3P8(3, 8, 3, 8),
    B3P9(3, 9, 3, 9),

    // Bloco 4 (linhas 4–6, colunas 1–3)
    B4P1(4, 1, 4, 1),
    B4P2(4, 2, 4, 2),
    B4P3(4, 3, 4, 3),
    B4P4(4, 4, 5, 1),
    B4P5(4, 5, 5, 2),
    B4P6(4, 6, 5, 3),
    B4P7(4, 7, 6, 1),
    B4P8(4, 8, 6, 2),
    B4P9(4, 9, 6, 3),

    // Bloco 5 (linhas 4–6, colunas 4–6)
    B5P1(5, 1, 4, 4),
    B5P2(5, 2, 4, 5),
    B5P3(5, 3, 4, 6),
    B5P4(5, 4, 5, 4),
    B5P5(5, 5, 5, 5),
    B5P6(5, 6, 5, 6),
    B5P7(5, 7, 6, 4),
    B5P8(5, 8, 6, 5),
    B5P9(5, 9, 6, 6),

    // Bloco 6 (linhas 4–6, colunas 7–9)
    B6P1(6, 1, 4, 7),
    B6P2(6, 2, 4, 8),
    B6P3(6, 3, 4, 9),
    B6P4(6, 4, 5, 7),
    B6P5(6, 5, 5, 8),
    B6P6(6, 6, 5, 9),
    B6P7(6, 7, 6, 7),
    B6P8(6, 8, 6, 8),
    B6P9(6, 9, 6, 9),

    // Bloco 7 (linhas 7–9, colunas 1–3)
    B7P1(7, 1, 7, 1),
    B7P2(7, 2, 7, 2),
    B7P3(7, 3, 7, 3),
    B7P4(7, 4, 8, 1),
    B7P5(7, 5, 8, 2),
    B7P6(7, 6, 8, 3),
    B7P7(7, 7, 9, 1),
    B7P8(7, 8, 9, 2),
    B7P9(7, 9, 9, 3),

    // Bloco 8 (linhas 7–9, colunas 4–6)
    B8P1(8, 1, 7, 4),
    B8P2(8, 2, 7, 5),
    B8P3(8, 3, 7, 6),
    B8P4(8, 4, 8, 4),
    B8P5(8, 5, 8, 5),
    B8P6(8, 6, 8, 6),
    B8P7(8, 7, 9, 4),
    B8P8(8, 8, 9, 5),
    B8P9(8, 9, 9, 6),

    // Bloco 9 (linhas 7–9, colunas 7–9)
    B9P1(9, 1, 7, 7),
    B9P2(9, 2, 7, 8),
    B9P3(9, 3, 7, 9),
    B9P4(9, 4, 8, 7),
    B9P5(9, 5, 8, 8),
    B9P6(9, 6, 8, 9),
    B9P7(9, 7, 9, 7),
    B9P8(9, 8, 9, 8),
    B9P9(9, 9, 9, 9);




    private final int idBloco;
    private final int posicao;
    private final int linhaGlobal;
    private final int colunaGlobal;

    PosicaoBloco(int idBloco, int posicao, int linhaGlobal, int colunaGlobal) {
        this.idBloco = idBloco;
        this.posicao = posicao;
        this.linhaGlobal = linhaGlobal;
        this.colunaGlobal = colunaGlobal;
    }

    public int getIdBloco() {
        return idBloco;
    }

    public int getPosicao() {
        return posicao;
    }

    public int getLinhaGlobal() {
        return linhaGlobal;
    }

    public int getColunaGlobal() {
        return colunaGlobal;
    }


    public static PosicaoBloco getByPosicaoBloco(int idBloco, int posicao) {
        for (PosicaoBloco c : values()) {
            if (c.idBloco == idBloco && c.posicao == posicao) {
                return c;
            }
        }
        throw new IllegalArgumentException("Bloco " + idBloco + " posição " + posicao + " inválida");
    }
}
