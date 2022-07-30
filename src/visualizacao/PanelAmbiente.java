package visualizacao;

import ambiente.Ambiente;
import ambiente.Espaco;
import controles.Mouse;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.JPanel;
import organismos.Organismo;

public class PanelAmbiente extends JPanel {

    private final Ambiente ambiente;
    private final Mouse mouse;
    private Organismo organismoSelecionado;
    
    private final static Color COR_PLANO_DE_FUNDO = Color.BLACK;
    private final static Font FONTE_INFORMACOES_ORGANISMO = new Font("Segoe UI", Font.BOLD, 18);
    private final int LARGURA_TELA, ALTURA_TELA;
    private final int LARGURA_ESPACO, ALTURA_ESPACO;
    
    public PanelAmbiente(Ambiente ambiente, int largura, int altura) {
        this.ambiente = ambiente;
        
        this.mouse = new Mouse(ambiente);
        addMouseListener(mouse);
        
        setPreferredSize(new Dimension(largura, altura));
        
        LARGURA_TELA = largura;
        ALTURA_TELA = altura;

        LARGURA_ESPACO = LARGURA_TELA / ambiente.getTamanho().width;
        ALTURA_ESPACO = ALTURA_TELA / ambiente.getTamanho().height;
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        configuraFiltros();
        renderizaAmbiente(graphics);
        renderizaOrganismos(graphics);
        renderizaOrganismoSelecionado(graphics);
    }

    private void configuraFiltros() {
        Graphics2D graphics2D = (Graphics2D) getGraphics();
        graphics2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
    }
    
    private void renderizaAmbiente(Graphics graphics) {
        graphics.setColor(COR_PLANO_DE_FUNDO);
        graphics.fillRect(0, 0, LARGURA_TELA, ALTURA_TELA);
    }
    
    private void renderizaOrganismos(Graphics graphics) {
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
                graphics.fillOval(xOrganismo, yOrganismo, LARGURA_ESPACO, ALTURA_ESPACO);
            }
        }
    }
    
    private void renderizaOrganismoSelecionado(Graphics graphics) {
        if (organismoSelecionado == null) {
            return;
        }
        
        graphics.setFont(FONTE_INFORMACOES_ORGANISMO);
        graphics.drawString(organismoSelecionado.getIdentificacao(), 10, 20);
    }
    
    public int getLarguraTela() {
        return this.LARGURA_TELA;
    }
    
    public int getAlturaTela() {
        return this.ALTURA_TELA;
    }
    
    public int getLarguraEspaco() {
        return this.LARGURA_ESPACO;
    }
    
    public int getAlturaEspaco() {
        return this.ALTURA_ESPACO;
    }
    
    public void setOrganismoSelecionado(Organismo organismo) {
        this.organismoSelecionado = organismo;
    }
    
}
