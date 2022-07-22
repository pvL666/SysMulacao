package organismos;

import ambiente.Espaco;
import java.awt.Point;

/**
 *
 * @author Nadaletti
 */
public class Organismo {

    private String identificacao;
    private Integer campoVisao;
    private Espaco espaco;

    public Organismo(Espaco espaco) {
        this.espaco = espaco;
    }

    public Organismo(Espaco espaco, String identificacao) {
        this(espaco);
        this.identificacao = identificacao;
    }

    public Organismo(Espaco espaco, String identificacao, Integer campoVisao) {
        this(espaco, identificacao);
        this.campoVisao = campoVisao;
    }

    public Point mover() {
        
        return new Point();
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

}
