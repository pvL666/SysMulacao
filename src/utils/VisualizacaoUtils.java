package utils;

import java.awt.Color;

public abstract class VisualizacaoUtils {
    public static Color CorAleatoria() {
        return new Color(
                MathUtils.InteiroAleatorio(255),
                MathUtils.InteiroAleatorio(255),
                MathUtils.InteiroAleatorio(255)
        );
    }
}
