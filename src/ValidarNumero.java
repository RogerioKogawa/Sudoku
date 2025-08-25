public class ValidarNumero{
    public  String validar(int numero)throws NumeroInvalidoException{
        if(numero <= 0 || numero > 9){
            throw new NumeroInvalidoException("Número inválido, escolha um numero entre 1 e 9");
        }else{
            return "Número válido";
        }
    }
}
