package visualizacao;

import ambiente.Ambiente;
import javax.swing.JFrame;

public class FrameNatura extends JFrame {

    public FrameNatura(Ambiente ambiente, int largura, int altura) {
        
        PanelAmbiente panelAmbiente = new PanelAmbiente(ambiente, largura, altura);
        add(panelAmbiente);
        pack();
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Natura");
        setVisible(true);   
    }


}
