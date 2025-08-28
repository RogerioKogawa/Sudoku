import java.util.*;

public class Bloco {
    private int id;
    private Map<Integer, Integer> posicaoNumeros;
    private Map<Integer, Integer> posicaoNumerosIniciais;

    public Bloco(int id, Map<Integer, Integer> posicaoNumerosIniciais){
        this.id = id;
        this.posicaoNumerosIniciais = new HashMap<>(posicaoNumerosIniciais);
        this.posicaoNumeros = new HashMap<>(this.posicaoNumerosIniciais);
    }

    public boolean adicionarNumero(int numero, int posicaoNumero) throws NumeroInvalidoException {
        if(!(ValidarNumero.validar(numero,this).equals("Número valido")) ||
           !(ValidarNumero.validar(posicaoNumero,this).equals("Número valido"))||
           posicaoNumerosIniciais.containsKey(numero)) return false
        posicaoNumeros.put(numero,posicaoNumero);
        return true;
    }

    public Map<Integer, Integer> getPosicaoNumerosIniciais() {
        return posicaoNumerosIniciais;
    }
}
