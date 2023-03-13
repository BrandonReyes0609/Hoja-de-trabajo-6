import java.util.*;
import java.io.File;

public class Controlador {

    public static String obtenerTipo(String key, Map<String, String> map) throws Exception {
        String carta = map.get(key);
        if (carta == null) {
            throw new Exception("Error carta no esta en las existentes");
        }
        return carta;
    }

    public static Map<String, String> agregarCarta(String key, Map<String, String> map, Map<String, String> coleccion)
            throws Exception {
        coleccion.put(key, obtenerTipo(key, map));
        return coleccion;
    }

    public static String printMapa(Map<String, String> mapa, boolean imprimirMapa) {
        String s = "";
        if (mapa.isEmpty()) {
            s = "\nCollecion vacia";
        } else {
            if (imprimirMapa) {
                s = "\nCartas en la coleccion";
                for (String carta : mapa.keySet()) {
                    s = s + "\n Nombre: " + carta + ", Tipo: " + mapa.get(carta);
                }
            } else {
                s = "\nTiempo de corrida promedio: ";
                long tiempo = 0;
                for (int i = 0; i < 20; i++) {
                    long t1 = System.nanoTime();
                    for (String carta : mapa.keySet()) {
                        mapa.get(carta);
                    }
                    tiempo += System.nanoTime() - t1;
                }
                s = tiempo / 20 + " ";
            }
        }
        return s;
    }

    public static String printTiempo(Map<String, String> mapa) {
        String s = "";
        if (mapa.isEmpty()) {
            s = "\nCollecion vacia";
        } else {
            String ultimoE = "";
            for (String carta : mapa.keySet()) {
                ultimoE = carta;
            }
            long tiempo = 0;
            for (int i = 0; i < 20; i++) {
                long t1 = System.nanoTime();
                mapa.get(ultimoE);
                tiempo += System.nanoTime() - t1;
                s = tiempo / 20 + " ";
            }
        }
        return s;

    }

    public static String cantTiempo() {
        String s = "\nCant. \tTiempo";
        // estabilizar el tiempo
        for (int i = 1; i < 11; i++) {
            try {
                Map<String, String> valores = LeerArchivo("HM", "cards_desc.txt", i);
                Controlador.printTiempo(valores);
            } catch (Exception e) {
            }
        }

        // valores reales a imprimir
        int[] cants = { 10, 50, 100, 500, 1000, 1500, 2000, 4000, 6000, 8500 };
        for (int i : cants) {
            try {
                Map<String, String> valores = LeerArchivo("HM", "cards_desc.txt", i);
                s += "\n" + valores.size() + "\t" + Controlador.printTiempo(valores);
            } catch (Exception e) {
                s = "Error " + e.getMessage();
            }

        }

        return s;
    }

    public static String printMapaOrdenado(Map<String, String> mapa, boolean imprimirMapa) {
        String s = ""; // String to be returned

        // Logic to compare two entries
        Comparator<Map.Entry> compareByKeyType = new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                Comparable value1 = (Comparable) o1.getValue();
                Comparable value2 = (Comparable) o2.getValue();
                return value1.compareTo(value2);
            }
        };
        Set entrySet = mapa.entrySet(); // Get the entry set for this map
        ArrayList<Map.Entry> sortedEntries = new ArrayList(entrySet); // Convert the entry set to an array
        sortedEntries.sort(compareByKeyType); // Sort the entries
        if (mapa.isEmpty()) {
            s = "\nCollecion vacia";
        } else {
            if (imprimirMapa) {
                s = "\nCartas en la coleccion";
                for (Map.Entry entry : sortedEntries) {
                    s = s + "\n Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue();
                }
            } else {
                s = "\nTiempo de corrida promedio: ";
                long tiempo = 0;
                for (int i = 0; i < 20; i++) {
                    long t1 = System.nanoTime();
                    for (Map.Entry entry : sortedEntries) {
                        entry.getKey();
                        entry.getValue();
                    }
                    tiempo += System.nanoTime() - t1;
                }
                s += tiempo / 20 + " nanosegundos";
            }

        }

        return s;
    }

    public static String cantTiempoHash() {
        String s = "\nCant. \tTiempo";
        // estabilizar el tiempo
        for (int i = 1; i < 11; i++) {
            try {
                Map<String, String> valores = LeerArchivo("HM", "cards_desc.txt", 10);
                Controlador.printMapa(valores, false);
            } catch (Exception e) {
            }
        }

        // valores reales a imprimir
        int[] cants = { 10, 50, 100, 500, 1000, 1500, 2000, 4000, 6000, 8500 };
        for (int i : cants) {
            try {
                Map<String, String> valores = LeerArchivo("HM", "cards_desc.txt", i);
                s += "\n" + valores.size() + "\t" + Controlador.printMapa(valores, false);
            } catch (Exception e) {
                s = "Error " + e.getMessage();
            }

        }

        return s;
    }

    public static Map<String, String> LeerArchivo(String tipoHash, String archivo, int cant) throws Exception {
        HashFactory<String, String> HFactory = new HashFactory<String, String>();
        Map<String, String> hash = HFactory.getMap(tipoHash);
        // System.out.println("archivo: " + archivo);
        File file = new File("cards_desc.txt");
        try {
            Scanner fileScanner = new Scanner(file);
            System.out.println(fileScanner);

            for (int i = 0; i < cant; i++) {
                String linea = fileScanner.nextLine();
                String[] items = linea.split("\\|");
                hash.put(items[0], items[1]);
            }
            fileScanner.close();
        } catch (Exception e) {
            throw new Exception("Error 404, no se alcanzo a leer el archivo");
        }
        return hash;
    }
}