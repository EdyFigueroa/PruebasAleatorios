package PruebasAleatorios;

import java.util.Arrays;

public class KolmogorovSmirnov{
    // Atributos
    protected double[] array;
    protected double nSig;
    // Constructor
    public KolmogorovSmirnov(double[] array, double nSig){
        this.array = array.clone();
        this.nSig = nSig;
    }

    //Metodo para organizar la matriz
    public void ordenarArray() {
        Arrays.sort(array);
    }

    // Métodos
    public void calcular(){
        //Organizar matriz de datos desordenados, debido a que este metodo requiere que su contenido este organizado de mayor a menor
        ordenarArray();


        //Utilizar matriz con datos para determinar i/N y Di

        double iN[] = new double[array.length];
        double Di[] = new double[array.length];

        //Impresion del encabezado de la tabla
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-10s |%-10s |%-10s |%-10s |%n", "i", "Ui", "i/N", "Di");
        System.out.println("-------------------------------------------------");

        //rellenar matrices iN y Di
        double d=0;
        double DN_a=0;
        for (int i=0; i<array.length; i++){
            d=i;
            iN[i]=(d+1)/array.length;
            Di[i]=Math.abs(array[i] - iN[i]);


            //Imprimir matrices
            System.out.printf("|%-10s |", i+1);
            System.out.printf("%-10.5f |", array[i]);
            System.out.printf("%-10.5f |", iN[i]);
            System.out.printf("%-10.5f |", Di[i]);
            System.out.println();
        }

        //Encontrar valor Di mas alto basandonos en su ubicacion en la matriz
        double DiMax=Di[0];
        int indice=0;
        for (int i=0; i<Di.length; i++){
            if (Di[i]>DiMax){
                DiMax=Di[i];
                indice=i;
            }
        }

        //Imprimir valores asociados con DiMax
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-10s |%-10s |%-10s |%-10s |%n", "i", "Ui", "i/N", "Di");
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-10s |", (indice+1));
        System.out.printf("%-10.5f |", array[indice]);
        System.out.printf("%-10.5f |", iN[indice]);
        System.out.printf("%-10.5f |", Di[indice]);
        System.out.println();
        System.out.println("-------------------------------------------------");

        //Obtener valores de la tabla kolmogorov smirnov o con formulas en caso de N>30
        if (array.length > 30) {
            // Para N >= 30, se usa la recurrencia en la tabla
            if (nSig == 0.05) DN_a = 1.36 / Math.sqrt(array.length);
            else if (nSig == 0.10) DN_a = 1.22 / Math.sqrt(array.length);
            else if (nSig == 0.01) DN_a = 1.63 / Math.sqrt(array.length);
            else if (nSig == 0.15) DN_a = 1.14 / Math.sqrt(array.length);
            else if (nSig == 0.20) DN_a = 1.07 / Math.sqrt(array.length);
        } else {
            // Para N <= 30, se obtiene el valor directamente de la tabla
            int N = array.length - 1; // Ajuste porque el índice del array empieza en 0
            double[][] tablaKS = {
                {0.995, 0.975, 0.950, 0.925, 0.900}, // N = 1
                {0.929, 0.842, 0.776, 0.726, 0.684}, // N = 2
                {0.828, 0.708, 0.642, 0.597, 0.565}, // N = 3  
                {0.733, 0.624, 0.564, 0.525, 0.494}, // N = 4
                {0.669, 0.565, 0.510, 0.474, 0.446}, // N = 5
                {0.618, 0.521, 0.470, 0.436, 0.410}, // N = 6
                {0.577, 0.486, 0.438, 0.405, 0.381}, // N = 7
                {0.543, 0.457, 0.411, 0.381, 0.358}, // N = 8
                {0.514, 0.432, 0.388, 0.360, 0.339}, // N = 9
                {0.490, 0.410, 0.368, 0.342, 0.322}, // N = 10
                {0.468, 0.391, 0.352, 0.326, 0.306}, // N = 11
                {0.450, 0.375, 0.338, 0.313, 0.295}, // N = 12
                {0.433, 0.361, 0.325, 0.302, 0.284}, // N = 13
                {0.418, 0.349, 0.314, 0.292, 0.274}, // N = 14
                {0.404, 0.338, 0.304, 0.283, 0.266}, // N = 15
                {0.392, 0.328, 0.295, 0.274, 0.258}, // N = 16
                {0.381, 0.318, 0.286, 0.266, 0.250}, // N = 17
                {0.371, 0.309, 0.278, 0.259, 0.244}, // N = 18
                {0.363, 0.301, 0.272, 0.252, 0.237}, // N = 19
                {0.356, 0.295, 0.264, 0.245, 0.231}, // N = 20
                {0.342, 0.279, 0.250, 0.233, 0.220}, // N = 21
                {0.331, 0.268, 0.240, 0.224, 0.210}, // N = 22
                {0.320, 0.260, 0.230, 0.215, 0.200}, // N = 23
                {0.310, 0.252, 0.222, 0.207, 0.192}, // N = 24
                {0.320, 0.270, 0.240, 0.220, 0.210}, // N = 25
                {0.294, 0.237, 0.209, 0.194, 0.179}, // N = 26
                {0.287, 0.231, 0.204, 0.189, 0.174}, // N = 27
                {0.281, 0.225, 0.198, 0.183, 0.168}, // N = 28
                {0.275, 0.220, 0.194, 0.179, 0.163}, // N = 29
                {0.290, 0.240, 0.220, 0.200, 0.190}  // N = 30
            };
            
            // Determinar el índice de la columna según el nivel de significancia
            int indiceAlpha = -1;
            if (nSig == 0.01) indiceAlpha = 0;
            else if (nSig == 0.05) indiceAlpha = 1;
            else if (nSig == 0.10) indiceAlpha = 2;
            else if (nSig == 0.15) indiceAlpha = 3;
            else if (nSig == 0.20) indiceAlpha = 4;

    // Obtener el valor de DN_a desde la tabla
    if (N < tablaKS.length && indiceAlpha != -1) {
        DN_a = tablaKS[N][indiceAlpha];
    } else {
        System.out.println("Error: N fuera de rango o nivel de significancia no válido.");
    }
        }

        //Impresion de datos mostrando DN_a y DiMax
        System.out.println("\nD = "+Di[indice]+"          D"+array.length+","+(nSig*100)+" = "+DN_a);
        if (Di[indice]>DN_a)
            System.out.println("D > D"+array.length+","+(nSig*100));
        else
            System.out.println("D < D"+array.length+","+(nSig*100));
        
            System.out.println("-------------------------------------------------");

        //Impresion de conclusión
        if(Di[indice]<DN_a)
            System.out.println("Se acepta H0, lo que significa que los numeros estan distribuidos uniformemente.");
        else 
            System.out.println("Se rechaza H0, lo que significa que los numeros no estan distribuidos uniformemente.");
        
    }

}