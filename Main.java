// Import
import java.util.Scanner;
public class Main {
    public static void main(String [] args) {
        System.out.println("Hola mundo");
        System.out.println("bit");
        System.out.println("show");
    }
}

///////////// Validaciones
// Obtiene un numero en un intervalo cerrado de X a Y; (Donde X y Y son numeros posibles)
public static int obtenerIntDel(int limiteInferior, int limiteSuperior) {
    String stringNumero="a"; int numeroInt=0;
    do {
        // Intentamos convertir el String a Int; Si lanza una excepcion, no es un Int 
        try {
            stringNumero = scan.nextLine();
            numeroInt = Integer.parseInt(stringNumero);
            // IF; Es un int, pero es menor o mayor que los limites dados
            if (numeroInt < limiteInferior || numeroInt > limiteSuperior) {
                System.out.print("\t\t [!] Favor de ingresar una opcion valida: ");
            }
        }catch(Exception e) {
            System.out.print("\t\t [!] Favor de ingresar una opcion valida: ");
        }
    }while(numeroInt < limiteInferior || numeroInt > limiteSuperior);
    return numeroInt;
}

// Solicitamos un numero Entero cualquiera; Utiliza el metodo esNumero(String)
public static int obtenerInt() {
    String stringNumero="a";
    // Escaneamos
    do {
        stringNumero = scan.nextLine();
        if (!esNumero(stringNumero)) {
            System.out.print("\t\t [!] Favor de ingresar una opcion valida: ");
        }
        
    }while(!esNumero(stringNumero));
    // Si es un numero valido, lo convertimos y regresamos
    return Integer.parseInt(stringNumero);

}

// Solicitamos un numero Double cualquiera; Utiliza el metodo esDouble(String)
public static double obtenerDouble() {
    String stringNumero="a";
    // Escaneamos
    do {
        stringNumero = scan.nextLine();
        if (!esDouble(stringNumero)) {
            System.out.print("\t\t [!] Favor de ingresar una opcion valida: ");
        }
        
    }while(!esDouble(stringNumero));
    // Si es un numero valido, lo convertimos y regresamos
    return Double.parseDouble(stringNumero);
}

// Para checar si una cadena String es un numero valido Int; True si una cadena String es un numero; False si no es un numero
public static boolean esNumero(String enteroEnString) {
    // Si es nulo, o esta vacio
    if (enteroEnString == null || enteroEnString.isEmpty()) return false;
    
    // Intentamos convertirlo a numero; Si falla, no es un numero valido
    try {
        Integer.parseInt(enteroEnString);
    } catch(Exception e) {
        return false;
    }
    // Si no falla, es un numero valido
    return true;
}

// Para checar si una cadena String es un numero valido Double; True si una cadena String es un numero; False si no es un numero
public static boolean esDouble(String doubleEnString) {
    // Si es nulo, o esta vacio
            if (doubleEnString == null || doubleEnString.isEmpty()) return false;
            
            // Intentamos convertirlo a numero; Si falla, no es un numero valido
            try {
                Double.parseDouble(doubleEnString);
            } catch(Exception e) {
                return false;
            }
            // Si no falla, es un numero valido
            return true;
}

/////// Pruebas de Bondad de Ajuste (distribución uniforme)

public static void jiCuadrada(){

}
public static void kolmogorovSmirnov(){

}

/////// Prueba de Aleatoridad (independencia)
public static void series(){

}
public static void distancias(){

}

 