import java.util.List;

public class ValidarPosicaoNumero {

    public static String validarPosicaoInserir(int numero, Bloco bloco, List<Integer> linhaGlobal, List<Integer> colunaGlobal) throws PosicaoInvalidaException{
        if((!(bloco.isNull()) && bloco.getPosicaoNumeros().containsKey(numero)) || linhaGlobal.contains(numero) || colunaGlobal.contains(numero) || bloco.getPosicaoNumerosIniciais().containsValue(numero)){
            throw new PosicaoInvalidaException("Posição inválida");
        }else{
            return "Posição válida";
        }
    }

    public static String validarPosicaoRemover(int posicaoNumero, Bloco bloco) throws PosicaoInvalidaException {
        if (bloco.isNull() || !(bloco.getPosicaoNumerosIniciais().containsKey(posicaoNumero))) {
            throw new PosicaoInvalidaException("Posição não ocupada");
        } else {
            return "Posição válida";
        }
    }
}
