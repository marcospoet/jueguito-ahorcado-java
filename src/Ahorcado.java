import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        
        
        String palabraSecreta = "spring";
        int intentosMaximos = 5;
        int intentos = 0;
        boolean adivino = false;
        char[] palabraGuiones = new char[palabraSecreta.length()]; // ['_', '_', '_', '_', '_', '_'], creo un array de guiones con la longitud de la palabra secreta
    
        for (int i = 0; i < palabraGuiones.length; i++) {
            palabraGuiones[i] = '_';
        }
        


        while(!adivino && intentos <intentosMaximos){
            System.out.println("Adivina la palabra secreta: ");
            for (char c : palabraGuiones) {
                System.out.print(c + " ");
            }
            System.out.println("\nIngresa una letra: ");
            char letra = teclado.next().charAt(0);
            
            if(palabraSecreta.indexOf(letra) == -1){
                intentos++;
                System.out.println("Letra incorrecta, intentos restantes: " + (intentosMaximos - intentos));
            }
            else{
            
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if(palabraSecreta.charAt(i) == letra){
                        palabraGuiones[i] = letra;
                    }
                }
            }
            if(palabraSecreta.equals(String.valueOf(palabraGuiones))){
                adivino = true;
                System.out.println("Felicidades, adivinaste la palabra secreta: " + palabraSecreta);
            }            
        }

        teclado.close(); // hay que cerrar el scanner para liberar recursos
    }
}