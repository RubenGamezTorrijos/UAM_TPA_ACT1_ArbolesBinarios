public class Combate {
    private Jugador jugador1;
    private Jugador jugador2;

    public Combate(Jugador j1, Jugador j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
    }

    public void iniciar() {
        for (int turno = 1; turno <= 10; turno++) {
            System.out.println("\n=== Turno " + turno + " ===");

            turnoJugador(jugador1, jugador2);
            turnoJugador(jugador2, jugador1);

            jugador1.regenerar();
            jugador2.regenerar();

            jugador1.mostrarArbol();
            jugador2.mostrarArbol();
        }

        System.out.println("\n¡Fin del combate!");
    }

    private void turnoJugador(Jugador atacante, Jugador defensor) {
        Habilidad h = atacante.seleccionarHabilidadDisponible();
        atacante.usarHabilidad(h);
    }
}
