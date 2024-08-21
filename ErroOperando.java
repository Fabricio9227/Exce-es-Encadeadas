package estacio;

public class ErroOperando extends NullPointerException { //ErroOperando herda as caracteristicas de NullPointerException mas tem um comportamento específico

    ErroOperando ( String mensagem ) { //Construtor da classe que recebe como parâmetro uma string
        super ( mensagem ); //Aqui, chama o construtor da superclasse NullPointerException e passa a mensagem (String mensagem) para ele
    }     
    ErroOperando (Throwable causa) { //Construtor da classe que recebe um tipo de parâmetro do tipo "Throwable", podendo passar qualquer exceção ou erro como argumento, nesse caso, "causa"
        initCause (causa); //Serve para associar uma exceção que ocorreu anteriormente (causa) com uma nova exceção que está sendo lançada. Isso permite que, ao capturar a exceção mais recente, você ainda possa rastrear a exceção original que levou ao erro, facilitando o diagnóstico
    }

    @Override 
    public String toString ( ) { 
        return "Operando nulo: " + this.getMessage(); 
    } 
} 
