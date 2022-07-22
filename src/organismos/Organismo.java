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

    public Organismo() {
    }

    public Organismo(String identificacao) {
        this.identificacao = identificacao;
    }

    public Organismo(String identificacao, Integer campoVisao) {
        this.identificacao = identificacao;
        this.campoVisao = campoVisao;
    }

    public Organismo(String identificacao, Integer campoVisao, Espaco espaco) {
        this.identificacao = identificacao;
        this.campoVisao = campoVisao;
        this.espaco = espaco;
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
