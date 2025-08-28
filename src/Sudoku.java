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

    public boolean adicionarNumero(int idBloco, int numero, int posicaoNumero){
        try {
            ValidarPosicaoNumero.validarPosicaoInserir(numero,
                                                sudoku.get(idBloco),
                                                getLinhasGlobais((posicaoNumero - 1)/3 + 1),
                                                getColunasGlobais((posicaoNumero - 1) % 3 + 1));
            sudoku.get(idBloco).adicionarNumero(numero, posicaoNumero);
            criarLinhasGlobais();
            criarColunasGlobais();
            return true;
        }catch(PosicaoInvalidaException | NumeroInvalidoException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removerNumero(int idBloco, int posicaoNumero){
        if(sudoku.get(idBloco).getPosicaoNumerosIniciais().containsKey(posicaoNumero)){
            System.out.println("Não é possível remover um número inicial");
            return false;
        }else{
            try{
                ValidarPosicaoNumero.validarPosicaoRemover(posicaoNumero, sudoku.get(idBloco));
                return true;
            }catch (PosicaoInvalidaException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
    public void criarLinhasGlobais() {
        Map<Integer, List<Integer>> linhasGlobais = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            linhasGlobais.put(i, Stream.of(sudoku.get(1).getSubLinhaGlobal(i),
                                           sudoku.get(2).getSubLinhaGlobal(i),
                                           sudoku.get(3).getSubLinhaGlobal(i))
                                           .flatMap(List::stream)
                                           .collect(Collectors.toList()));
            linhasGlobais.put(i + 3, Stream.of(sudoku.get(4).getSubLinhaGlobal(i + 3),
                                               sudoku.get(5).getSubLinhaGlobal(i+ 3),
                                               sudoku.get(6).getSubLinhaGlobal(i+ 3))
                                               .flatMap(List::stream)
                                               .collect(Collectors.toList()));
            linhasGlobais.put(i + 6, Stream.of(sudoku.get(7).getSubLinhaGlobal(i + 6),
                                               sudoku.get(8).getSubLinhaGlobal(i + 6),
                                               sudoku.get(9).getSubLinhaGlobal(i + 6))
                                               .flatMap(List::stream)
                                               .collect(Collectors.toList()));
        }

        this.linhasGlobais = linhasGlobais;
    }
    public void criarColunasGlobais(){
        Map<Integer, List<Integer>> colunasGlobais = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            colunasGlobais.put(i, Stream.of(sudoku.get(1).getSubColunaGlobal(i),
                                            sudoku.get(2).getSubColunaGlobal(i),
                                            sudoku.get(3).getSubColunaGlobal(i))
                                            .flatMap(List::stream)
                                            .collect(Collectors.toList()));
            colunasGlobais.put(i + 3, Stream.of(sudoku.get(4).getSubColunaGlobal(i + 3),
                                                sudoku.get(5).getSubColunaGlobal(i+ 3),
                                                sudoku.get(6).getSubColunaGlobal(i+ 3))
                                                .flatMap(List::stream)
                                                .collect(Collectors.toList()));
            colunasGlobais.put(i + 6, Stream.of(sudoku.get(7).getSubColunaGlobal(i + 6),
                                                sudoku.get(8).getSubColunaGlobal(i + 6),
                                                sudoku.get(9).getSubColunaGlobal(i + 6))
                                                .flatMap(List::stream)
                                                .collect(Collectors.toList()));
        }

        this.colunasGlobais = colunasGlobais;
    }

    public  List<Integer> getLinhasGlobais(int numeroLinha){
        return linhasGlobais.getOrDefault(numeroLinha, null);
    }
    public  List<Integer> getColunasGlobais(int numeroColuna){
        return colunasGlobais.getOrDefault(numeroColuna, null);
    }
}
