import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args) {
        System.out.print("- Archivo de datos: > ");
        String archivo = sc.nextLine();
        
        // Imprimir menú
        imprimirMenu();

        int opcion;
        do {
            System.out.print("- Ingrese su opción: > ");
            opcion = sc.nextInt();
        } while (opcion != 5);
    }

    /**
     * Imprimir las opciones que imprime el menú.
     */
    public static void imprimirMenu() {
        System.out.println("\t[1] Prueba xi2");
        System.out.println("\t[2] Prueba Kolmogorov-Smirnov");
        System.out.println("\t[3] Prueba de las series");
        System.out.println("\t[4] Prueba de las distancias");
        System.out.println("\t[5] Fin");
    }

    ///////////// Validaciones
    // Obtiene un numero en un intervalo cerrado de X a Y; (Donde X y Y son numeros posibles)
    public static int obtenerIntDel(int limiteInferior, int limiteSuperior) {
        String stringNumero="a"; int numeroInt=0;
        do {
            // Intentamos convertir el String a Int; Si lanza una excepcion, no es un Int 
            try {
                stringNumero = sc.nextLine();
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
        // Esceamos
        do {
            stringNumero = sc.nextLine();
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
        // Esceamos
        do {
            stringNumero = sc.nextLine();
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
}

 