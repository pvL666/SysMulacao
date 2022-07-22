package organismos;

import ambiente.Espaco;
import java.util.ArrayList;
import java.util.List;
import utils.ConstantesGerais;
import utils.MathUtils;

/**
 *
 * @author Nadaletti
 */
public class Organismo {

    private String identificacao;
    private Integer distanciaMovimento;
    private List<Espaco> movimentosDisponiveis = new ArrayList<>();
    private Espaco espaco;

    public Organismo(Espaco espaco) {
        this.espaco = espaco;
    }

    public Organismo(Espaco espaco, String identificacao) {
        this(espaco);
        this.identificacao = identificacao;
    }

    public Organismo(Espaco espaco, String identificacao, Integer distanciaMovimento) {
        this(espaco, identificacao);
        this.distanciaMovimento = distanciaMovimento;
    }

    public void iterar() {
        mover();
    }

    public void mover() {
        double chance = Math.random();

        if (chance <= ConstantesGerais.CHANCE_DE_MOVIMENTO) {
            int indice = MathUtils.InteiroAleatorioEntre(0, movimentosDisponiveis.size());
            Espaco movimento = movimentosDisponiveis.get(indice);

            // leblanc disse = deixar pra dps = n fazer :)
            espaco.limpar();
            movimento.setOrganismo(this);
        }
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Integer getDistanciaMovimento() {
        return distanciaMovimento;
    }

    public void setDistanciaMovimento(Integer distanciaMovimento) {
        this.distanciaMovimento = distanciaMovimento;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public List<Espaco> getMovimentosDisponiveis() {
        return movimentosDisponiveis;
    }

    public void setMovimentosDisponiveis(List<Espaco> movimentosDisponiveis) {
        this.movimentosDisponiveis = movimentosDisponiveis;
    }

}
