package ambiente;

import java.awt.Point;
import java.util.Objects;
import organismos.Organismo;

/**
 *
 * @author Nadaletti
 */
public class Espaco {

    private Organismo organismo;
    private Point coordenadas;

    public Espaco() {
    }

    public Espaco(Integer x, Integer y) {
        coordenadas = new Point(x, y);
    }

    public Espaco(Integer x, Integer y, Organismo organismo) {
        coordenadas = new Point(x, y);
        this.organismo = organismo;
    }

    public Organismo getOrganismo() {
        return organismo;
    }

    public void setOrganismo(Organismo organismo) {
        this.organismo = organismo;
        organismo.setEspaco(this);
    }

    public Point getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Point coordenadas) {
        this.coordenadas = coordenadas;
    }

    public boolean isVazio() {
        return organismo == null;
    }
    
    @Override
    public String toString() {
        return coordenadas.x + " " + coordenadas.y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.organismo);
        hash = 59 * hash + Objects.hashCode(this.coordenadas);
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
        final Espaco other = (Espaco) obj;
        if (!Objects.equals(this.organismo, other.organismo)) {
            return false;
        }
        return Objects.equals(this.coordenadas, other.coordenadas);
    }

}
