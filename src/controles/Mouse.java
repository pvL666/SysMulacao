
package controles;

import ambiente.Ambiente;
import ambiente.Espaco;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import organismos.Organismo;
import visualizacao.PanelAmbiente;

public class Mouse implements MouseListener {

    private Ambiente ambiente;
    
    public Mouse(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        PanelAmbiente painelAmbiente = (PanelAmbiente) e.getSource();
        Espaco espacoClicado = 
                getEspacoClicado(e.getX(), e.getY(), painelAmbiente);
        
        if (espacoClicado.isVazio()) {
            painelAmbiente.setOrganismoSelecionado(null);
        } else {
            painelAmbiente.setOrganismoSelecionado(espacoClicado.getOrganismo());
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
