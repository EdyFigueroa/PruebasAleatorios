package PruebasAleatorios;

public class ChiCuadrada {
    // Atributos
    protected double[] array;
    // Constructor
    ChiCuadrada(double[] array){
        this.array = array.clone();
    }
    // Métodos
    public void calcular(){
        // Obtenemos el valor de N; Es la cantidad de números de la serie.
        int N = array.length;

        // Si la serie está vacia, acaba el método
        if (N == 0) {
            System.out.println("La serie está vacia."); 
            return;
        }

        else{ // Procedemos
            /// CÁLCULO
            // Calculamos variables
            int k = (int) Math.round(Math.sqrt(N)); /* Número de intervalos
            Es posible que eventualmente 'k' sea un valor con decimales, el cual redondearemos.
            El redondear hacia arriba o hacia abajo tiene efectos distintos en la exactidud de la prueba de bondad.
    
            * Hacia arriba: Puede ser adecuado para una mayor precisión y mayor cantidad de intervalos. Pero si la cantidad de datos por intervalo es muy baja se podrían generar
            intervalos con muy pocos datos, lo que afectaría la validez de la prueba de chi cuadrada.
            * Hacia abajo: es posible que se obtengan menos intervalos de los que se necesitan, lo que puede resultar en intervalos demasiado grandes 
            que no capturan bien la distribución de los datos.
            */
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
            int gl = k - 1; // Grados del libertad
            double chiCritico = obtenerChiCuadradoCritico(gl);
            
            System.out.printf("\tValor crítico de chi-cuadrado (α = %.2f): %.4f\n", 0.05, chiCritico);
        
            if (chiCuadrado < chiCritico) {
                System.out.println("\tSe acepta H0: No se encuentra evidencia suficiente para afirmar que los datos no siguen una distribución uniforme.");
            } else {
                System.out.println("\tSe rechaza H0: Los datos no siguen una distribución uniforme.");
            }

            

            /// Finalización
            if (N < 30) {System.out.println("- [!] El tamaño de la muestra (N) que está utilizando es relativamente pequeño. La validez puede verse afectada");}
        }
    }
    
    /**
     * Obtiene el valor crítico para la prueba de chi cuadrada. Asumiendo un valor para alpha de 0.05
     * @param gl Grados de libertad para la prueba. Se obtienen con al restarle 1 al valor de k.
     * @return valor crítico.
     */
    private static double obtenerChiCuadradoCritico(int gl) {
        double[][] tablaChi = { // La tabla de Chi cuadrada para una probabilidad de 5%
            {1, 3.841}, {2, 5.991}, {3, 7.815}, {4, 9.488}, {5, 11.070},
            {6, 12.592}, {7, 14.067}, {8, 15.507}, {9, 16.919}, {10, 18.307},
            {11, 19.675}, {12, 21.026}, {13, 22.362}, {14, 23.685}, {15, 24.996},
            {16, 26.296}, {17, 27.587}, {18, 28.869}, {19, 30.144}, {20, 31.410},
            {21, 32.671}, {22, 33.924}, {23, 35.172}, {24, 36.415}, {25, 37.652},
            {26, 38.885}, {27, 40.113}, {28, 41.337}, {29, 42.557}, {30, 43.773},
            {31, 44.985}, {32, 46.194}, {33, 47.400}, {34, 48.602}, {35, 49.802},
            {40, 55.758}, {50, 67.500}, {60, 79.1}, {100, 124.3}
        };
        
        for (double[] fila : tablaChi) { // Por cada fila
            if ((int) fila[0] == gl) { // Si el valor del grado actual es igual al que estamos buscando
                return fila[1]; // Regresamos el valor crítico
            }
        }
        return 0; // Si no se encuentra, se retorna 0
    }

    
}
