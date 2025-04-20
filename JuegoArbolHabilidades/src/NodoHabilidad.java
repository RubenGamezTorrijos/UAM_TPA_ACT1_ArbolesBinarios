public class NodoHabilidad {
    public Habilidad habilidad;
    public NodoHabilidad izquierda;
    public NodoHabilidad derecha;

    public NodoHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
        this.izquierda = null;
        this.derecha = null;
    }
}
