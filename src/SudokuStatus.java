import java.util.*;

public class SudokuStatus {

    private Map<Integer, List<Integer>> posicaoNumeros;
    Sudoku sudoku;
    public SudokuStatus(Sudoku sudoku){
        this.sudoku = sudoku;
    }
    public  String Status(){
        boolean status = false;
        for(int i = 1; i <= 9; i++){
            if(sudoku.getBloco(i).getPosicaoNumeros().size() < 9){
                status = false;
            }else{
                status = true;
            }
        }
        return status ? "Jogo completo" : "Jogo incompleto";
    }
}
