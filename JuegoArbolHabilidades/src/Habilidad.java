public class Habilidad {
    private String nombre;
    private String descripcion;
    private int nivel;
    private int maximoNivel;
    private int energiaNecesaria;
    private int cooldown;
    private int turnosRestantes;

    public Habilidad(String nombre, String descripcion, int maximoNivel, int energiaNecesaria, int cooldown) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = 0;
        this.maximoNivel = maximoNivel;
        this.energiaNecesaria = energiaNecesaria;
        this.cooldown = cooldown;
        this.turnosRestantes = 0;
    }

    public boolean puedeMejorar(int energiaDisponible) {
        return nivel < maximoNivel && turnosRestantes == 0 && energiaDisponible >= energiaNecesaria;
    }

    public boolean disponible(int energiaDisponible) {
        return turnosRestantes == 0 && energiaDisponible >= energiaNecesaria;
    }

    public void usar() {
        this.turnosRestantes = cooldown;
    }

    public void reducirCooldown() {
        if (turnosRestantes > 0) turnosRestantes--;
    }

    public void subirNivel() {
        if (nivel < maximoNivel) nivel++;
    }

    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getEnergiaNecesaria() { return energiaNecesaria; }
    public int getTurnosRestantes() { return turnosRestantes; }

    @Override
    public String toString() {
        return nombre + " (Nivel: " + nivel + "/" + maximoNivel + ", Cooldown: " + cooldown + ", Restante: " + turnosRestantes + ")";
    }
}
