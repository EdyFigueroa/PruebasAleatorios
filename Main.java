import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.math3.*; // Librería para obtener el valor crítico

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args) {
        pantallaDeInicio(); // Imprimir pantalla de inicio

        // Pedir archivo en el que se van a dar los datos
        System.out.print("- Archivo de datos: > ");
        String archivo = sc.nextLine();
        
        

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
            // Imprimir menú
            imprimirMenu();

            // Solicitamos la opción al usuario
            System.out.print("- Ingrese su opción: > ");
            opcion = obtenerIntDel(1, 5);

            // Switch
            switch (opcion) {
                case 1:
                    System.out.println("Bienveids a chi cuadrada"); // Chi por chi

                    jiCuadrada(array);
                    // TERMINACION; Finaliza el método y se espera al usuario
					System.out.println("\n\n\t\tPresiona cualquier cosa para continuar...");
					sc.nextLine(); 
                    break;

                case 2:
                    System.out.println("bienvendiso al imalaya xddd");
                    /*ArrayList<ArrayList<Double>> listab = new ArrayList<ArrayList<Double>>();

                    ArrayList<Double> lista = new ArrayList<Double>();
                    lista.add(1.0); lista.add(2.0); lista.add(3.0);lista.add(4.0);

                    listab.add(lista);
                    System.out.println(listab);
                    */
                    jiCuadrada(array);


                    // TERMINACION; Finaliza el método y se espera al usuario
					System.out.println("\n\n\t\tPresiona cualquier cosa para continuar...");
					sc.nextLine(); 
                    break;

                case 3:
                    System.out.println("no me acuerdo ayayay");

                    // TERMINACION; Finaliza el método y se espera al usuario
					System.out.println("\n\n\t\tPresiona cualquier cosa para continuar...");
					sc.nextLine(); 
                    break;

                case 4:
                    System.out.println("hello motto");

                    // TERMINACION; Finaliza el método y se espera al usuario
					System.out.println("\n\n\t\tPresiona cualquier cosa para continuar...");
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

    /**
     * Realiza la prueba de bondad 'Chi Cuadrada' a una serie de datos normalizados.
     * @param array Arreglo de valores {@code double}, ya normalizados.
     */
    public static void jiCuadrada(double[] array){
        // Obtenemos el valor de N; Es la cantidad de números de la serie.
        int N = array.length;

        // Si la serie está vacia, acaba el método
        if (N == 0) {
            System.out.println("La serie está vacia."); 
            return;
        }

        else{ // Procedemos
            /// CÁLCULO
            /* Obtenemos k; Son la cantidad de Intervalos
            Es posible que eventualmente 'k' sea un valor con decimales, el cual redondearemos.
            El redondear hacia arriba o hacia abajo tiene efectos distintos en la exactidud de la prueba de bondad.
    
            * Hacia arriba: Puede ser adecuado para una mayor precisión y mayor cantidad de intervalos. Pero si la cantidad de datos por intervalo es muy baja se podrían generar
            intervalos con muy pocos datos, lo que afectaría la validez de la prueba de chi cuadrada.
            * Hacia abajo: es posible que se obtengan menos intervalos de los que se necesitan, lo que puede resultar en intervalos demasiado grandes 
            que no capturan bien la distribución de los datos.
            */
            // Calculamos variables
            int k = (int) Math.round(Math.sqrt(N)); // Número de intervalos
            double Ei = (double) N/k; // Frecuencia esperada en cada intervalo
            double saltoIntervalo = 1.0/k; // Tamaño de cada intervalo; Tamaño de intervalos = rango/k
            double chiCuadrado = 0; // Valor de chi-cuadrado
            int[] O = new int[k]; // Array que almacena las frecuencias observadas
            double[][] limites = new double[k][2]; // [k][0] = Limite Inferior; [k][1] = Limite Superior

            // Creamos los limites de cada intervalo
            double limiteInferior = 0;
            double limiteSuperior = saltoIntervalo;
            
            // Alimentamos los limites
            for (int i=0; i<k; i++){
                // Definimos los limites
                limites[i][0] = limiteInferior;
                limites[i][1] = limiteSuperior;
                // Llenamos el ArrayList con los valores que se encuentran dentro de los limites
                for (double valor : array) { // Para cada valor del Array
                    if (valor > limiteInferior && valor <= limiteSuperior) { // Checamos que este en el intervalo
                        O[i]++; // Actualizamos la cantidad para el intervalo
                    }
                }
                // Actulizamos los limites
                limiteInferior = limiteSuperior;
                limiteSuperior += saltoIntervalo;  
            }

            /// IMPRIMIMOS LA TABLA
            System.out.printf("\t%-10s %-10s %-10s %-10s %-10s\n","i","O","E","O-E","(O-E)^2 / E");
            System.out.println("\t" + "_____".repeat(10));
            for (int i=0; i<k; i++){
                double Oe = O[i] - Ei; // Calculamos O-E                
                double x = (Oe * Oe) /Ei; // Calculamos (O-E)^2 /E
                chiCuadrado += x; // Obtenemos la sumatoria para chi cuadrada
                System.out.printf("\t%-10.4f %-10d %-10.2f %-10.2f %-10.2f\n",limites[i][1],O[i],Ei,Oe,x);
            }
            System.out.println("\t"+ "_____".repeat(10));
            System.out.printf("\t(Xo)^2 : %.4f\n", chiCuadrado);

            /// OBTENER VALOR CRÍTICO
            // Obtener valor crítico de chi-cuadrado para k-1 grados de libertad
            ChiSquaredDistribution chiDist = new ChiSquaredDistribution(k - 1);
            double chiCritico = chiDist.inverseCumulativeProbability(1 - 0.05);
            
            System.out.printf("\tValor crítico de chi-cuadrado (α = %.2f): %.4f\n", 0.05, chiCritico);
        
            if (chiCuadrado < chiCritico) {
                System.out.println("\tSe acepta H0: La distribución es uniforme.");
            } else {
                System.out.println("\tSe rechaza H0: La distribución no es uniforme.");
            }

            

            /// Finalización
            if (N < 30) {System.out.println("- [!] El tamaño de la muestra (N) que está utilizando es relativamente pequeño. La validez puede verse afectada");}
        }

    }
    public static void kolmogorovSmirnov(double[] array){

    }

    /////// Prueba de Aleatoridad (independencia)
    public static void series(double[] array){

    }
    public static void distancias(double[] array){

    }
}

 