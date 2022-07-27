package visualizacao;

import ambiente.Ambiente;
import ambiente.Espaco;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import javax.swing.JPanel;
import organismos.Organismo;

public class PanelAmbiente extends JPanel {

    final Ambiente ambiente;

    final static Color COR_PLANO_DE_FUNDO = Color.BLACK;
    final int LARGURA_TELA, ALTURA_TELA;
    final int LARGURA_ESPACO, ALTURA_ESPACO;
    
    public PanelAmbiente(Ambiente ambiente, int largura, int altura) {
        this.ambiente = ambiente;
        
        setPreferredSize(new Dimension(largura, altura));
        
        LARGURA_TELA = largura;
        ALTURA_TELA = altura;

        LARGURA_ESPACO = LARGURA_TELA / ambiente.getTamanho().width;
        ALTURA_ESPACO = ALTURA_TELA / ambiente.getTamanho().height;
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        // Preenche com uma cor de fundo
        graphics.setColor(COR_PLANO_DE_FUNDO);
        graphics.fillRect(0, 0, LARGURA_TELA, ALTURA_TELA);

        // Renderiza os organismos
        List<List<Espaco>> ecossistemaAmbiente = ambiente.getEcossistema();

        for (List<Espaco> espacos : ecossistemaAmbiente) {
            for (Espaco espaco : espacos) {
                if (espaco.isVazio()) {
                    continue;
                }
                
                Organismo organismo = espaco.getOrganismo();
                Point posicaoOrganismo = espaco.getCoordenadas();
                
                int xOrganismo = posicaoOrganismo.x * LARGURA_ESPACO;
                int yOrganismo = posicaoOrganismo.y * ALTURA_ESPACO;
                
                graphics.setColor(new Color(255, 255, 255));
                graphics.fillRect(xOrganismo, yOrganismo, LARGURA_ESPACO, ALTURA_ESPACO);
            }
        }
    }

}
