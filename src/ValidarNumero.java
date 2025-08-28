public class ValidarNumero{
    public  static String validarValor(int numero, Bloco bloco)throws NumeroInvalidoException{
        if(numero <= 0 || numero > 9){
            throw new NumeroInvalidoException("Número inválido, escolha um numero entre 1 e 9");
        }else{
            if(bloco.getPosicaoNumerosIniciais().containsKey(numero)) throw new NumeroInvalidoException("Não é possível modificar um número inicial");
            return "Número válido";
        }
    }
}
