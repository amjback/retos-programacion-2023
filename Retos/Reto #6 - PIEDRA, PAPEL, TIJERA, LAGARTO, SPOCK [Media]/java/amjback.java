package reto06;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class PiedraPapelTijeraLagartoSpock {

    public static final String PIEDRA = "piedra";
    public static final String PAPEL = "papel";
    public static final String TIJERA = "tijera";
    public static final String LAGARTO = "lagarto";
    public static final String SPOCK = "spock";
    public static final String PLAYER_1 = "Player 1";
    public static final String PLAYER_2 = "Player 2";
    public static final String TIE = "Tie";

    private PiedraPapelTijeraLagartoSpock() {}

    private static final Map<String, List<String>> opcionesGanadoras = new HashMap<>();
    static {
        opcionesGanadoras.put(PIEDRA, Arrays.asList(TIJERA, LAGARTO));
        opcionesGanadoras.put(PAPEL, Arrays.asList(PIEDRA, SPOCK));
        opcionesGanadoras.put(TIJERA, Arrays.asList(PAPEL, LAGARTO));
        opcionesGanadoras.put(LAGARTO, Arrays.asList(PAPEL, SPOCK));
        opcionesGanadoras.put(SPOCK, Arrays.asList(PIEDRA, TIJERA));
    }

    public static String calcularGanador(List<Jugada> jugadas) {
        int puntuacionPlayer1 = 0;
        int puntuacionPlayer2 = 0;

        for (Jugada jugada : jugadas) {
            String opcion1 = jugada.getOpcion1();
            String opcion2 = jugada.getOpcion2();
            String resultado = jugarRonda(opcion1, opcion2);

            if (resultado.equals(PLAYER_1)) {
                puntuacionPlayer1++;
            } else if (resultado.equals(PLAYER_2)) {
                puntuacionPlayer2++;
            }
        }

        if (puntuacionPlayer1 > puntuacionPlayer2) {
            return PLAYER_1;
        } else if (puntuacionPlayer2 > puntuacionPlayer1) {
            return PLAYER_2;
        } else {
            return TIE;
        }
    }

    public static String jugarRonda(String opcion1, String opcion2) {
        if (opcion1.equals(opcion2)) {
            return TIE;
        } else if (opcionesGanadoras.get(opcion1).contains(opcion2)) {
            return PLAYER_1;
        } else {
            return PLAYER_2;
        }
    }

    public static class Jugada {
        private final String opcion1;
        private final String opcion2;

        public Jugada(String opcion1, String opcion2) {
            this.opcion1 = opcion1;
            this.opcion2 = opcion2;
        }

        public String getOpcion1() {
            return opcion1;
        }

        public String getOpcion2() {
            return opcion2;
        }
    }
}
