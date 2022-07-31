
package controles;

import ambiente.Ambiente;
import ambiente.Espaco;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import visualizacao.PanelAmbiente;
import visualizacao.PanelPropriedadesOrganismo;

public class Mouse implements MouseListener {

    private final Ambiente ambiente;
    private final PanelAmbiente painelAmbiente;
    private final PanelPropriedadesOrganismo panelPropriedades;
    
    public Mouse(Ambiente ambiente, PanelAmbiente painelAmbiente, PanelPropriedadesOrganismo panelPropriedades) {
        this.ambiente = ambiente;
        this.painelAmbiente = painelAmbiente;
        this.panelPropriedades = panelPropriedades;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Espaco espacoClicado = 
                getEspacoClicado(e.getX(), e.getY(), painelAmbiente);
        
        if (espacoClicado.isVazio()) {
            panelPropriedades.setOrganismoSelecionado(null);
        } else {
            panelPropriedades.setOrganismoSelecionado(espacoClicado.getOrganismo());
        }
    }

    private Espaco getEspacoClicado(int x, int y, PanelAmbiente painelAmbiente) {
        int xEspaco = x / painelAmbiente.getLarguraEspaco();
        int yEspaco = y / painelAmbiente.getAlturaEspaco();
        
        return ambiente.getEspacoNaCoordenada(xEspaco, yEspaco);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
