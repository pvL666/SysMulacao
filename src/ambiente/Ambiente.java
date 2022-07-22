package ambiente;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import organismos.Organismo;
import utils.ConstantesGerais;

/**
 *
 * @author Nadaletti
 */
public class Ambiente {

    private Dimension tamanho;
    private List<List<Espaco>> ecossistema = new ArrayList<List<Espaco>>();
    private List<Organismo> organismos = new ArrayList<>();

    public Ambiente() {
    }

    public Ambiente(Integer largura, Integer altura) {
        tamanho = new Dimension(largura, altura);

        preencherEcossistema();
    }

    public void iterar() {
        for (Organismo organismo : organismos) {
            atualizaCasaOrganismo(organismo);
            organismo.iterar();
        }
    }

    private void preencherEcossistema() {
        for (int i = 0; i < tamanho.width; i++) {
            ecossistema.add(new ArrayList<>());
            for (int j = 0; j < tamanho.height; j++) {
                Espaco espaco = new Espaco(i, j);
                preencherEspaco(espaco);
                ecossistema.get(i).add(espaco);
            }
        }
    }

    private void preencherEspaco(Espaco espaco) {
        double chance = Math.random();

        if (chance <= ConstantesGerais.CHANCE_NASCER_ORGANISMO) {
            espaco.setOrganismo(new Organismo(espaco, Double.toString(chance), 1));
            adicionarOrganismo(espaco);
        }
    }

    private void adicionarOrganismo(Espaco espaco) {
        if (!espaco.isVazio()) {
            this.organismos.add(espaco.getOrganismo());
        }
    }

    private void atualizaCasaOrganismo(Organismo organismo) {
        int organismoX = organismo.getEspaco().getCoordenadas().x;
        int organismoY = organismo.getEspaco().getCoordenadas().y;

        int distancia = organismo.getDistanciaMovimento();

        List<Espaco> movimentosDisponiveis = new ArrayList<>();

        for (int x = organismoX - distancia; x <= organismoX + distancia; x++) {
            for (int y = organismoY - distancia; y <= organismoY + distancia; y++) {
                if (!isCoordenadaForaDoAmbiente(new Point(x, y))) {
                    movimentosDisponiveis.add(ecossistema.get(x).get(y));
                }
            }
        }

        organismo.setMovimentosDisponiveis(movimentosDisponiveis);
    }

    private boolean isCoordenadaForaDoAmbiente(Point coordenada) {
        return coordenada.x < 0 || coordenada.x >= tamanho.width
                || coordenada.y < 0 || coordenada.y >= tamanho.height;
    }

    public Dimension getTamanho() {
        return tamanho;
    }

    public void setTamanho(Dimension tamanho) {
        this.tamanho = tamanho;
    }

    public List<List<Espaco>> getEcossistema() {
        return ecossistema;
    }

    public void setEcossistema(List<List<Espaco>> ecossistema) {
        this.ecossistema = ecossistema;
    }

    @Override
    public String toString() {
        String ecoString = "";

        for (List<Espaco> ecossistema : this.ecossistema) {
            ecoString = ecoString.concat("|");

            for (Espaco espacoEcossistema : ecossistema) {
                if (espacoEcossistema.isVazio()) {
                    ecoString = ecoString.concat(ConstantesGerais.STRING_VAZIO);
                } else {
                    ecoString = ecoString.concat(ConstantesGerais.STRING_ORGANISMO);
                }
            }

            ecoString = ecoString.concat("| \n");
        }

        return ecoString;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.tamanho);
        hash = 23 * hash + Objects.hashCode(this.ecossistema);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ambiente other = (Ambiente) obj;
        if (!Objects.equals(this.tamanho, other.tamanho)) {
            return false;
        }
        return Objects.equals(this.ecossistema, other.ecossistema);
    }

}
