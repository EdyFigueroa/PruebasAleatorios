package PruebasAleatorios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hola mundo
 */
public class LeerDatos {
    // Atributos de la clase
    private String path;

    /**
     * Constructor de la clase LeerDatos.
     * Esta clase convierte cada línea de un archivo a un double y lo guarda en un arreglo.
     * @param path Ruta del archivo a leer
     */
    public LeerDatos(String path) {
        this.path = path;
    }

    /**
     * Crea un arreglo tipo double en el que cada elemento es una línea del archivo con el que se creó la clase.
     * @return Arreglo de números
     */
    public double[] leerArchivo() {
        double[] array = {};
        try {
            // Creamos el BuffReader para empezar a leer datos
            File archivo = new File(path);
            FileReader fileReader = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fileReader);

            // Creamos un ArrayList donde almacenaremos las líneas
            ArrayList<Double> lista = new ArrayList<Double>();
            
            // Variable que almacena la línea actual
            String linea = br.readLine();

            while (linea != null) { // Mientras la línea no sea null
                try {
                    lista.add( Double.parseDouble(linea) ); // Añadimos el valor a la lista
                    linea = br.readLine(); // Pasamos a la siguiente línea
                } catch (NumberFormatException e) {
                    // Si se lee una línea que no se pueda pasar a double, la saltamos
                    linea = br.readLine();
                }
            }

            // Convertir la lista a un arreglo de doubles
            array = new double[lista.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = lista.get(i);
            }

            // Cerramos el BufferReader
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }
}
