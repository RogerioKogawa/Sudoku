import java.util.*;

public class Bloco {
    private int id;
    //Key = posicao, value = numero na posicao da Key;
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

    public List<Integer> getLinha(int numeroLinha){
        List<Integer> linha = new ArrayList<>();
        if(numeroLinha == 0){
            linha.add(posicaoNumeros.getOrDefault(1, null));
            linha.add(posicaoNumeros.getOrDefault(2, null));
            linha.add(posicaoNumeros.getOrDefault(3, null));
        }
        if(numeroLinha == 1){
            linha.add(posicaoNumeros.getOrDefault(4, null));
            linha.add(posicaoNumeros.getOrDefault(5, null));
            linha.add(posicaoNumeros.getOrDefault(6, null));
        }
        if(numeroLinha == 2){
            linha.add(posicaoNumeros.getOrDefault(7, null));
            linha.add(posicaoNumeros.getOrDefault(8, null));
            linha.add(posicaoNumeros.getOrDefault(9, null));
        }
        return linha;
    }

    public List<Integer> getColuna(int numeroColuna){
        List<Integer> coluna = new ArrayList<>();
        if(numeroColuna == 1){
            coluna.add(posicaoNumeros.getOrDefault(1, null));
            coluna.add(posicaoNumeros.getOrDefault(4, null));
            coluna.add(posicaoNumeros.getOrDefault(7, null));
        }
        if(numeroColuna == 1){
            coluna.add(posicaoNumeros.getOrDefault(2, null));
            coluna.add(posicaoNumeros.getOrDefault(5, null));
            coluna.add(posicaoNumeros.getOrDefault(8, null));
        }
        if(numeroColuna == 1){
            coluna.add(posicaoNumeros.getOrDefault(3, null));
            coluna.add(posicaoNumeros.getOrDefault(6, null));
            coluna.add(posicaoNumeros.getOrDefault(9, null));
        }
    }
}
