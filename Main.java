import java.util.Scanner;
/*
 * El programa actual es capaz de leer un archivo con valores normalizados y determinar si la serie de valores 
corresponde a una distribución uniforme (Prueba de Uniformidad). Además de determinar si los números no están correlacionados (Prueba de Aleatoridad).
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args) {
        pantallaDeInicio(); // Imprimir pantalla de inicio

        // Pedir archivo en el que se van a dar los datos
        System.out.print("- Archivo de datos: > ");
        String archivo = sc.nextLine();
        
        // Imprimir menú
        imprimirMenu();

        // Matriz temporal
        double[] array = {
            0.0619, 0.0824, 0.0856, 0.0994, 0.125, 0.1294, 0.1487, 0.1573, 0.1599, 0.1627,
            0.1658, 0.1676, 0.24, 0.2594, 0.2661, 0.2737, 0.274, 0.3109, 0.3263, 0.3276, 0.3321,
            0.3358, 0.3492, 0.3629, 0.3632, 0.3867, 0.3899, 0.3975, 0.4103, 0.416, 0.44, 
            0.4522, 0.4802, 0.4875, 0.4916, 0.4927, 0.5319, 0.5645, 0.5697, 0.6355, 0.6776, 
            0.6831, 0.6963, 0.7215, 0.7564, 0.7604, 0.7652, 0.7821, 0.7901, 0.8017, 0.8049, 
            0.8086, 0.8097, 0.8135, 0.8413, 0.8767, 0.8972, 0.9297, 0.9476, 0.9563, 0.9609, 
            0.9862, 0.9909, 0.9928
        };

        // Comienza lo necesari para el menú
        int opcion;
        do { // Ciclo del menú
            System.out.print("- Ingrese su opción: > ");
            opcion = obtenerIntDel(1, 5);

            // Switch
            switch (opcion) {
                case 1:
                    System.out.println("Bienveids a chi cuadrada"); // Chi por chi
                    break;

                case 2:
                    System.out.println("bienvendiso al imalaya xddd");
                    break;

                case 3:
                    System.out.println("no me acuerdo ayayay");
                    break;

                case 4:
                    System.out.println("hello motto");
                    break;
                
                case 5:
                    System.out.println("Adiós papure :\"v");
                    break;

                default:
                    System.out.println("Ocurrió un error inesperado ayayaya que hiciste");
                    break;
            }
        } while (opcion != 5);
    }

    /**
     * Imprime una pantalla de inicio con datos de la escuela, grupo, materia, integrantes, etc.
     */
    public static void pantallaDeInicio() {
        // Datos de la escuela
        System.out.println("=================================================================");
        System.out.println("              Instituto Tecnológico de Culiacán");
        System.out.println("               Ing en Sistemas Computacionales");

        // Datos del alumno
        System.out.println("Pruebas para muestras de números aleatorios");
        System.out.println("De 12:00 a 13:00 horas");

        // Integrantes del equipo
        System.out.println("\n> Bojórquez Chávez Yamil Santiago");
        System.out.println("> Figueroa Lizárraga Edy Jared");
        System.out.println("> Samano Machado Alexis");
        System.out.println("> Santiago Contreras Isaac Abdiel");

        // Descripción de la tarea
        System.out.println("\nTODO");
        System.out.println("=================================================================");
    }

    /**
     * Imprimir las opciones que imprime el menú.
     */
    public static void imprimirMenu() {
        System.out.println("=================================================================");
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("\t[1] Prueba Ji Cuadrada");
        System.out.println("\t[2] Prueba Kolmogorov-Smirnov");
        System.out.println("\t[3] Prueba de las series");
        System.out.println("\t[4] Prueba de las distancias");
        System.out.println("\t[5] Fin\n");
    }

    ///////////// Validaciones

    /**
     * Valida un {@code int} que siempre está dentro del límite especificado.
     * @param limiteInferior Mínimo de la opción.
     * @param limiteSuperior Máximo de la opción.
     * @return Regresa el {@code int} que se obtuvo con la validación.
     */
    public static int obtenerIntDel(int limiteInferior, int limiteSuperior) {
        String stringNumero="a"; int numeroInt=0;
        do {
            // Intentamos convertir el String a Int; Si lanza una excepcion, no es un Int 
            try {
                stringNumero = sc.nextLine();
                numeroInt = Integer.parseInt(stringNumero);
                // IF; Es un int, pero es menor o mayor que los limites dados
                if (numeroInt < limiteInferior || numeroInt > limiteSuperior) {
                    System.out.print("- [!] Favor de ingresar una opcion valida: > ");
                }
            }catch(Exception e) {
                System.out.print("- [!] Favor de ingresar una opcion valida: > ");
            }
        }while(numeroInt < limiteInferior || numeroInt > limiteSuperior);
        return numeroInt;
    }

    /**
     * Valida un {@code int} cualquiera.
     * @return Regresa un {@code int} validado.
     */
    public static int obtenerInt() {
        String stringNumero="a";
        // Esceamos
        do {
            stringNumero = sc.nextLine();
            if (!esNumero(stringNumero)) {
                System.out.print("- [!] Favor de ingresar una opcion valida: > ");
            }
            
        }while(!esNumero(stringNumero));
        // Si es un numero valido, lo convertimos y regresamos
        return Integer.parseInt(stringNumero);

    }

    /**
     * Valida un {@code double} cualquiera
     * @return Regresa un {@code double} validado.
     */
    public static double obtenerDouble() {
        String stringNumero="a";
        // Esceamos
        do {
            stringNumero = sc.nextLine();
            if (!esDouble(stringNumero)) {
                System.out.print("- [!] Favor de ingresar una opcion valida: > ");
            }
            
        }while(!esDouble(stringNumero));
        // Si es un numero valido, lo convertimos y regresamos
        return Double.parseDouble(stringNumero);
    }

    /**
     * Indica si un {@code String} puede ser utilizado como un {@code int}.
     * @param enteroEnString El {@code String} que se desea consultar.
     * @return Un {@code boolean} que dice si el número se puede usar como {@code int}
     */
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

    /**
     * Indica si un {@code String} puede ser utilizado como un {@code double}.
     * @param enteroEnString El {@code String} que se desea consultar.
     * @return Un {@code boolean} que dice si el número se puede usar como {@code double}
     */
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

    public static void jiCuadrada(double[] array){

    }
    public static void kolmogorovSmirnov(double[] array){

    }

    /////// Prueba de Aleatoridad (independencia)
    public static void series(double[] array){

    }
    public static void distancias(double[] array){

    }
}

 