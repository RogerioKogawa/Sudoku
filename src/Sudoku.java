import java.util.*;
import java.util.stream.*;

public class Sudoku{
    Bloco bloco1;
    Bloco bloco2;
    Bloco bloco3;
    Bloco bloco4;
    Bloco bloco5;
    Bloco bloco6;
    Bloco bloco7;
    Bloco bloco8;
    Bloco bloco9;
    Map<Integer, Bloco> sudoku = new HashMap<>();
    private Map<Integer, List<Integer>> linhasGlobais;
    private Map<Integer, List<Integer>> colunasGlobais;
    public Sudoku(Bloco bloco1, Bloco bloco2, Bloco bloco3, Bloco bloco4, Bloco bloco5, Bloco bloco6, Bloco bloco7, Bloco bloco8, Bloco bloco9) {
        this.bloco1 = bloco1;
        this.bloco2 = bloco2;
        this.bloco3 = bloco3;
        this.bloco4 = bloco4;
        this.bloco5 = bloco5;
        this.bloco6 = bloco6;
        this.bloco7 = bloco7;
        this.bloco8 = bloco8;
        this.bloco9 = bloco9;
        mapearBlocos();
        criarColunasGlobais();
        criarLinhasGlobais();
    }
    public void mapearBlocos(){
        sudoku.put(1, bloco1);
        sudoku.put(2, bloco2);
        sudoku.put(3, bloco3);
        sudoku.put(4, bloco4);
        sudoku.put(5, bloco5);
        sudoku.put(6, bloco6);
        sudoku.put(7, bloco7);
        sudoku.put(8, bloco8);
        sudoku.put(9, bloco9);
    }

    public boolean adicionarNumero(int idBloco, int numero, int posicaoNumero) {
        try {
            //Valida se o valor esta entre 1 e 9;
            ValidarNumero.validarValor(numero, sudoku.get(idBloco));
            ValidarNumero.validarValor(posicaoNumero, sudoku.get(idBloco));
            // Obtém a posição do enum para esse bloco e posição
            PosicaoBloco posicao = PosicaoBloco.getByPosicaoBloco(idBloco, posicaoNumero);

            // Recupera a linha global e coluna global
            int linhaGlobal = posicao.getLinhaGlobal();
            int colunaGlobal = posicao.getColunaGlobal();

            // Pega os valores atuais da linha e coluna global
            List<Integer> valoresLinha = getLinhasGlobais(linhaGlobal);
            List<Integer> valoresColuna = getColunasGlobais(colunaGlobal);

            // Valida se é possível inserir
            ValidarPosicaoNumero.validarPosicaoInserir(numero, sudoku.get(idBloco), valoresLinha, valoresColuna);

            // Insere o número
            sudoku.get(idBloco).adicionarNumero(numero, posicaoNumero);

            // Atualiza as linhas e colunas globais
            criarLinhasGlobais();
            criarColunasGlobais();

            return true;
        } catch (PosicaoInvalidaException | NumeroInvalidoException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean removerNumero(int idBloco, int posicaoNumero) {
        PosicaoBloco posicao = PosicaoBloco.getByPosicaoBloco(idBloco, posicaoNumero);

        Bloco bloco = sudoku.get(idBloco);

        if (bloco.getPosicaoNumerosIniciais().containsKey(posicaoNumero)) {
            System.out.println("Não é possível remover um número inicial");
            return false;
        } else {
            try {
                ValidarPosicaoNumero.validarPosicaoRemover(posicaoNumero, bloco);
                bloco.getPosicaoNumeros().remove(posicaoNumero);
                criarLinhasGlobais();
                criarColunasGlobais();
                return true;
            } catch (PosicaoInvalidaException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }

    public void criarLinhasGlobais() {
        linhasGlobais = new HashMap<>();
        // percorre todas as posições do enum
        for (PosicaoBloco pb : PosicaoBloco.values()) {
            int linhaGlobal = pb.getLinhaGlobal();
            linhasGlobais.computeIfAbsent(linhaGlobal, k -> new ArrayList<>())
                    .add(sudoku.get(pb.getIdBloco()).getPosicaoNumeros()
                            .getOrDefault(pb.getPosicao(), null));
        }
    }

    public void criarColunasGlobais() {
        colunasGlobais = new HashMap<>();
        // percorre todas as posições do enum
        for (PosicaoBloco pb : PosicaoBloco.values()) {
            int colunaGlobal = pb.getColunaGlobal();
            colunasGlobais.computeIfAbsent(colunaGlobal, k -> new ArrayList<>())
                    .add(sudoku.get(pb.getIdBloco()).getPosicaoNumeros()
                            .getOrDefault(pb.getPosicao(), null));
        }
    }

    public  List<Integer> getLinhasGlobais(int numeroLinha){
        return linhasGlobais.getOrDefault(numeroLinha, null);
    }
    public  List<Integer> getColunasGlobais(int numeroColuna){
        return colunasGlobais.getOrDefault(numeroColuna, null);
    }

    public Bloco getBloco(int idBloco) {
        return sudoku.get(idBloco);
    }
}
