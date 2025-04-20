import java.io.*;

public class ArbolHabilidades {
    private NodoHabilidad raiz;

    public ArbolHabilidades(Habilidad habilidadRaiz) {
        this.raiz = new NodoHabilidad(habilidadRaiz);
    }

    public NodoHabilidad getRaiz() {
        return raiz;
    }

    public void mostrarArbol(NodoHabilidad nodo, String prefijo) {
        if (nodo != null) {
            System.out.println(prefijo + "- " + nodo.habilidad.toString());
            mostrarArbol(nodo.izquierda, prefijo + "  ");
            mostrarArbol(nodo.derecha, prefijo + "  ");
        }
    }

    public NodoHabilidad buscar(String nombre, NodoHabilidad nodo) {
        if (nodo == null) return null;
        if (nodo.habilidad.getNombre().equalsIgnoreCase(nombre)) return nodo;

        NodoHabilidad izquierda = buscar(nombre, nodo.izquierda);
        if (izquierda != null) return izquierda;

        return buscar(nombre, nodo.derecha);
    }

    // MÉTODOS DE GUARDADO

    public void guardarArbol(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            guardarNodo(writer, raiz, "");
            System.out.println("Árbol guardado en: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el árbol: " + e.getMessage());
        }
    }

    private void guardarNodo(PrintWriter writer, NodoHabilidad nodo, String path) {
        if (nodo != null) {
            Habilidad h = nodo.habilidad;
            writer.println(path + "|" + h.getNombre() + "|" + h.getNivel() + "|" + h.getEnergiaNecesaria() + "|" + h.getTurnosRestantes());
            guardarNodo(writer, nodo.izquierda, path + "L");
            guardarNodo(writer, nodo.derecha, path + "R");
        }
    }

    public static ArbolHabilidades cargarArbol(String nombreArchivo) {
        ArbolHabilidades arbol = new ArbolHabilidades(new Habilidad("Dummy", "Temporal", 1, 0, 0));
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\\|");
                String path = partes[0];
                String nombre = partes[1];
                int nivel = Integer.parseInt(partes[2]);
                int energia = Integer.parseInt(partes[3]);
                int cooldownRestante = Integer.parseInt(partes[4]);

                Habilidad h = new Habilidad(nombre, "Cargada", 3, energia, 2);
                while (h.getNivel() < nivel) h.subirNivel();
                while (h.getTurnosRestantes() < cooldownRestante) h.usar();

                arbol.insertarEnRuta(path, h);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar árbol: " + e.getMessage());
        }
        return arbol;
    }

    private void insertarEnRuta(String ruta, Habilidad habilidad) {
        if (ruta.isEmpty()) {
            raiz = new NodoHabilidad(habilidad);
            return;
        }

        NodoHabilidad actual = raiz;
        for (int i = 0; i < ruta.length() - 1; i++) {
            char c = ruta.charAt(i);
            actual = (c == 'L') ? actual.izquierda : actual.derecha;
        }

        char dir = ruta.charAt(ruta.length() - 1);
        if (dir == 'L') {
            actual.izquierda = new NodoHabilidad(habilidad);
        } else if (dir == 'R') {
            actual.derecha = new NodoHabilidad(habilidad);
        }
    }
}
