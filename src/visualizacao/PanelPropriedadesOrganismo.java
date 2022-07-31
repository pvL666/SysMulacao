package visualizacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import organismos.Organismo;

public class PanelPropriedadesOrganismo extends JPanel {

    private Organismo organismoSelecionado;

    private final static Color COR_INFORMACOES_ORGANISMO = Color.WHITE;
    private final static Font FONTE_INFORMACOES_ORGANISMO = new Font("Segoe UI", Font.BOLD, 18);

    public PanelPropriedadesOrganismo() {
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        renderizaOrganismoSelecionado(graphics);
    }

    private void renderizaOrganismoSelecionado(Graphics graphics) {
        if (organismoSelecionado == null) {
            return;
        }

        graphics.setColor(COR_INFORMACOES_ORGANISMO);
        graphics.setFont(FONTE_INFORMACOES_ORGANISMO);
        graphics.drawString(organismoSelecionado.getIdentificacao(), 10, 20);
    }

    public void setOrganismoSelecionado(Organismo organismo) {
        this.organismoSelecionado = organismo;
        
        repaint();
    }
}
