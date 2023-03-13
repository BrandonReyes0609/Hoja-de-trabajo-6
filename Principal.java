import java.io.File;
import java.time.format.SignStyle;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.util.Scanner;
import java.util.Map;
//Author: Brandon Reyes Morales 2292
public class Principal {
    public static void main(String[] args) throws Exception {

        // menu = "Qué tipo de Map quiere usar";
        System.out.println("Qué tipo de Map quiere usar: \n 1)HashMap \n 2)TreeMap \n 3)LinkedHashMap ");

        HashFactory<String, String> HFactory = new HashFactory<String, String>();// tipo hash
        Map<String, String> MaquinaHash = null;
        Map<String, String> baraja = null;

        Scanner teclado = new Scanner(System.in);
        String value1 = teclado.nextLine();
        MaquinaHash = HFactory.getMap(value1);// El tipo metdo de del juego

        baraja = LeerArchivo(value1, "cards_desc.txt");

        String menu = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n----->Seleccione alguna opción ";
        menu = menu + "\n 1. Agregar una carta a la colección del usuario";
        menu = menu
                + "\n 2. Mostrar el tipo de una carta específica. El usuario ingresará el nombre de la carta y se muestra el tipo de esa carta.";
        menu = menu + "\n 3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.";
        menu = menu
                + "\n 4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo.";
        menu = menu + "\n 5. Mostrar el nombre y tipo de todas las baraja existentes.";
        menu = menu + "\n 6. Mostrar el nombre y tipo de todas las baraja existentes, ordenadas por tipo";
        menu = menu + "\n 7. Salir";

        System.out.println(menu);
        Scanner teclado2 = new Scanner(System.in);
        int op = teclado2.nextInt();

        while (op != 7) {
            Scanner teclado3 = new Scanner(System.in);

            if (op == 1) {
                System.out.println("Selecciono opción 1");

                System.out.println("---> Agregar Carta \n");
                System.out.print("Ingres el nombre de la carta ");

                String name = teclado3.nextLine();

                MaquinaHash = Controlador.agregarCarta(name, baraja, MaquinaHash);
                System.out.println("Carta agregada en al baraja\n");

            } else if (op == 2) {
                System.out.println("Selecciono opción 2");
                System.out.println(Controlador.printMapa(MaquinaHash,true));
                System.out.println(Controlador.printMapa(MaquinaHash,false));


            } else if (op == 3) {
                System.out.println("Selecciono opción 3");
                System.out.println(Controlador.printMapaOrdenado(MaquinaHash,true));
                System.out.println(Controlador.printMapaOrdenado(MaquinaHash,false));
            } else if (op == 4) {
                System.out.println("Selecciono opción 4");
                System.out.println(Controlador.printMapa(baraja,true));
                System.out.println(Controlador.printMapa(baraja,false));
            } else if (op == 5) {
                System.out.println("Selecciono opción 5");
                System.out.println(Controlador.printMapaOrdenado(baraja,true));
                System.out.println(Controlador.printMapaOrdenado(baraja,false));
            } else if (op == 6) {
                System.out.println("Selecciono opción 6");

            }

        }
    }

    public static Map<String, String> LeerArchivo(String tipoHash, String archivo) throws Exception {
        HashFactory<String, String> HFactory = new HashFactory<String, String>();
        Map<String, String> hash = HFactory.getMap(tipoHash);
        // System.out.println("archivo: " + archivo);
        File file = new File("cards_desc.txt");
        try {
            Scanner fileScanner = new Scanner(file);
            System.out.println(fileScanner);
            while (fileScanner.hasNextLine()) {
                String linea = fileScanner.nextLine();
                String[] articulo = linea.split("\\|");
                hash.put(articulo[0], articulo[1]);
            }
            fileScanner.close();
        } catch (Exception e) {
            throw new Exception("Error 404, no se alcanzo a leer el archivo");
        }
        return hash;
    }

}
