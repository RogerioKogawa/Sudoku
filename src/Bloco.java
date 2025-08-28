import java.util.*;

public class Bloco {
    private int id;
    //Key = posicao, value = numero na posicao da Key;
    private Map<Integer, Integer> posicaoNumeros;
    private Map<Integer, Integer> posicaoNumerosIniciais;

    public Bloco(){};
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

    public boolean removerNumero(int posicaoNumero){
        if(posicaoNumerosIniciais.containsKey(posicaoNumero)|| !(posicaoNumeros.containsKey(posicaoNumero))) return false;
        posicaoNumeros.remove(posicaoNumero);
        return true;
    }

    public Map<Integer, Integer> getPosicaoNumerosIniciais() {
        return posicaoNumerosIniciais;
    }

    public Map<Integer, Integer> getPosicaoNumeros(){
        return posicaoNumeros;
    }

    public List<Integer> getSubLinhaGlobal(int numeroLinha){
        List<Integer> subLinhaGlobal = new ArrayList<>();
        if(numeroLinha == 1 || numeroLinha == 4 || numeroLinha == 7){
            subLinhaGlobal.add(posicaoNumeros.getOrDefault(1, null));
            subLinhaGlobal.add(posicaoNumeros.getOrDefault(2, null));
            subLinhaGlobal.add(posicaoNumeros.getOrDefault(3, null));
        }
        if(numeroLinha == 2 || numeroLinha == 5 || numeroLinha == 8){
            subLinhaGlobal.add(posicaoNumeros.getOrDefault(4, null));
            subLinhaGlobal.add(posicaoNumeros.getOrDefault(5, null));
            subLinhaGlobal.add(posicaoNumeros.getOrDefault(6, null));
        }
        if(numeroLinha == 3 || numeroLinha == 6 || numeroLinha == 9){
            subLinhaGlobal.add(posicaoNumeros.getOrDefault(7, null));
            subLinhaGlobal.add(posicaoNumeros.getOrDefault(8, null));
            subLinhaGlobal.add(posicaoNumeros.getOrDefault(9, null));
        }
        return subLinhaGlobal;
    }

    public List<Integer> getSubColunaGlobal(int numeroColuna){
        List<Integer> subColunaGlobal = new ArrayList<>();
        if(numeroColuna == 1 || numeroColuna == 4 || numeroColuna == 7){
            subColunaGlobal.add(posicaoNumeros.getOrDefault(1, null));
            subColunaGlobal.add(posicaoNumeros.getOrDefault(4, null));
            subColunaGlobal.add(posicaoNumeros.getOrDefault(7, null));
        }
        if(numeroColuna == 2 || numeroColuna == 5 || numeroColuna == 8){
            subColunaGlobal.add(posicaoNumeros.getOrDefault(2, null));
            subColunaGlobal.add(posicaoNumeros.getOrDefault(5, null));
            subColunaGlobal.add(posicaoNumeros.getOrDefault(8, null));
        }
        if(numeroColuna == 3 || numeroColuna == 6 || numeroColuna == 9){
            subColunaGlobal.add(posicaoNumeros.getOrDefault(3, null));
            subColunaGlobal.add(posicaoNumeros.getOrDefault(6, null));
            subColunaGlobal.add(posicaoNumeros.getOrDefault(9, null));
        }
        return subColunaGlobal;
    }

    public boolean isNull(){
        return posicaoNumeros.isEmpty();
    }

}
