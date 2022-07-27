package natura;

import ambiente.Ambiente;
import static java.lang.Thread.sleep;
import utils.ConstantesGerais;
import visualizacao.FrameNatura;

/**
 *
 * @author pvL
 */
public class Iniciar {

    public static void main(String[] args) {
        Ambiente ambiente = new Ambiente(10, 10);
        FrameNatura frameNatura = new FrameNatura(ambiente, 800, 800);
        
        Thread threadAmbiente = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(ambiente.toString());
                        frameNatura.repaint();
                        ambiente.iterar();
                        sleep(ConstantesGerais.MILISEGUNDOS_ENTRE_ITERACOES);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        
        threadAmbiente.start();
    }
    
}
