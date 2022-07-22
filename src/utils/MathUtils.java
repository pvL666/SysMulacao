package utils;

public class MathUtils {
    public static int InteiroAleatorio(int maximo) {
        return InteiroAleatorioEntre(0, maximo);
    }
    
    public static int InteiroAleatorioEntre(int minimo, int maximo) {
        return (int) ((Math.random() * (maximo - minimo)) + minimo);
    }
}
