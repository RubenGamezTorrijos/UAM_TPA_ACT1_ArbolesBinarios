public class Jugador {
    // Atributos
    private String nombre;
    private int energia;
    private ArbolHabilidades arbol;
    private boolean esDinamico;

    // Constructor
    public Jugador(String nombre, ArbolHabilidades arbol, boolean esDinamico) {
        this.nombre = nombre;
        this.arbol = arbol;
        this.energia = 100;
        this.esDinamico = esDinamico;
    }

    public String getNombre() { return nombre; }
    public int getEnergia() { return energia; }
    public ArbolHabilidades getArbol() { return arbol; }

    public void mostrarArbol() {
        System.out.println("\nÁrbol de habilidades de " + nombre + ":");
        arbol.mostrarArbol(arbol.getRaiz(), "");
    }

    public Habilidad seleccionarHabilidadDisponible() {
        return buscarHabilidadDisponible(arbol.getRaiz());
    }

    private Habilidad buscarHabilidadDisponible(NodoHabilidad nodo) {
        if (nodo == null) return null;

        Habilidad h = nodo.habilidad;
        if (h.disponible(energia)) return h;

        Habilidad izq = buscarHabilidadDisponible(nodo.izquierda);
        if (izq != null) return izq;

        return buscarHabilidadDisponible(nodo.derecha);
    }

    public void usarHabilidad(Habilidad h) {
        if (h != null && h.disponible(energia)) {
            System.out.println(nombre + " usa " + h.getNombre());
            energia -= h.getEnergiaNecesaria();
            h.usar();
            h.subirNivel();
        } else {
            System.out.println(nombre + " no puede usar la habilidad.");
        }
    }

    public void usarHabilidadPorNombre(String nombre) {
        NodoHabilidad nodo = arbol.buscar(nombre, arbol.getRaiz());
        if (nodo != null && nodo.habilidad.disponible(energia)) {
            usarHabilidad(nodo.habilidad);
        } else {
            System.out.println("No se puede usar la habilidad: no encontrada, en cooldown o energía insuficiente.");
        }
    }

    public void mejorarHabilidad(String nombre) {
        NodoHabilidad nodo = arbol.buscar(nombre, arbol.getRaiz());
        if (nodo != null && nodo.habilidad.puedeMejorar(energia)) {
            energia -= nodo.habilidad.getEnergiaNecesaria();
            nodo.habilidad.subirNivel();
            System.out.println("Habilidad mejorada: " + nodo.habilidad.getNombre());
        } else {
            System.out.println("No se puede mejorar la habilidad: requisitos no cumplidos.");
        }
    }

    public void regenerar() {
        energia = Math.min(100, energia + 10);
        reducirCooldowns(arbol.getRaiz());
    }

    private void reducirCooldowns(NodoHabilidad nodo) {
        if (nodo != null) {
            nodo.habilidad.reducirCooldown();
            reducirCooldowns(nodo.izquierda);
            reducirCooldowns(nodo.derecha);
        }
    }

    public void turnoAutomatico() {
        System.out.println("\nTurno de " + nombre);
        Habilidad h = seleccionarHabilidadDisponible();
        if (h != null) {
            usarHabilidad(h);
        } else {
            System.out.println(nombre + " no ha podido usar ninguna habilidad.");
        }
        regenerar();
    }
}
