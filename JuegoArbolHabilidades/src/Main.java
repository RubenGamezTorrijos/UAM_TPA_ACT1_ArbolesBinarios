import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Árbol Dinámico (Jugador 1)
        Habilidad raiz1 = new Habilidad("Maestría", "Inicio", 3, 0, 0);
        ArbolHabilidades arbol1 = new ArbolHabilidades(raiz1);
        arbol1.getRaiz().izquierda = new NodoHabilidad(new Habilidad("Espada", "Ataque", 3, 20, 2));
        arbol1.getRaiz().derecha = new NodoHabilidad(new Habilidad("Escudo", "Defensa", 3, 15, 1));

        // Árbol Secuencial (Jugador 2)
        Habilidad raiz2 = new Habilidad("Maestría", "Inicio", 3, 0, 0);
        ArbolHabilidades arbol2 = new ArbolHabilidades(raiz2);
        arbol2.getRaiz().izquierda = new NodoHabilidad(new Habilidad("Arco", "Ataque a distancia", 3, 25, 2));
        arbol2.getRaiz().derecha = new NodoHabilidad(new Habilidad("Armadura", "Defensa alta", 3, 30, 3));

        Jugador jugador1 = new Jugador("Jugador 1", arbol1, true);
        Jugador jugador2 = new Jugador("Jugador 2", arbol2, false);

        boolean salir = false;
        boolean turnoJugador1 = true;

        while (!salir) {
            Jugador actual = turnoJugador1 ? jugador1 : jugador2;
            Jugador oponente = turnoJugador1 ? jugador2 : jugador1;

            System.out.println("\n=== TURNO DE " + actual.getNombre() + " ===");
            System.out.println("Energía actual: " + actual.getEnergia());
            System.out.println("1. Ver árbol de habilidades");
            System.out.println("2. Usar habilidad");
            System.out.println("3. Mejorar habilidad");
            System.out.println("4. Pasar turno");
            System.out.println("5. Ver estado del oponente");
            System.out.println("6. Guardar árbol");
            System.out.println("7. Cargar árbol");
            System.out.println("0. Salir del combate");
            System.out.print("Selecciona una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    actual.mostrarArbol();
                    break;
                case 2:
                    System.out.print("Nombre de la habilidad a usar: ");
                    String nombre = sc.nextLine();
                    actual.usarHabilidadPorNombre(nombre);
                    break;
                case 3:
                    System.out.print("Nombre de la habilidad a mejorar: ");
                    String nombreMejora = sc.nextLine();
                    actual.mejorarHabilidad(nombreMejora);
                    break;
                case 4:
                    actual.regenerar();
                    System.out.println(actual.getNombre() + " ha pasado turno y recuperado energía.");
                    turnoJugador1 = !turnoJugador1; // cambio de jugador
                    break;
                case 5:
                    oponente.mostrarArbol();
                    break;
                case 6:
                    System.out.print("Nombre del archivo para guardar: ");
                    String archivoGuardar = sc.nextLine();
                    actual.getArbol().guardarArbol(archivoGuardar + ".txt");
                    break;
                case 7:
                    System.out.print("Nombre del archivo para cargar: ");
                    String archivoCargar = sc.nextLine();
                    ArbolHabilidades arbolCargado = ArbolHabilidades.cargarArbol(archivoCargar + ".txt");
                    if (turnoJugador1) {
                        jugador1 = new Jugador("Jugador 1", arbolCargado, true);
                    } else {
                        jugador2 = new Jugador("Jugador 2", arbolCargado, false);
                    }
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            // Solo cambia el turno si no salió del combate ni se quedó en opciones de visualización
            if (opcion >= 1 && opcion <= 5 && opcion != 4) {
                System.out.println("Fin del turno de " + actual.getNombre());
                System.out.println("Pulsa Enter para continuar con el siguiente jugador...");
                sc.nextLine(); // espera confirmación del jugador
                turnoJugador1 = !turnoJugador1;
            }
        }

        System.out.println("¡Fin de la partida!");
        sc.close();
    }
}
