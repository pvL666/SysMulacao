package ambiente;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Nadaletti
 */
public class Ambiente {

    private Dimension tamanho;
    private List<List<Espaco>> ecossistema = new ArrayList<List<Espaco>>();

    public Ambiente() {
    }

    public Ambiente(Integer largura, Integer altura) {
        tamanho = new Dimension(largura, altura);

        preencherEcossistema();
    }

    private void preencherEcossistema() {
        for (int i = 0; i < tamanho.width; i++) {
            ecossistema.add(new ArrayList<>());
            for (int j = 0; j < tamanho.height; j++) {
                ecossistema.get(i).add(new Espaco(i, j));
            }
        }
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
                ecoString = ecoString.concat(String.format(" %s ", espacoEcossistema.toString()));
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
