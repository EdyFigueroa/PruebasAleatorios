package PruebasAleatorios;
import java.io.File;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args) {
        pantallaDeInicio(); // Imprimir pantalla de inicio

        // Pedir archivo en el que se van a dar los datos
        System.out.print("- Archivo de datos: > ");
        //String archivo = obtenerRuta(); // PONER AL TERMINAR
        System.out.print("datos.txt\n"); // QUITAR AL TERMINAR
        String archivo = "datos.txt"; // QUITAR AL TERMINAR

        double[] array = (new LeerDatos(archivo)).leerArchivo();

        // Comienza lo necesari para el menú
        int opcion;
        do { // Ciclo del menú
            // Imprimir menú
            imprimirMenu();

            // Solicitamos la opción al usuario
            System.out.print("- Ingrese su opción: > ");
            opcion = obtenerIntDel(1, 5);

            // Switch
            switch (opcion) {
                case 1:
                    System.out.println("¿Vas a chillar?"); // Chi por chi
                    ChiCuadrada chi = new ChiCuadrada(array); // Creamos una clase para chi Cuadrada
                    chi.calcular(); // Calculamos
                    
                    // TERMINACION; Finaliza el método y se espera al usuario
					System.out.println("\n\n\t\tPresiona enter  para continuar...");
					sc.nextLine(); 
                    break;

                case 2:
                    System.out.println("bienvendiso al imalaya xddd");
                    KolmogorovSmirnov esElKolmo = new KolmogorovSmirnov(array); // Creamos una clase para chi Cuadrada
                    esElKolmo.calcular(); // Calculamos


                    // TERMINACION; Finaliza el método y se espera al usuario
					System.out.println("\n\n\t\tPresiona enter para continuar...");
					sc.nextLine(); 
                    break;

                case 3:
                    System.out.println("no me acuerdo ayayay");
                    PruebaSeries pruebaSeries = new PruebaSeries(array);
                    pruebaSeries.calcular();

                    // TERMINACION; Finaliza el método y se espera al usuario
					System.out.println("\n\n\t\tPresiona enter para continuar...");
					sc.nextLine(); 
                    break;

                case 4:
                    System.out.println("hello motto");

                    System.out.print("- Alpha: > ");
                    double alpha = obtenerDouble();

                    System.out.print("- Tetha: > ");
                    double tetha = obtenerDouble();

                    System.out.print("- Grados de libertad: > ");
                    int gradosLibertad = obtenerInt();

                    System.out.print("- Error de chi cuadrada: > ");
                    double error = obtenerDouble();

                    PruebaDistancias pruebaDistancias = new PruebaDistancias(array, alpha, tetha, error, gradosLibertad);
                    pruebaDistancias.calcular();

                    // TERMINACION; Finaliza el método y se espera al usuario
					System.out.println("\n\n\t\tPresiona enter continuar...");
					sc.nextLine(); 
                    break;
                
                case 5:
                    System.out.println("Adiós papure :\"v");
					sc.nextLine(); 
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
        System.out.println("\n           El programa actual es capaz de leer un archivo con valores \r\n" + //
                             "          normalizados y determinar si la serie de valores corresponde \r\n" + //
                             "         a una distribución uniforme (Prueba de Uniformidad). Además de \r\n" + //
                             "     determinar si los números no están correlacionados (Prueba de Aleatoridad).");
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
     * Le pide al usuario una ruta de un archivo que exista y que no sea un directorio.
     * @return La ruta en {@code String} segura.
     */
    public static String obtenerRuta() {
        String ruta = "";
        do {
            ruta = sc.nextLine();
            if (!esRuta(ruta)) {
                System.out.print("- [!] Favor de ingresar una ruta válida: > ");
            }
        } while (!esRuta(ruta));
        return ruta;
    }
    
    /**
     * Verifica que una ruta sea un archivo válido.
     * @param ruta La ruta al archivo en forma de {@code String}.
     * @return Un {@code boolean} que dice si es una ruta válida.
     */
    public static boolean esRuta(String ruta) {
        File file = new File(ruta);
        return file.exists() && !file.isDirectory();
    }

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

}

 