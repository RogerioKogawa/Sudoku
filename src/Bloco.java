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
        try{
            ValidarNumero.validarValor(numero,this);
            ValidarNumero.validarValor(posicaoNumero,this);
            if(posicaoNumerosIniciais.containsKey(numero)) return false;
            posicaoNumeros.put(posicaoNumero, numero);
            return true;
        }catch(NumeroInvalidoException e){
            System.out.println(e.getMessage());
            return false;
        }
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

    public int getId(){
        return this.id;
    }

    public List<Integer> getSubLinhaGlobal(int numeroLinha) {
        List<Integer> subLinhaGlobal = new ArrayList<>();

        for (int posicao = 1; posicao <= 9; posicao++) {
            PosicaoBloco pb = PosicaoBloco.getByPosicaoBloco(this.id, posicao);
            if (pb.getLinhaGlobal() == numeroLinha) {
                subLinhaGlobal.add(posicaoNumeros.getOrDefault(posicao, null));
            }
        }

        return subLinhaGlobal;
    }

    public List<Integer> getSubColunaGlobal(int numeroColuna) {
        List<Integer> subColunaGlobal = new ArrayList<>();

        for (int posicao = 1; posicao <= 9; posicao++) {
            PosicaoBloco pb = PosicaoBloco.getByPosicaoBloco(this.id, posicao);
            if (pb.getColunaGlobal() == numeroColuna) {
                subColunaGlobal.add(posicaoNumeros.getOrDefault(posicao, null));
            }
        }

        return subColunaGlobal;
    }


    public boolean isNull(){
        return posicaoNumeros.isEmpty();
    }

}
