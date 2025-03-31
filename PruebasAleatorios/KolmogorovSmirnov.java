package PruebasAleatorios;

public class KolmogorovSmirnov{
    // Atributos
    protected double[] array;
    // Constructor
    public KolmogorovSmirnov(double[] array){
        this.array = array.clone();
    }
    // Métodos
    public void calcular(){
        //Utilizar matriz con datos para determinar i/N y Di

        double iN[] = new double[array.length];
        double Di[] = new double[array.length];

        //Impresion del encabezado de la tabla
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-10s |%-10s |%-10s |%-10s |%n", "i", "Ui", "i/N", "Di");
        System.out.println("-------------------------------------------------");

        //rellenar matrices iN y Di
        double d=0;
        double nSig=0.05;
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
            System.out.println("-------------------------------------------------");
        }

        //Encontrar valor Di mas alto y su ubicacion en la matriz
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

        //PRUEBA DE BONDAD DE AJUSTE(Determinar DN_a, y si D < DN,a se acepta H0, en caso contrario se rechaza)
        if (array.length>30 && nSig == 0.05)
        DN_a=1.36/Math.sqrt(array.length);
        else if(array.length>30 && nSig == 0.10)
        DN_a=1.22/Math.sqrt(array.length);
        else if(array.length>30 && nSig == 0.01)
        DN_a=1.63/Math.sqrt(array.length);

        //Impresion de datos mostrando DN_a y DiMax
        System.out.println("\nD = "+Di[indice]+"          D"+array.length+","+(nSig*100)+" = "+DN_a);
        if (Di[indice]>DN_a)
            System.out.println("D > D"+array.length+","+(nSig*100));
        else
            System.out.println("D < D"+array.length+","+(nSig*100));
        
            System.out.println("-------------------------------------------------");

        //Impresion de conclusion
        if(Di[indice]<DN_a)
            System.out.println("Se acepta H0, lo que significa que los numeros estan distribuidos uniformemente.");
        else 
            System.out.println("Se rechaza H0, lo que significa que los numeros no estan distribuidos uniformemente.");

    }

}