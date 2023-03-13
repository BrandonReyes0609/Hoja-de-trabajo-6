import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class HashFactory<K, V> {
    // selecciona la implementacion a utilizar para un stack
    // se utiliza el patron Factory
    public Map<K, V> getMap(String opcion) {
        // seleccion de la implementacion a utilizar:
        if (opcion.equals("1")) {
            System.out.println("Crear tipo HashMap");
            return new HashMap<K, V>(); // regresa ArrayList
        } else if (opcion.equals("2")) {
            System.out.println("Crear tipo LinkedHashMap");
            return new LinkedHashMap<K, V>(); // regresa ArrayList
        } else if (opcion.equals("3")) {
            System.out.println("Crea tipo TreeMap");
            return new TreeMap<K, V>(); // regresa ArrayList
        }

        return null;
    }
}