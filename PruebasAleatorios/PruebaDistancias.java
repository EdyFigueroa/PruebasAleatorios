package PruebasAleatorios;

import java.util.ArrayList;

public class PruebaDistancias {
    // Atributos
    private double[] numeros; // Matriz de números

    private double alpha; // Límite inferior
    private double tetha; // Abarcación del límite
    private double beta; // Límite superior (se calcula con alpha y beta)

    // Constructor
    public PruebaDistancias(double[] numeros, double alpha, double tetha) {
        this.numeros = numeros;
        this.alpha = alpha;
        this.tetha = tetha;

        beta = alpha + this.tetha; // Límite superior = alpha + tetha
    }

    public void calcular() {
        // Necesitamos saber los huecos que hay de número en intervalo a número fuera de intervalo
        int [] huecos = calcularHuecos();

        // Buscar el hueco más grande
        int I = 0;
        for (int i = 0; i < huecos.length; i++) {
            if (huecos[i] > I) {
                I = huecos[i];
            }
        }

        // Encabezado de la tabla
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("|%-7s|%-12s|%-7s|%-12s|%-12s|%-12s|\n", "i", "Pi", "Oi", "Ei", "Ei-Oi", "(Ei-Oi)^2/Ei");
        System.out.println("---------------------------------------------------------------------");

        double pruebaDistancias = 0;

        // Por cada grado de libertad hacemos un renglón
        for (int i = 0; i <= I; i++) {
            // i: Número (si es el último se le añade ">=")
            String _i = i == I ? ">= " + i : Integer.toString(i);

            // Probabilidad teórica: "En teoría, debería haber una probabilidad de Pi que pasara ayay"
            // Fórmula: (1 - alpha)^gradosLibertad (si es la última, se multiplica por 1)
            double pi = Math.pow(1-tetha, i) * (i == I ? 1 : tetha);

            // Oi: Veces que apareció este número de huecos
            int oi = 0;
            for (int j = 0; j <= huecos.length-1; j++) {
                if (huecos[j] == i || (i == I && huecos[j] >= i)) {
                    oi++;
                }
            }

            // Ei:
            double ei = pi * huecos.length;

            // Ei - Oi : Diferencia entre la teoría y nuestro número
            double eioi = ei - oi; 

            // (Ei - Oi)^2 / Ei
            double prueba = Math.pow(eioi, 2) / ei;
            pruebaDistancias += prueba;
            
            // Imprimir fila
            System.out.printf("|%7s|%12f|%7d|%12f|%12f|%12f|\n", _i, pi, oi, ei, eioi, prueba);
        }

        // Imprimir columna de totales
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("|%7s|%12d|%7d|%12d|%12s|%12f|\n",
            "", 1, huecos.length, huecos.length, "", pruebaDistancias);
        System.out.println("---------------------------------------------------------------------");

        // Obtener chiCuadrada
        double chiCuadrada = getChiCuadrada(I);

        // Imprimir conclusion
        System.out.println("- Prueba de distancias: " + pruebaDistancias);
        System.out.println("- Chi cuadrada: " + chiCuadrada);
        if (pruebaDistancias < chiCuadrada) {
            System.out.println("\nSe acepta H₀: los valores parecen distribuidos aleatoriamente.");
        } else {
            System.out.println("\nNo hay evidencia suficiente para afirmar que los valores estén distribuidos aleatoriamente.");
        }
    }

    public int[] calcularHuecos() {
        // Este ArrayList almacena la cantidad de números que están en el intervalo
        ArrayList<Integer> huecos = new ArrayList<Integer>();

        int contador = 0, anterior = -1;
        for (int i = 0; i < numeros.length; i++) {
            // Si está en el intervalo dado, comenzar un contador
            if (enIntervalo(numeros[i])) {
                contador = 0;

                // Si estabamos enrachados, romper la racha
                if (anterior > 0) {
                    huecos.add(anterior);
                }
            } else {
                contador++;

                // Si estabamos enrachados, romper la racha
                if (anterior == 0) {
                    huecos.add(0);
                }
            }

            anterior = contador;
        }

        // Finalizaron los números. Romper rachas
        if (anterior == 0) huecos.add(0);
        else huecos.add(anterior);

        // Convertir a arreglo de doubles y regresarlo
        int [] arreglo = new int[huecos.size()];
        for (int i = 0; i < huecos.size(); i++) {
            arreglo[i] = huecos.get(i);
        }

        return arreglo;
    }

    public boolean enIntervalo(double num) {
        return num >= alpha && num <= beta;
    }

    public double getChiCuadrada(int gl) {
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

        for (double[] fila : tablaChi) { // Por cada fila
            if ((int) fila[0] == gl) { // Si el valor del grado actual es igual al que estamos buscando
                return fila[1]; // Regresamos el valor crítico
            }
        }
        return 0; // Si no encuentra, regresa 0
    }
}
