package estacio;

public class Principal { 
    public static void main ( String args [ ] ) { 

        //Vetores de caracteres
        char[] arr1 = { 'J' , 'A' , 'V' , 'A' , '.' }; //Vetor de caracteres é criado
        char[] arr2 = new char [4]; 

        System.out.println(copiarArray(arr1, arr2));//Chama o método "copiarArray()" que recebe as duas arrays de caracteres  como parâmetro
    }
    
    
    private static char[] copiarArray ( char[] arr1 , char[] arr2 ) { //Copia o vetor arr1 para arr2 

        try { 
            if ( verificarOperandos (arr1, arr2) && verificarTamanhoOperandos (arr1, arr2) ) {  //Chama os dois métodos para fazer a verificação
                System.arraycopy ( arr1 , 0 , arr2 , 0 , arr1.length ); //Faz uma cópia das arrays com posição 0, "arr1.length" é o número de elementos que vão ser copiados, que é o tamanho total de "arr1"
                return arr2; 
            } else { //Se as verificações falharem (ou seja, se os arrays forem inválidos ou de tamanhos diferentes), o método não realiza a cópia e imprime uma mensagem de erro no console.
                System.out.println( "A operacao nao pode ser realizada!" ); 
            }


        } catch (NullPointerException erro) { //Faz o tratamento de erro se for do tipo "NullPointerException"
            System.out.println ( "Ponteiro para objeto nulo!" ); 
            System.out.println ( erro.getMessage() ); 
            System.exit ( -1 ); //Termina a execução do programa após exibir as mensagens acima

        } catch (ArrayIndexOutOfBoundsException erro) { //Faz o tratamento de erro se for do tipo acesso à posição de arrays inexistente
            System.out.println ( "Tentativa de extrapolar o limite do vetor!" ); 
            System.out.println (erro.getMessage()); 
            System.exit ( -1 ); //Termina a execução do programa após exibir as mensagens acima
        } 
        return null; 
    } 



    private static boolean verificarOperandos ( char[] arr1 , char[] arr2 ) throws ErroOperando, NullPointerException { //"throws" está declarando que o método "verificarOperandos()" pode lançar uma ou mais Exceptions, no caso "ErroOperando" e "NullPointerException"

        boolean check = false; //Criada a variável local "check" com o valor inicial "false"

        if ( ( arr1 == null ) && ( arr2 == null ) ) 
            throw new ErroOperando ( "Ambos operandos sao nulos!" ); //Joga um novo erro personalizado se os dois arrays de caracteres forem nulos
        else if ( arr1 == null ) 
            throw new ErroOperando ( "Primeiro operando eh nulo!" ); //Joga um novo erro personalizado se o array 1 de caracteres for nulo
        else if ( arr2 == null ) 
            throw new ErroOperando ( "Segundo operando eh nulo!" ); //Joga um novo erro personalizado se o array 2 de caracteres for nulo
        else 
            check = true; 

        return check; //Retorna o valor atual de check
    } 



    private static boolean verificarTamanhoOperandos (char[] arr1, char[] arr2) { //Método booleano que recebe como parâmetro o array 1 e 2 do tipo char[]

        if ( arr1.length > arr2.length ) {  //Verifica o tamanho o tamanho da array 1 é maior que o array 2
            System.out.println ( "Os tamanhos dos vetores são incompativeis! "); 
            throw new ErroOperando ( new ArrayIndexOutOfBoundsException ( "ESPACO INSUFICIENTE NO SEGUNDO OPERANDO!" ) ); 
        } else     
            return true; 
    } 
}