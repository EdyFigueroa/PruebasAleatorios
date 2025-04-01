package PruebasAleatorios;

public class PruebaSeries {
    // Atributos
    protected double[] array;
    // Constructor
    public PruebaSeries(double[] array){
        this.array = array.clone();
    }
    // Métodos
    public void calcular(){
        
        int N = array.length; // Declaramos N para usarlo en fórmulas posteriores, siendo N el tamaño de la muestra
        int n = (int) Math.round(Math.sqrt(N/5.0)); // Declaramos n para usarlo en fórmulas posteriores

        // Formar los datos Ui+1 para tener los datos en pares
        double[] array2 = new double[N];
        for (int i = 0; i < N-1; i++) {
            array2[i] = array[i+1]; 
        }
        array2[N-1] = array[0]; // El último dato se empareja con el primero para que no queden pares solos y tener la misma cantidad de pares que de número de datos

        double Eij = N / Math.pow(n, 2); // Calculamos Eij para fórmulas posteriores

        // Procedemos a calcular Oij (cantidad de pares por celda)
        int[] celdaEnX = new int [N]; 
        int[] celdaEnY = new int [N];
        System.out.println("----------------------------------");
        System.out.println("|   Ui   |  Ui+1  | Celda (i, j) |");
        System.out.println("----------------------------------");
        for (int i = 0; i < N; i++) {
            celdaEnX[i] = (int) Math.floor(array[i] * n) + 1; // Encontramos en qué celda de X se encuentra el primer dato del par
            celdaEnY[i] = (int) Math.floor(array2[i] * n) + 1;// Encontramos en qué celda de Y se encuentra el segundo dato del par
        }
        
        int[] Oij = new int [(int) Math.pow(n, 2)]; // Declaramos un arreglo que para contar los pares dentro de cada celda
        for (int k = 0; k < N; k++) {
            int i = celdaEnX[k];
            int j = celdaEnY[k];

            int posicionCelda = (i - 1) * n + (j - 1); // Calculamos en qué celda está nuestro par
            Oij[posicionCelda]++; // Contamos la celda
            System.out.printf("| %.4f | %.4f |    (%d, %d)    |\n", array[k], array2[k], celdaEnX[k], celdaEnY[k]);
        }
        System.out.println("----------------------------------");

        // Calculamos Xo ^2
        double [] vectorXoCuadrada = new double[Oij.length]; // Declaramos un vector para aplicarle la formula a cada valor del vector celda 
        double xoCuadrada = 0;
        for (int i = 0; i < Oij.length; i++) {
            vectorXoCuadrada[i] = Math.pow(Oij[i]-Eij, 2) / Eij;
            xoCuadrada += vectorXoCuadrada[i]; // Sumamos cada valor del vector XoCuadrada para obtener el resultado
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("| Celda (i, j) | Oij |  Eij  | ((Oij - Eij)^2)/2 |");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < Oij.length; i++) {
            int fila = (i / n) + 1;
            int columna = (i % n) + 1;
            System.out.printf("|    (%d, %d)    | %3d | %5.2f |    %9.2f      |\n", fila, columna, Oij[i], Eij, vectorXoCuadrada[i]);
        }
        System.out.println("--------------------------------------------------");

        System.out.println("\nResultado de la sumatoria de ((Oij - Eij)^2)/2 = " + xoCuadrada);

        double [][] tablaChi ={        // Tabla chi cuadrada
            {1,3.841},   {2,5.991},	  {3,7.815},   {4,9.488},	{5,11.070}, 
            {6,12.592},	 {7,14.067},  {8,15.507},  {9,16.919},	{10,18.307}, 
            {11,19.675}, {12,21.026}, {13,22.362}, {14,23.685}, {15,24.996},
            {16,26.296}, {17,27.587}, {18,28.869}, {19,30.144}, {20,31.410},	
            {21,32.671}, {22,33.924}, {23,35.172}, {24,36.415}, {25,37.652},
            {26,38.885}, {27,40.113}, {28,41.337}, {29,42.557}, {30,43.773},
            {31,44.985}, {32,46.194}, {33,47.400}, {34,48.602}, {35,49.802},
            {40,55.758}, {50,67.500}, {60,79.1},   {100,124.3}
        };

        double gl = Math.pow(n, 2) - 1; // gl = grados de libertad

        double valorAComparar = 0;      // Aqui obtendremos el valor de la tabla chi cuadrada que vamos a comparar con el valor que calculamos en nuestro código
        for (int i = 0; i < tablaChi.length; i++) {
            if (tablaChi[i][0] == gl) {
                valorAComparar = tablaChi[i][1];
                break;
            }
        }
        
        // Comparamos nuestra Chi calculada con la Chi de la tabla
        System.out.println("¿ " + xoCuadrada + " > " + valorAComparar + " ?");
        if (xoCuadrada > valorAComparar) {
            System.out.println("Si. Rechazamos la hipótesis nula, puesto que existen diferencias significativas.");
        } else {
            System.out.println("No. No rechazamos la hipótesis nula, puesto que no hay diferencias significativas.");
        }
    
        
    }

}
