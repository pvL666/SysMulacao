package visualizacao;

import ambiente.Ambiente;
import controles.Mouse;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class FrameNatura extends JFrame {

    private final Mouse mouse;
    
    private final int CAMADA_PANEL_AMBIENTE = 1;
    private final int CAMADA_PANEL_PROPRIEDADES = 0;
    
    public FrameNatura(Ambiente ambiente, int largura, int altura) {
        
        Dimension dimensaoPaineis = new Dimension(largura, altura);
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(dimensaoPaineis);
        
        PanelAmbiente panelAmbiente = new PanelAmbiente(ambiente, dimensaoPaineis);
        panelAmbiente.setSize(dimensaoPaineis);
        
        PanelPropriedadesOrganismo panelPropriedades = new PanelPropriedadesOrganismo();
        panelPropriedades.setSize(dimensaoPaineis);
        
        mouse = new Mouse(ambiente, panelAmbiente, panelPropriedades);
        panelAmbiente.addMouseListener(mouse);
        
        layeredPane.add(panelAmbiente, CAMADA_PANEL_AMBIENTE);
        layeredPane.add(panelPropriedades, CAMADA_PANEL_PROPRIEDADES);
        
        add(layeredPane);
        pack();
        
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Natura");
        setVisible(true);
    }


}
